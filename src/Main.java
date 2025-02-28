import Auth.Authtentication;
import Auth.Login;
import Auth.Register;
import Auth.User;
import Cinema.CinemaSystem;
import Cinema.Movie;
import Cinema.Theater;
import Cinema.Tiket;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        User loggedIn = null;
        Login authLogin = new Login();
        Register authRegister = new Register();
        int auth_pilih;


        Scanner userInput = new Scanner(System.in);
        int pilihan;
        boolean ulang = true;

        Theater theater = new Theater("Cinema XXI");
        CinemaSystem cinemaSystem = new CinemaSystem(theater);

        ArrayList<String> genreAvangers = new ArrayList<>();
        genreAvangers.add("Action");
        genreAvangers.add("Sci-fi");
        genreAvangers.add("Adventure");

        ArrayList<String> genreMoneyHeist = new ArrayList<>();
        genreMoneyHeist.add("Action");
        genreMoneyHeist.add("Drama");
        genreMoneyHeist.add("Thriler");

        ArrayList<String> genreKimetsuNoYaiba = new ArrayList<>();
        genreKimetsuNoYaiba.add("Action");
        genreKimetsuNoYaiba.add("Adventure");

        theater.tambahFilm(new Movie("Money Heist", genreMoneyHeist, 45000));
        theater.tambahFilm(new Movie("Avangers", genreAvangers, 45000));
        theater.tambahFilm(new Movie("Kimetsu No Yaiba", genreKimetsuNoYaiba, 65000));


        while (loggedIn == null) {
            System.out.println("\n===========AUTHTENTICATION==============");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.print("Pilih : ");
            auth_pilih = userInput.nextInt();
            userInput.nextLine();
            System.out.println("==========================================");

            if (auth_pilih == 1) {
                System.out.println("\n===================LOGIN=================");
                String username;
                String password;
                System.out.print("Masukan username : ");
                username = userInput.nextLine();
                System.out.print("Masukan password : ");
                password = userInput.nextLine();
                System.out.println("===========================================\n");

                System.out.println("===================STATUS=================");
                loggedIn = authLogin.auth(username, password);
                if (loggedIn == null) {
                    System.out.println("Login gagal! Periksa username atau password");
                } else {
                    System.out.println("Login berhasil, Selamat datang " + username);
                }
                System.out.println("==========================================");

            } else if (auth_pilih == 2) {
                String username;
                String password;
                boolean isExist;
                System.out.println("\n===================REGISTER=================");
                System.out.print("Masukan username : ");
                username = userInput.nextLine();
                System.out.print("Masukan password : ");
                password = userInput.nextLine();
                System.out.println("=============================================\n");

                System.out.println("===================STATUS=================");
                isExist = authRegister.register(username, password);
                if (isExist) {
                    System.out.println("Register berhasil, silahkan login");
                } else {
                    System.out.println("Username sudah digunakan!");
                }
                System.out.println("==========================================");

            } else {
                System.out.println("Inputan tidak cocok, Mohon masukan pilihan 1 atau 2!");
            }
        }

        if (loggedIn != null) {
            while (ulang) {
                System.out.println("\n============TIKET BIOSKOP===========");
                System.out.println("1. Lihat Daftar Film");
                System.out.println("2. Pesan Tiket");
                System.out.println("3. Lihat Tiket yang Dipesan");
                System.out.println("4. Keluar");
                System.out.print("Pilih Menu : ");
                pilihan = userInput.nextInt();
                userInput.nextLine();

                switch (pilihan) {
                    case 1:
                        System.out.println("\n=============DAFTAR FILM " + theater.getNamaTheater() + "===============");
                        theater.tampilkanFilm();
                        System.out.println("================================================================");
                        ulang = getYesOrNo("Apakah anda ingin mengulanginya lagi ");
                        break;
                    case 2:
                        System.out.println("\n===========PESAN TIKET===========");
                        String judul;
                        System.out.print("Masukan judul film : ");
                        judul = userInput.nextLine();
                        cinemaSystem.pesanTiket(judul);
                        System.out.println("\n==================================");
                        ulang = getYesOrNo("Apakah anda ingin mengulanginya lagi ");

                        break;
                    case 3:
                        System.out.println("\n===========DETAIL TIKET============");
                        cinemaSystem.tampilkanTiket();
                        System.out.println("\n===================================");
                        ulang = getYesOrNo("Apakah anda ingin mengulanginya lagi ");

                        break;
                    case 4:
                        System.out.println("Keluar dari sistem");
                        ulang = false;
                        break;
                    default:
                        System.out.println("Pilihan tidak ada!");
                }
            }

            userInput.close();
        }
    }


    private static boolean getYesOrNo(String message) {
        boolean isUlang = true;
        String ulang;

        Scanner input = new Scanner(System.in);
        System.out.print(message + " (y/n) ? ");
        ulang = input.nextLine();

        if (ulang.equalsIgnoreCase("n")) {
            System.out.println("Keluar dari system");
            isUlang = false;

        } else if (!ulang.equalsIgnoreCase("y") && !ulang.equalsIgnoreCase("n")) {
            System.out.println("Inputan anda tidak cocok!, Mohon masukan y/n");
        }
        input.close();
        return isUlang;

    }

}
import Cinema.CinemaSystem;
import Cinema.Movie;
import Cinema.Theater;
import Cinema.Tiket;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        int pilihan;
        boolean ulang = true;

        Theater theater = new Theater("Cinema XXI");
        CinemaSystem cinemaSystem = new CinemaSystem(theater);

        theater.tambahFilm(new Movie("Money Heist", "Action", 45000));
        theater.tambahFilm(new Movie("Avangers", "Action", 45000));
        theater.tambahFilm(new Movie("Kimetsu No Yaiba", "Thriler", 65000));

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
                    System.out.println("\n=============DAFTAR FILM===============");
                    theater.tampilkanFilm();
                    System.out.println("\n=======================================");
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
                    System.out.println("Keluar dari system");

                    break;
                default:
                    System.out.println("Pilihan tidak ada!");
            }
        }

        userInput.close();

    }

    private static boolean getYesOrNo(String message) {
        boolean isUlang = true;
        String ulang;

        Scanner input = new Scanner(System.in);
        System.out.println(message + " (y/n) ? ");
        ulang = input.nextLine();

        if (ulang.equalsIgnoreCase("n")) {
            System.out.println("Keluar dari system");
            isUlang = false;
        }else if (!ulang.equalsIgnoreCase("y") && !ulang.equalsIgnoreCase("n")){
            System.out.println("Inputan anda tidak cocok!, Mohon masukan y/n");
        }
        return isUlang;

    }

}
package Cinema;

import java.util.ArrayList;
import java.util.Scanner;

public class CinemaSystem {
    private Theater theater;
    private ArrayList<Tiket> daftarTiket;

   public CinemaSystem(Theater theater){
        this.theater = theater;
        this.daftarTiket = new ArrayList<>();
    }

    public void pesanTiket(String judul){
        Movie filmDitemukan = null;
        for (Movie film : theater.getDaftarFilm()){
            if(film.getJudul().equalsIgnoreCase(judul)){
                filmDitemukan = film;
                break;
            }
        }

        if(filmDitemukan != null){
            int jumlahTiket;
            Scanner userInput = new Scanner(System.in);
            System.out.print("Masukan jumlah tiket : ");
            jumlahTiket = userInput.nextInt();

            Tiket tiketBaru = new Tiket(filmDitemukan,jumlahTiket);
            daftarTiket.add(tiketBaru);
            System.out.println("Tiket berhasil dipesan untuk film: "+filmDitemukan.getJudul());
        }else{
            System.out.println("Film dengan judul : "+ judul + " tidak ditemukan");
        }
    }

    public void tampilkanTiket(){
        if (daftarTiket.isEmpty()){
            System.out.println("Belum ada tiket yang ditambahkan");
        }else{
            System.out.println("Tiket yang sudah ditambahkan : ");
            for (Tiket tiket : daftarTiket){
                tiket.detailTiket();
            }
        }
    }
}

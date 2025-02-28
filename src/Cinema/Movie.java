package Cinema;

import java.util.ArrayList;

public class Movie {
    private String judul;
    private ArrayList<String> genre;
    private double hargaTiket;

   public Movie(String judul, ArrayList<String> genre, double hargaTiket){
        this.judul = judul;
        this.genre = genre;
        this.hargaTiket = hargaTiket;
    }

    public String getJudul(){
        return this.judul;
    }

    public double getHargaTiket(){
        return this.hargaTiket;
    }

    public void display(){
        System.out.println("Judul\t: " + this.judul);
        System.out.println("Genre\t: " + String.join(", ",genre));
        System.out.println("Harga: Rp " + String.format("%,.0f", hargaTiket));
        System.out.println();
    }

    public String toString(){
       return "Film : " + this.judul;
    }

}

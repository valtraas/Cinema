package Cinema;

public class Movie {
    private String judul;
    private String genre;
    private double hargaTiket;

   public Movie(String judul, String genre, double hargaTiket){
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
        System.out.println("Genre\t: " + this.genre);
        System.out.println("Harga Tiket\t : " + this.hargaTiket);
    }

    public String toString(){
       return "Film : " + this.judul;
    }

}

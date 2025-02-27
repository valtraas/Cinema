package Cinema;

public class Tiket {
    private Movie film;
    private int jumlahTiket;
    private double totalHarga;

    Tiket(Movie film, int jumlahTiket) {
        this.film = film;
        this.jumlahTiket = jumlahTiket;
        this.totalHarga = film.getHargaTiket() * jumlahTiket;
    }

    public void detailTiket() {
        System.out.println("Film\t: " + film.getJudul());
        System.out.println("Jumlah Tiket\t: " + this.jumlahTiket);
        System.out.println("Total Harga\t: Rp" + this.totalHarga);
    }
}

package Cinema;

import java.util.ArrayList;

public class Theater {
    private String namaTheater;
    private ArrayList<Movie> daftarFilm;

   public Theater(String namaTheater){
        this.namaTheater = namaTheater;
        this.daftarFilm = new ArrayList<>();
    }

    public String getNamaTheater(){
       return this.namaTheater;
    }

     public void tambahFilm(Movie film){
         daftarFilm.add(film);
//         System.out.println("Film " +film.getJudul()+ " Berhasil ditambahkan ke bioskop");
     }

     public ArrayList<Movie> getDaftarFilm(){
        return this.daftarFilm;
     }

     public void tampilkanFilm(){
        if (daftarFilm.isEmpty()){
            System.out.println("Tidak ada film yang tersedia saat ini ");
        }else{
            for(Movie film : daftarFilm){
                film.display();
            }
        }
     }
}

package Auth;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public abstract class Authtentication {
    protected static final String authFile = "auth.txt";
    protected ArrayList<User> daftarUser;

    public Authtentication(){
        daftarUser = new ArrayList<>();
        loadUser();

    }

    public void loadUser(){
        try{
            FileReader fileInput = new FileReader(authFile);
            BufferedReader br = new BufferedReader(fileInput);

            String line = br.readLine();
            while(line != null){
                String[] data = line.split(",");
                if(data.length == 3){
                    daftarUser.add(new User(data[0],data[1]));
                }
                line = br.readLine();
            }

        } catch (Exception e) {
            System.out.println("File tidak ditemukan, membuat file baru....");
        }
    }

    public void saveUser(){
        try{
            FileWriter fileOutput = new FileWriter(authFile);
            BufferedWriter bw = new BufferedWriter(fileOutput);

            for(User newUser : daftarUser){
                bw.write(newUser.getUsername()+","+newUser.getPassword()+","+newUser.getRole());
                bw.newLine();
            }
            bw.flush();

        } catch (Exception e) {
            System.out.println("Gagal menambahkan user ke file...");
        }
    }

    public abstract User auth(String username, String password);

    public String toString(){
        return "User : " + this.daftarUser;
    }

}

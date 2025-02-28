package Auth;

public class User {
    private String username;
    private String password;
    private String role = "user";

    public User(String username, String password, String role){
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }



    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }

    public String getRole(){
        return this.role;
    }

  @Override
    public String toString(){
        return "Username : " + this.username + " Password : "+ this.password;
  }






}

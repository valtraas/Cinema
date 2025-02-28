package Auth;

public class Login extends Authtentication{

    @Override
    public User auth(String username, String password){
        for (User user : daftarUser){
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    public void getUser(String username, String password){
        for (User user : daftarUser){
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                System.out.println(user);
            }
        }
    }

}

package Auth;

public class Register extends Authtentication{

    @Override
    public User auth(String username, String password){
        return null;
    }

    public boolean register(String username, String password){
        for(User user : daftarUser){
            if(user.getUsername().equals(username)){
                return false;
            }
        }

        daftarUser.add(new User(username,password));
        saveUser();
        return true;
    }


}

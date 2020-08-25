package datasource;

import lombok.Getter;

@Getter
public class UserClass {
    public UserClass(){
        userLogin = "locatortest@yandex.by";
        userPassword = "testlocator";
    }
    public UserClass(String login, String passw){
        this.userLogin = login;
        this.userPassword = passw;
    }
    private String userLogin;
    private String userPassword;
}

package pro.sujan.ee.beans;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

@Named
@SessionScoped
public class UserBean implements Serializable {
    @NotEmpty
    @Size(min = 3, max = 10)
    private String username;
    @NotEmpty
    @Size(min = 8)
    private String password;
    public String getUsername(){return username;}
    public String getPassword(){return password;}
    public void setUsername(String username){this.username = username;}
    public void setPassword(String password){this.password = password;}
}

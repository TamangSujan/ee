package pro.sujan.ee.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "login")
public class LoginEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int userId;
    public int getId(){
        return id;
    }
    public int getUserId(){
        return userId;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setUserId(int userId){
        this.userId = userId;
    }
}

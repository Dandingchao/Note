package entity;

import lombok.Data;
import java.lang.annotation.*;

@Data
public class DaddyDog {
    public static DaddyDog daddyDog;
    private String name;
    private int age;
    private Dog baby;
    public static DaddyDog getDaddyDog() {
        return daddyDog;
    }
    public void sayHi(){
        System.out.println("hi");
    }
}

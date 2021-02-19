package entity;

import lombok.Data;
import java.lang.annotation.*;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DaddyDog daddyDog = (DaddyDog) o;
        return age == daddyDog.age &&
                Objects.equals(name, daddyDog.name) &&
                Objects.equals(baby, daddyDog.baby);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, baby);
    }
}

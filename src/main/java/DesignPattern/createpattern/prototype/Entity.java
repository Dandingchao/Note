package designpattern.createpattern.prototype;

public class Entity implements Cloneable{
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Entity clone(){
        return new Entity().clone();
    }
}

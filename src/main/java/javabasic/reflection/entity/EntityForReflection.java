package javabasic.reflection.entity;

public class EntityForReflection {
    private String name;
    private Integer age;
    public String pName;
    public Integer pAge;
    private void printName(){
        System.out.println(getName());
    }
    public void printPName(){
        System.out.println(getpName());
    }


    public EntityForReflection() {
        this.name = "aaa";
        this.age = 125;
        this.pName = "paaa";
        this.pAge = 11;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public Integer getpAge() {
        return pAge;
    }

    public void setpAge(Integer pAge) {
        this.pAge = pAge;
    }
}

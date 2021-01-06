package designpattern.createpattern.builder;

public class BuilderConductor {
    public void BuildEntity(AbstractBuilder abstractBuilder){
        abstractBuilder.setAddress();
        abstractBuilder.setAge();
        abstractBuilder.setName();
        abstractBuilder.setSchool();
    }
}

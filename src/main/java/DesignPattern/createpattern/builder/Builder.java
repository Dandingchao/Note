package designpattern.createpattern.builder;
import  designpattern.createpattern.builder.BuilderEntity;

public class Builder extends designpattern.createpattern.builder.AbstractBuilder {
    private BuilderEntity builderEntity=new BuilderEntity();
    @Override
    public BuilderEntity getEntity()
    {
        return builderEntity;
    }
    @Override
    public void setName() {
        builderEntity.setName("sjdiaojsidao");
    }

    @Override
    public void setSchool() {
        builderEntity.setSchool("dsad");
    }

    @Override
    public void setAddress() {
        builderEntity.setAddress("djsaiodsa");
    }

    @Override
    public void setAge() {
        builderEntity.setAge(156);
    }
}

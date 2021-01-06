package designpattern.createpattern.builder;

public abstract class AbstractBuilder {
    public abstract void setName();

    public abstract void setSchool();

    public abstract void setAddress();

    public abstract void setAge();

    public abstract BuilderEntity getEntity();
}

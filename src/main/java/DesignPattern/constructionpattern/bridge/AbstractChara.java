package designpattern.constructionpattern.bridge;

public abstract class AbstractChara {
    protected Implementor implementor;
    public AbstractChara(Implementor implementor1){
        this.implementor=implementor1;
    }
    public abstract void saiHi();
}

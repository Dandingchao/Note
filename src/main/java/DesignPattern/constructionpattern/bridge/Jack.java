package designpattern.constructionpattern.bridge;

public class Jack extends AbstractChara{
    protected Jack(Implementor implementor){
        super(implementor);
    }
    @Override
    public void saiHi() {
        System.out.println("this is the wai I sai Hi,I'm Jack");
        implementor.saiHi();
    }
}

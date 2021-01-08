package designpattern.constructionpattern.decorator;

public class Decorator implements Man{
    protected Man man;
    public Decorator(Man man){
        this.man=man;
    }
    @Override
    public void saiHi() {
        man.saiHi();
        dedede();
    }
    public void dedede(){
        System.out.println("sjadio");
    }
}

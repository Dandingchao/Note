package designpattern.constructionpattern.flyweight;

public class UnsharedInform {
    private String message;
    public UnsharedInform(String info){
        this.message=info;
    }
    public void saiMessage(){
        System.out.println(message);
    }
    public String getMessage(){
        return this.message;
    }
}

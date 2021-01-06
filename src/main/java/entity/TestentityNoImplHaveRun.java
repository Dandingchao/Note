package entity;
//不能由Thread创建线程
public class TestentityNoImplHaveRun {

    private String name;
    private Integer count;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void run(){
        System.out.println("Am I can be a Thread?");
    }
}

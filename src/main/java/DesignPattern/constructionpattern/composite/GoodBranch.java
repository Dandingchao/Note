package designpattern.constructionpattern.composite;

import java.util.*;

public class GoodBranch implements Good{
    private List<Good> list =new ArrayList<>();
    public void addGood(Good good){
        list.add(good);
    }
    public void removeGood(Good good){
        list.remove(good);
    }
    public Good getChildGood(int index){
        return list.get(index);
    }
    @Override
    public Integer countPrice() {
        Integer sum=0;
        for (Good good:
             list) {
            sum+=good.countPrice();
        }
        return sum;
    }
}

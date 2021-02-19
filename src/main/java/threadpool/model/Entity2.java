package threadpool.model;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class Entity2 implements Runnable{
    private List<Integer> list;

    public Entity2() {
        this.list = new ArrayList<Integer>(10);
    }

    @Override
    public void run() {
        System.out.println(list.get(11));
    }
}

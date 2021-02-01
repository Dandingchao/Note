package spring.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountServer {
    private List<Integer> list;

    public CountServer() {
        list = new ArrayList<>(10);
        list.add(10);
        list.add(2);
    }

    public int rightCount() {
        return list.get(0);
    }

    public int wrongCount() {
        int res;
            System.out.println(list.size());
            res = list.get(list.size());
        return res;
    }
}

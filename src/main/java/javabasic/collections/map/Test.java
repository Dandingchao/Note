package javabasic.collections.map;

import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class Test {
    public static void main(String[] args) {
        Map map=new Map();
        java.util.Map hashMap=map.getHashMap();
        java.util.Map treeMap=map.getTreeMap();
        hashMap.put("1",2131);
        hashMap.put("2",45);
        hashMap.put("3",48);
        for (int i=0;i<100;i++){
            Double value=(Math.random()*100);
            treeMap.put(String.valueOf(i),value.intValue());
        }
        List<java.util.Map.Entry<String, Integer>> list=map.sort(map.getTreeMap());
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~");
        map.visit(map.getHashMap());
    }


}

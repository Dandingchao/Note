package javabasic.collections.map;

import lombok.Data;

import java.util.*;

@Data
public class Map{
    private java.util.Map<String, Integer> hashMap=new java.util.HashMap<>();
    private java.util.Map<String, Integer> treeMap=new TreeMap<>();
    public static void visit(java.util.Map<String, Integer> hashMap){
        if (hashMap!=null) {
            for (String key:hashMap.keySet()){
                System.out.println(hashMap.get(key));
            }

            for (java.util.Map.Entry entry:hashMap.entrySet()){
                System.out.println(entry.getValue());
            }
        }
    }

    public List<java.util.Map.Entry<String, Integer>> sort(java.util.Map<String, Integer> map){
        Set<java.util.Map.Entry<String, Integer>> set=map.entrySet();
        List<java.util.Map.Entry<String, Integer>> list=new ArrayList<>(map.entrySet());
        Collections.sort(list,new Comparator<java.util.Map.Entry<String, Integer>>(){
            @Override
            public int compare(java.util.Map.Entry<String, Integer> o1, java.util.Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        return list;
    }

}

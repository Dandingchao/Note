package Tree;

import java.util.Arrays;

public class Test {
    @org.junit.Test
    public void test (){
        Btree note =new Btree();
        note.setValue(50);
        for (int i=0;i<15;i++){
            Btree newnode=new Btree();
            newnode.setValue((int)(Math.random()*100));
            Btree.insert(note,newnode);
        }
        Btree.preOrderBtree1(note);
        System.out.println();
        Btree.preOrderBtree2(note);
        System.out.println("--------------------------");
        Btree.midOrderBtree1(note);
        System.out.println();
        Btree.midOrderBtree2(note);
        Btree.lasOrderBtree1(note);
        System.out.println();
        Btree.lasOrderBtree2(note);
        Btree.layerVisit(note);
        System.out.println();
        System.out.println(Btree.isBalance(note));
        int [] test =new int[10];
        for (int i=0;i<10;i++){
            test[i]=i;
        }
        int [] a= Arrays.copyOfRange(test,0,0);
        System.out.println(a.length);
    }
}

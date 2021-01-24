package Tree;

import java.util.*;

public class Btree {
    private Btree letf;
    private Btree right;
    private int value;

    public Btree getLetf() {
        return letf;
    }

    public Btree getRight() {
        return right;
    }

    public int getValue() {
        return value;
    }

    public void setLetf(Btree letf) {
        this.letf = letf;
    }

    public void setRight(Btree right) {
        this.right = right;
    }

    public void setValue(int value) {
        this.value = value;
    }
    //翻转
    public static Btree reverse(Btree root){
        if (root==null)
            return null;
        Btree left=root.letf;
        root.setLetf(root.getRight());
        root.setRight(left);
        reverse(root.getLetf());
        reverse(root.getRight());
        return root;
    }
    //插入二叉搜索树
    public static Btree insert(Btree root,Btree node){
        if (root==null)
            return node;
        if (node==null)
            return root;
        if (root.getValue()>=node.getValue()){
            if (root.getRight()==null){
                root.setRight(node);
            }else{
                insert(root.getRight(),node);
            }
        }else{
            if (root.getLetf()==null){
                root.setLetf(node);
            }else{
                insert(root.getLetf(),node);
            }
        }
        return root;
    }

    public static void preOrderBtree1(Btree root){
        if (root!=null){
            System.out.print(root.getValue()+" ");
            preOrderBtree1(root.getLetf());
            preOrderBtree1(root.getRight());
        }
    }

    public static void preOrderBtree2(Btree root){
        Stack<Btree> stack=new Stack<>();
        while (root!=null){
            System.out.print(root.getValue()+" ");
            if (root.getRight()!=null)
                stack.push(root.getRight());
            if (root.getLetf()!=null){
                root=root.getLetf();
            } else if (!stack.empty()){
                root=stack.pop();
            } else {
                break;
            }
        }
        System.out.println();
    }

    public static void midOrderBtree1(Btree root){
        if (root!=null){
            midOrderBtree1(root.getLetf());
            System.out.print(root.getValue()+" ");
            midOrderBtree1(root.getRight());
        }
    }

    public static void midOrderBtree2(Btree root){
        Btree node=root;
        Stack<Btree> stack=new Stack<>();
        while (node!=null||!stack.empty()){
            while (node!=null) {
                stack.push(node);
                node=node.getLetf();
            }
            node=stack.pop();
            System.out.print(node.getValue()+" ");
            node=node.getRight();
        }
        System.out.println();
    }

    public static void lasOrderBtree1(Btree root){
        if (root!=null){
            lasOrderBtree1(root.getLetf());
            lasOrderBtree1(root.getRight());
            System.out.print(root.getValue()+" ");
        }
    }
    //设置标志，记录子节点是否被遍历过，同事设置标志左子节点是否被遍历过
    public static void lasOrderBtree2(Btree root){
        Stack<Integer> res =new Stack<>();
        Stack<Btree> src=new Stack<>();
        Btree pr=null;
        boolean flag=false;
        while (root!=null||!src.empty()){
            if (root!=null&&!flag){
                src.push(root);
                root=root.getLetf();
            }else{
                root=src.peek();
                if(root.getRight()!=null&&root.getRight()!=pr){
                    root=root.getRight();
                    flag=false;
                }else {
                    System.out.print(root.getValue()+" ");
                    pr=root;
                    root=null;
                    flag=true;
                    src.pop();
                }
            }
        }
    }
    //后序遍历顺序，左子节点，右子节点，根节点  先序遍历顺序根节点，左子节点，右子节点，中序遍历顺序左子节点，根节点，右子节点
    public static void lasOrderBtree3(Btree root){
        Stack<Btree> stack=new Stack<>();
        Stack<Btree> stack1=new Stack<>();
        while (root!=null||!stack.empty()) {
            while (root!=null){
                stack1.push(root);
                stack.push(root);
                root=root.getRight();
            }
            root=stack.pop();
            root=root.getLetf();
        }
        while (!stack1.empty()){
            System.out.print(stack1.pop().getValue()+" ");
        }
    }
    //层次遍历
    public static void layerVisit(Btree root){
        Queue<Btree> queue=new LinkedList<>();
        int floor=0;
        int lastFloorNum=1;
        int nextFloorNum=0;
        int thisFloorNUm=0;
        while (root!=null||!queue.isEmpty()){
            System.out.print(root.getValue()+" ");
            thisFloorNUm++;
            if (root.getLetf()!=null){
                queue.add(root.getLetf());
                nextFloorNum++;
            }
            if (root.getRight()!=null){
                queue.add(root.getRight());
                nextFloorNum++;
            }
            if (thisFloorNUm==lastFloorNum){
                thisFloorNUm=0;
                lastFloorNum=nextFloorNum;
                nextFloorNum=0;
            }
            root=queue.poll();
        }
    }
    //
    public static int isBalance(Btree root){
        if (root==null)
            return 0;
        if (root.getRight()==null&&root.getLetf()==null)
            return 1;
        if (root!=null)
        {   int cha=isBalance(root.getRight())-isBalance(root.getLetf());
            if (cha>1||cha<-1)
            {
                System.out.println("this tree is not balanced");
            }
            return cha;

        }return 0;
    }
    //根据前序和中序,前序根节点返回二叉树，问题在于如果在中序之前出现与根节点相同值则会出现错误。

    public Btree preAndMid(int[] pre,int[] mid){
        if (mid.length==0||pre.length==0)
            return null;
        Btree node=new Btree();
        node.setValue(pre[0]);
        int index=0;
        for (int i=0;i<mid.length;i++){
            if (mid[i]==pre[0]) {
                index=i;
                break;
            }
        }
        node.setLetf(preAndMid(Arrays.copyOfRange(pre,1,index),Arrays.copyOfRange(mid,0,index)));
        node.setRight(preAndMid(Arrays.copyOfRange(pre,index,pre.length),Arrays.copyOfRange(mid,index+1,mid.length)));
        return node;
    }

}
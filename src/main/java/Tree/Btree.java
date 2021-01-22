package Tree;

import java.util.Stack;

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
    public Btree reverse(Btree root){
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
    public Btree insert(Btree root,Btree node){
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

    public void preOrderBTree1(Btree root){
        if (root!=null){
            System.out.println(root.getValue());
            preOrderBTree1(root.getLetf());
            preOrderBTree1(root.getRight());
        }
    }

    public void preOrderBtree2(Btree root){
        Stack<Btree> stack=new Stack<>();
        while (root!=null){
            System.out.println(root.getValue());
            if (root.getRight()!=null)
                stack.push(root.getRight());

        }
    }

    public void midOrderBtree1(Btree root){
        if (root!=null){
            midOrderBtree1(root.getLetf());
            System.out.println(root.getValue());
            midOrderBtree1(root.getRight());
        }
    }

    public void lasOrderBtree1(Btree root){
        if (root!=null){
            lasOrderBtree1(root.getLetf());
            lasOrderBtree1(root.getRight());
            System.out.println(root.getValue());
        }
    }
}

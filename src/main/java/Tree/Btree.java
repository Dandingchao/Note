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
            if (root.getLetf()!=null){
                root=root.getLetf();
            } else if (!stack.empty()){
                root=stack.pop();
            } else {
                break;
            }
        }
    }

    public void midOrderBtree1(Btree root){
        if (root!=null){
            midOrderBtree1(root.getLetf());
            System.out.println(root.getValue());
            midOrderBtree1(root.getRight());
        }
    }

    public void midOrderBtree2(Btree root){
        Btree node=root;
        Stack<Btree> stack=new Stack<>();
        while (node!=null){
            while (node.getLetf()!=null) {
                stack.push(node);
                node=node.getLetf();
            }
            node=stack.pop();
            System.out.println(node.getValue());
            if (node.getRight()!=null){
                node=node.getRight();
            }else if (!stack.empty())
            {
                node=stack.pop();
            }else {
                break;
            }
        }
    }

    public void lasOrderBtree1(Btree root){
        if (root!=null){
            lasOrderBtree1(root.getLetf());
            lasOrderBtree1(root.getRight());
            System.out.println(root.getValue());
        }
    }

    public void lasOrderBtree2(Btree root){
        Stack<Integer> res =new Stack<>();
        Stack<Btree> src=new Stack<>();
        Btree pr=null;
        while (root!=null){
            res.push(root.getValue());
            if (root.getLetf()!=null){
                src.push(root.getLetf());
            }
            if (root.getRight()!=null){
                root=root.getRight();
            }
        }
    }
}

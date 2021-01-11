package designpattern.actionpattern.Iterator;

import java.util.List;

public class ConcreteIterator implements Iterator{
    private List<Object> list=null;
    private int index=-1;

    public ConcreteIterator(List<Object> list) {
        this.list = list;
    }

    @Override
    public Object first() {
        index=0;
        return list.get(0);
    }

    @Override
    public Object next() {
        Object object=null;
        if(this.hasNext()){
            object= list.get(++index);
        }
        return object;
    }

    @Override
    public boolean hasNext() {
        if(index<list.size()-1){
            return true;
        }else {
            return false;
        }
    }
}

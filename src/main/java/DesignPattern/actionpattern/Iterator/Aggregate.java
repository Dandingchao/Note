package designpattern.actionpattern.Iterator;

interface Aggregate {
    public void add(Object object);
    public void remove(Object object);
    public Iterator getIterator();
}

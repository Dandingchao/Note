package juc.concurrentcollection;

import java.util.concurrent.*;


//除了juc下的并发集合外，还可以用collections.synchronized方法构建线程安全的集合，list,set,map。 vector和hashtable
public class Collections {
    private ConcurrentHashMap concurrentHashMap;
    private ConcurrentSkipListMap concurrentSkipListMap;
    private ConcurrentSkipListSet concurrentSkipListSet;
    private ConcurrentLinkedDeque concurrentLinkedDeque;
    private ConcurrentLinkedQueue concurrentLinkedQueue;
    private CopyOnWriteArraySet copyOnWriteArraySet;
    private CopyOnWriteArrayList copyOnWriteArrayList;
}

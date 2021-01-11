package designpattern.actionpattern.meditator;

import java.util.ArrayList;
import java.util.List;

public class ConcreteMediator extends Mediator{
    List<Colleague> colleagueList=new ArrayList<>();
    @Override
    public void register(Colleague colleague) {
     if (!colleagueList.contains(colleague)){
         colleagueList.add(colleague);
         colleague.setMediator(this);
     }
    }

    @Override//转发函数，我个人感觉可以在recive中添加参数，但是给的例子没有添加参数，应该上某个成员发送请求，这个请求如果包含请求信息的话
    //应该作为参数代入
    public void relay(Colleague colleague) {
        for (Colleague co:colleagueList
             ) {
            if (colleague!=null){
                co.recive();
            }
        }
    }
}

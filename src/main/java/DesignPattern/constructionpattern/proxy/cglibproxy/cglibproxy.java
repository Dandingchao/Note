package designpattern.constructionpattern.proxy.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class cglibproxy implements MethodInterceptor {
    private Object object;

    public cglibproxy(Object o){
        this.object=o;
    }

    public Object getProxyInstance(){
        Enhancer enhancer=new Enhancer();

        enhancer.setSuperclass(object.getClass());//设置父类

        enhancer.setCallback(this);//设置回调函数.指向下面那个intercept

        return enhancer.create();//返回创建好的代理类
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("I'cglib moder before");
        //Object result=methodProxy.invoke(this.object,objects);
        //Object result=methodProxy.invoke(o,objects);//由于调用的o是自身的o，会造成无限的代理类调用代理类，栈溢出
        Object result=methodProxy.invokeSuper(o,objects);//invoke方法调用生成的代理类的代理方法，invokesuper调用直接调用被代理类
        //的代理方法，invoke的o参数是被代理的类，如果你把这个o参数写成intercept本身参数中的o的话就会导致这个方法不停的调用自己执行(intercept)造成
        //stackoverflow

        System.out.println("cglib end");
        return result;
    }
}

package DesignPattern.proxy.dynamicmethod;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/**
* @Description:
 * 动态代理在Java中有着广泛的应用，如Spring AOP，Hibernate数据查询、测试框架的后端mock、RPC，Java注解对象获取等。
 * 动态代理的代理关系是在运行时期确定的。接下来主要阐述两种动态代理的区别。
 *
 *
 * 1、JDK动态代理具体实现原理：
 *
 * 通过实现InvocationHandler接口创建自己的调用处理器；
 *
 * 通过为Proxy类指定ClassLoader对象和一组interface来创建动态代理；
 *
 * 通过反射机制获取动态代理类的构造函数，其唯一参数类型就是调用处理器接口类型；
 *
 * 通过构造函数创建动态代理类实例，构造时调用处理器对象作为参数参入；
 *
 * JDK动态代理是面向接口的代理模式，如果被代理目标没有接口那么Spring也无能为力，
 *
 * Spring通过Java的反射机制生产被代理接口的新的匿名实现类，重写了其中AOP的增强方法。
* @Param:  
* @returns:  
* @Author: ypc 
* @Date: 2021/1/6 10:39
* @packageName: DesignPattern.proxy.dynamicmethod
*/
public class comunicationProxy implements InvocationHandler{
    //维护一个目标对象
    private Object target;
    public comunicationProxy(Object target){
        this.target=target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始事务2");
        System.out.println(method.getName());
        //执行目标对象方法
        Object returnValue = method.invoke(target, args);
        System.out.println("提交事务2");
        return returnValue;

    }
    //给目标对象生成代理对象
    public Object getProxyInstance(){
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this::invoke);
    }

}

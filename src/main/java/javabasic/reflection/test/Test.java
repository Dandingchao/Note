package javabasic.reflection.test;

import javabasic.reflection.entity.EntityForReflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
    @org.junit.Test
    public void test(){
        EntityForReflection entityForReflection=new EntityForReflection();
        try {
            Class t=EntityForReflection.class;//通过类获取类
            EntityForReflection entityForReflection1=(EntityForReflection) t.newInstance();//通过类获取一个类的对象，只能调用无参构造
            //Class t=entityForReflection.getClass();//通过对象获取类
            //Class t=Class.forName("javabasic.reflection.entity.EntityForReflection");用该方法要抛异常
            //获取属性
            Field[] fields=t.getFields();//获取属性列表
            Field pfield=t.getField("pName");//用于public field
            Field filed=t.getDeclaredField("name");//用于所有field
            filed.setAccessible(true);//获取private属性，设其为可以访问状态
            System.out.println(pfield.get(entityForReflection));
            System.out.println(filed.get(entityForReflection));

            //获取方法
            Method method=t.getMethod("setAge", Integer.class);//获取该方法
            Method[] method1=t.getMethods();//获取方法列表
            for (int i=0;i<method1.length;i++)
                System.out.println(method1[i]);
            method.invoke(entityForReflection,55);//输入对象，参数
            System.out.println(entityForReflection.getAge());

        } catch (NoSuchFieldException | IllegalAccessException | NoSuchMethodException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}

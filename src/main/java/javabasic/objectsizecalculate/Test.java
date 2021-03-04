package javabasic.objectsizecalculate;

public class Test {
    @org.junit.Test
    public void test(){
        String a="dcfsjaiodsa";
        final ClassIntrospector ci = new ClassIntrospector();
        ObjectInfo res;
        try {
            res = ci.introspect(a);
            System.out.println(res.getDeepSize());
            res=ci.introspect(new String());
            System.out.println(res.getDeepSize());
            System.out.println();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

package designpattern.createpattern.builder;

public class Test {
    public static void main(String[] args) {
        AbstractBuilder abstractBuilder=new Builder();
        BuilderConductor builderConstructor=new BuilderConductor();
        builderConstructor.BuildEntity(abstractBuilder);
        System.out.println(abstractBuilder.getEntity());
    }
}

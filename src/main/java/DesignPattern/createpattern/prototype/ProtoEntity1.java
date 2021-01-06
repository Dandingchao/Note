package designpattern.createpattern.prototype;


/**
* @Description: 原型模式就是复制一个原先的对象数据放到一个新对象里面
 * 实现浅克隆，原型模式复制一个原先的对象 ,与之相对的深克隆需要将引用的对象也复制一个出来
 *当然，拥有的那个对象同样需要实现克隆方法，如果你不实现克隆方法的话，那你就手动new一个出来。然后指过去
 * Java的三种克隆模式中还有一种是通过序列化进行的，目前懒得看
* @Param:  
* @returns:  
* @Author: ypc 
* @Date: 2021/1/6 14:40
* @packageName: designpattern.prototype
*/
public class ProtoEntity1 implements Cloneable{

    private String name;

    private Entity Obejct;
    public void sayHi(){
        System.out.println("Hi my name is "+name);
    }
    
    public Object clone() throws CloneNotSupportedException {
        System.out.println("cloning");
        ProtoEntity1 protoEntity1=(ProtoEntity1) this.clone();
        protoEntity1.setObejct((Entity) protoEntity1.getObejct().clone());
        return (ProtoEntity1) super.clone();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Entity getObejct() {
        return Obejct;
    }

    public void setObejct(Entity obejct) {
        Obejct = obejct;
    }

}

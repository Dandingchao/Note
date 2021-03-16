package Designpattern.createpattern.builder;
/**
* @Description:  构造者模式的目的在于将实体的创建与定义分离，在创建一些实体类中有些不需要一开始就定义的参数的时候可以用构造者模式.
 * 简化构造函数的写法
 * 但我个人觉得，好像不是很重要这玩意，这就是单纯的把构造函数写到另一个文件里去了，用另一个函数来实现，算是解耦吧。。。
 *
* @Param:
* @returns:
* @Author: ypc
* @Date: 2021/1/6 16:12
* @packageName: designpattern.builder
*/
public class BuilderEntity {
    private String name;
    private String school;
    private String address;
    private Integer age;

    @Override
    public String toString() {
        return "BuilderEntity{" +
                "name='" + name + '\'' +
                ", school='" + school + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}

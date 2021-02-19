package log;
/**
* @Description: 枚举类型，和static类型差不多，自动初始化实例化，直接调用，HI,HL,T1这些，就是自动实例化，括号内为实例化
 * 的参数，定义在后面的构造函数中。
* @Param:  
* @returns:  
* @Author: ypc 
* @Date: 2021/1/18 16:27
* @packageName: log
*/
public enum Enum1 {
    HI(100,"sad"),
    HL(200,"ttt"),
    T1(500,"sdjka");

    private int code;
    private final String word;
    Enum1(int code,String word){
        this.code=code;
        this.word=word;
    }
    public int code(){
        return this.code;
    }
    public void setCode(int code){
        this.code=code;
    }
}

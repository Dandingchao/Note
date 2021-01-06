package entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class UserInfo {
    private String logname;
    private String pwd;
    private String UsernameCN;
    public void setLogname(String name,int i){
        this.logname=name;
        System.out.println(i);
    }
    public int setPwd(String pwd,int i){
        this.pwd=pwd;
        return i;
    }
}

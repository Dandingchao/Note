package log;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class Test {
    private static final Logger logger=  LoggerFactory.getLogger(Test.class);
    @org.junit.Test
    public void test(){
        System.out.println(Enum1.HI.code()+Enum1.HL.code());
        Enum1.HL.setCode(500);
        System.out.println(Enum1.HL.code());
    }
}

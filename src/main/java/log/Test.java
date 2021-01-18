package log;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class Test {
    private static final Logger logger=  LoggerFactory.getLogger(Test.class);
    @org.junit.Test
    public void test(){
        //log.debug("debug");
        logger.error("debug");
        int[] index=new int[5];


    }
}

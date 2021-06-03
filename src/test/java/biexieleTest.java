import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.Assert;

import java.io.*;
import java.util.HashMap;

public class biexieleTest {
@Test
    public void test(){
    File f=new File("");
    try {
        FileInputStream fileInputStream=new FileInputStream(f);
        InputStreamReader  inputStreamReader=new InputStreamReader(fileInputStream);
        BufferedReader bf=new BufferedReader(inputStreamReader);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }


    for (int i=0;i<1;++i){
        System.out.println(i);
    }
}
}
package spring.aspect;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class AfterServer {
    public void sayOver(){
        System.out.println("Server is overed");
    }
}

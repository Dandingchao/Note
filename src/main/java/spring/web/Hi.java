package spring.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nihaoa")
public class Hi {
    @RequestMapping(value = "/sayhi")
    public String a(){
        return "nihaoa";
    }
}

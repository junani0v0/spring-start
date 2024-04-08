package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "가나다라!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name,Model model ) {
        //외부에서 파라미터 받고 model에 담음
    model.addAttribute("name",name);    //파라미터로 넘어온 name을 model에 담아 넘겨줌
    return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody   //http에서 응답body부에 아래 데이터를 직접 넣어준다는 뜻
    public String helloString(@RequestParam("name") String name){
        return "hello " + name; //이문자가 요청한 클라이언트에게 문자 그대로 넘어감
        //템플릿 엔진과 달리 뷰가 없이 이 문자가 그대로 보내진다
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name); //파라미터로 넘어온 값으로 저장
        return hello;   //객체로 반환하고 ResponseBody하면 요즘은 Json반환이 기본
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

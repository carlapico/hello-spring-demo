package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello () {
//        return "Hello, Spring!";
//    }
    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye () {
        return "Goodbye, Spring!";
    }

    // Create handler that handles the requests of the form /hello?name=LaunchCode
//    @GetMapping("hello")
//    @PostMapping("hello")
    // the below will handle what we want above to do // Responds to get and post requests at /hello?coder=LaunchCoder
    @RequestMapping(method={RequestMethod.GET, RequestMethod.POST}, value="hello")
    @ResponseBody
    public String helloWithQueryParam( @RequestParam String name) {
        return "Hello, " + name +  "!";
    }

    // Create handler that handles the requests of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloWithPathParam ( @PathVariable String name) {
        return "Hello, " + name +  "!";
    }

    @GetMapping ("form")
    @ResponseBody
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" + //submits a request to /hello
                "<input type='text' name='name'>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }


}

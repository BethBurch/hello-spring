package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value="hello")
@ResponseBody
//todo: IF ITS ABOVE THE CLASS IT APPLIES TO ALL THE CONTROLLERS
//Note that we use @RequestMapping on the class.
//@GetMapping and @PostMapping cannot be applied at the class level.

public class HelloController {
    //  the get mapping is what can be added to the url to bring up a specific page. localhost:8080/hello gives Hello Spring
    // localhost:8080/goodbye gives GoodBye Spring
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    // responds to /hello/goodbye
    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "GoodBye, Spring!";
    }

//    //    Creating a Dynamic AKA working Query where you use the stored value (aka user input) and then use it.
//    @GetMapping("hello")
//    @ResponseBody
//    public String dynamicWorkingQuery(@RequestParam String input) {
//        return "Hello, " + input + "!";


    // Responds to get and post requests at /hello?input=LaunchCoder
@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
@ResponseBody
public String hello(@RequestParam String input) {
    return "Hello, " + input + "!";
    }

    // Responds to get requests at /hello/(whatever name was entered)
    @GetMapping("{input}")
    @ResponseBody
    public String helloAgain(@PathVariable String input) {
        return "Hello, " + input + "!!!";
    }
    //responds with hello/form because of @requestmapping
    @GetMapping("form")
    @ResponseBody
    public String helloForm() {
        String html =
                "<html>" +
                        "<body>" +
                        "<form method = 'post' action = '/hello'>" +
                        "<input type = 'text' name = 'input' />" +
                        "<input type = 'submit' value = 'Greet Me!' />" +
                        "</form>" +
                        "</body>" +
                        "</html>";
        return html;
//        this Map Method pulls in the post method on line 37(bookmark) and 56(bookmark) as the action using HTML to create a button
        // keep a close look at the quotations used
    }

    }

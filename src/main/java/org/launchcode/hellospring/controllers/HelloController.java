package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller

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
    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
    public String hello(@RequestParam String input, Model model) { //@RequestParam String Language {
        // to create the pretty text we need to make a varible
        //work from the outside in where is the text located
        //under class, then method then the parameters
        String theGreeting = "Hello, " + input + "!";
        model.addAttribute("greeting",theGreeting);
//TODO:        String languageGreeting = HelloController.createMessage(input, Language);
        //now return the varible holding the greeting and make it pretty with HTML
//TODO        return "<h4 style = 'color:forestgreen;'>" + languageGreeting + "</h4>";
        return "hello";
    }

    // Responds to get requests at /hello/(whatever name was entered)
    @GetMapping("hello/{input}")
    public String helloAgain(@PathVariable String input, Model model) {
        model.addAttribute("greeting","Ello, " + input + "!");
        return "hello";
    }

    //responds with hello/form because of @requestmapping
    @GetMapping("form")
    public String helloForm() {

        return "form";
    }
    @GetMapping("hello-languages")
    public String helloLanguages(Model model) {
      List<String> listedLanguages = new ArrayList<>();
      listedLanguages.add("GAYY");
      listedLanguages.add("Midwestern");
      listedLanguages.add("Spanish");
      listedLanguages.add("English");
      listedLanguages.add("French");
      model.addAttribute("languages", listedLanguages);
        return "hello-list";
    }
//        this Map Method pulls in the post method on line 37(bookmark) and 56(bookmark) as the action using HTML to create a button
        // keep a close look at the quotations used

//    public static String createMessage(String name, String Language) {
//        String greeting = "";
//
//        if (Language.equals("english")) {
//            greeting = "Hello";
//        }
//        else if (Language.equals("french")) {
//            greeting = "Bonjour";
//        }
//        else if (Language.equals("gay")) {
//            greeting = "Yassss Queen!";
//        }
//        else if (Language.equals("spanish")) {
//            greeting = "Hola";
//        }
//        else if (Language.equals("midwestern")) {
//            greeting = "Hey Yeah!";
//        }
//
//        return greeting + " " + name;
//    }


}


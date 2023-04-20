package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "hello")
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

    public String hello(@RequestParam String input, @RequestParam String Language) {
        // to create the pretty text we need to make a varible
        //work from the outside in where is the text located
        //under class, then method then the parameters
        String languageGreeting = HelloController.createMessage(input, Language);
        //now return the varible holding the greeting and make it pretty with HTML
        return "<h4 style = 'color:forestgreen;'>" + languageGreeting + "</h4>";
    }

    // Responds to get requests at /hello/(whatever name was entered)
    @GetMapping("{input}")
    public String helloAgain(@PathVariable String input) {
        return "Hello, " + input + "!!!";
    }

    //responds with hello/form because of @requestmapping
    @GetMapping("form")
    public String helloForm() {
//  <label for="pet-select">Choose a pet:</label>
// HOW TO SELECT STATEMENT
//<select name="pets" id="pet-select">
//    <option value="">--Please choose an option--</option>
//    <option value="dog">Dog</option>
//    <option value="cat">Cat</option>
//    <option value="hamster">Hamster</option>
//    <option value="parrot">Parrot</option>
//    <option value="spider">Spider</option>
//    <option value="goldfish">Goldfish</option>
//</select>
        String html =
                "<html>" +
                        "<body>" +
                        "<form method = 'post' action = '/hello'>" +
                        "<input type = 'text' name = 'input' />" +
                        "<select name='Language'>" +
                            "<option value=\"english\">English</option>" +
                            "<option value=\"spanish\">Spanish</option>" +
                            "<option value=\"french\">French</option>" +
                            "<option value=\"gay\">Gay</option>" +
                            "<option value=\"midwestern\">Midwestern</option>" +
                        "<input type = 'submit' value = 'Greet Me!' />" +
                        "</select>" +
                        "</form>" +
                        "</body>" +
                        "</html>";
        return html;
//        this Map Method pulls in the post method on line 37(bookmark) and 56(bookmark) as the action using HTML to create a button
        // keep a close look at the quotations used
    }
    public static String createMessage(String name, String Language) {
        String greeting = "";

        if (Language.equals("english")) {
            greeting = "Hello";
        }
        else if (Language.equals("french")) {
            greeting = "Bonjour";
        }
        else if (Language.equals("gay")) {
            greeting = "Yassss Queen!";
        }
        else if (Language.equals("spanish")) {
            greeting = "Hola";
        }
        else if (Language.equals("midwestern")) {
            greeting = "Hey Yeah!";
        }

        return greeting + " " + name;
    }


}

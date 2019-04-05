package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class GreetingController {

    int counter;
    ArrayList<String> list = new ArrayList();

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", list); // store the new names in the array list
        list.add(name);

        // print all the names that were typed
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        return "greeting";

    }

    @GetMapping(value = "/home")
    public String home(Model model) {
         counter++;

        model.addAttribute("city", "SPB");
        model.addAttribute("counter", counter);
        return "home";
    }

}


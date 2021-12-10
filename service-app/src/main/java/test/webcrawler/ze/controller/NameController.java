package test.webcrawler.ze.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameController {

    @GetMapping("/name/{name}")
    public void nameRequest(@PathVariable("name") String name){
    }

}
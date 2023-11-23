package com.helloworld.CRUD;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @PostMapping("/hello")//Create
    public String postHello()
    {
        return "This is the greatest CRUD app ever!!!";
    }

    @GetMapping("/hello")//Read
    public String getHello()
    {
        return "This is the greatest CRUD app ever!!!";
    }

    @PutMapping("/hello")//Update
    public String putHello()
    {
        return "This is the greatest CRUD app ever!!!";
    }

    @DeleteMapping("/hello")//Delete
    public String deleteHello()
    {
        return "This is the greatest CRUD app ever!!!";
    }
}

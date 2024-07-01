package com.helloworld.CRUD.API.Character;

import org.springframework.web.bind.annotation.*;
import com.helloworld.CRUD.Character.Character;

@RestController
public class CharacterController {
    @GetMapping("/example")
    public String example(
            @RequestBody String body,//points to the body of the api call

            @RequestParam(value = "p1", required = false) String p1,//points to the specified url param
            @RequestParam(required = false) String p2,//points to the specified url param (note the 2 different ways to declare these)

            @RequestHeader(value = "h1", required = false) String h1,//points to the specified header
            @RequestHeader(required = false) String h2//points to the specified header (note the 2 different ways to declare these)

    ) {
        return "example";
    }

    @PutMapping("/new-character/{id}")//Create
    public String postCharacter(
            @PathVariable("id") String id,
            @RequestBody Character character) {
        return "put";
    }

    @PutMapping("/update-character/{id}")//Update
    public String putCharacter(
            @PathVariable("id") String id,
            @RequestBody Character character) {
        return "put other";
    }

    @GetMapping("/get-character/{id}")//Read
    public String getCharacter(
            @PathVariable("id") String id) {
        return "get";
    }

    @DeleteMapping("/delete-character/{id}")//Delete
    public String deleteCharacter(
            @PathVariable("id") String id) {
        return "delete";
    }
}
package com.helloworld.CRUD.API.Character;

import org.springframework.web.bind.annotation.*;
import com.helloworld.CRUD.Character.Character;

@RestController
public class CharacterController {
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
package com.listgames.listgames.controllers;

import com.listgames.listgames.dto.GameMinDTO;
import com.listgames.listgames.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "games")
public class GameController {

    @Autowired
    GameService gameService;


    @GetMapping
    public List<GameMinDTO> findAll(){
        return gameService.findAll();
    }
}

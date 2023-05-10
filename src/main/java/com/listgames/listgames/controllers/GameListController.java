package com.listgames.listgames.controllers;


import com.listgames.listgames.dto.GameListDTO;
import com.listgames.listgames.dto.GameMinDTO;
import com.listgames.listgames.services.GameListService;
import com.listgames.listgames.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "lists")
public class GameListController {

    @Autowired
    GameListService gameListService;

    @Autowired
    GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll(){
        return gameListService.findAll();
    }

    @GetMapping(value = "{listId}/game")
    public List<GameMinDTO> findByList(@PathVariable Long listId){
        return gameService.findByList(listId);
    }


}

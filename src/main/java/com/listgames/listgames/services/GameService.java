package com.listgames.listgames.services;

import com.listgames.listgames.dto.GameMinDTO;
import com.listgames.listgames.entities.Game;
import com.listgames.listgames.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    GameRepository gameRepository;

    public List<GameMinDTO> findAll(){
        List<Game> games = gameRepository.findAll();
        List<GameMinDTO> dto = games.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
    }
}

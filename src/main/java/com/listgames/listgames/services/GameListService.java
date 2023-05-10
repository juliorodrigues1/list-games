package com.listgames.listgames.services;

import com.listgames.listgames.dto.GameListDTO;
import com.listgames.listgames.entities.GameList;
import com.listgames.listgames.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> games = gameListRepository.findAll();
        List<GameListDTO> dto = games.stream().map(x -> new GameListDTO(x)).toList();
        return dto;
    }


}

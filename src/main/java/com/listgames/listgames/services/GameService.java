package com.listgames.listgames.services;

import com.listgames.listgames.dto.GameDto;
import com.listgames.listgames.dto.GameMinDTO;
import com.listgames.listgames.entities.Game;
import com.listgames.listgames.projections.GameMinProjection;
import com.listgames.listgames.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        List<Game> games = gameRepository.findAll();
        List<GameMinDTO> dto = games.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
    }

    @Transactional(readOnly = true)
    public GameDto findById(Long id){
        var game = gameRepository.findById(id).get();
        return new GameDto(game);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId){
        List<GameMinProjection> games = gameRepository.searchByList(listId);
        return  games.stream().map(x -> new GameMinDTO(x)).toList();
    }
}

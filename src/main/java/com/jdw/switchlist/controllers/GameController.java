package com.jdw.switchlist.controllers;

import com.jdw.switchlist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gamelist")
public class GameController
{
    // constructor injection
    private GameService gameService;
    @Autowired
    public GameController(GameService gameService)
    {
        this.gameService = gameService;
    }

    // endpoints

    // GET all games, http://localhost:5000/gamelist
    @GetMapping(value = "/", produces = {"application/json"})
    public ResponseEntity<?> getAllGames()
    {
        return new ResponseEntity<>(gameService.findAll(), HttpStatus.OK);
    }
}

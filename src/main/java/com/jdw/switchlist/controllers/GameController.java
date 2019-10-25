package com.jdw.switchlist.controllers;

import com.jdw.switchlist.services.GameService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    @ApiImplicitParams({
          @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query", value = "Results page, 0 to N"),
          @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query", value = "Number of records per page."),
          @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                            value = "Sorting criteria in format: property(,asc|desc)." + "Default sort is ascending." + "Multiple sort criteria are supported")})
    @GetMapping(value = "", produces = {"application/json"})
    public ResponseEntity<?> getAllGames(@PageableDefault(page = 0, size = 25)Pageable pageable)
    {
        return new ResponseEntity<>(gameService.findAll(pageable), HttpStatus.OK);
    }
}

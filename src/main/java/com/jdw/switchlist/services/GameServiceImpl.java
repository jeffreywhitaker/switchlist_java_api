package com.jdw.switchlist.services;

import com.jdw.switchlist.models.Game;
import com.jdw.switchlist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "GameService")
public class GameServiceImpl implements GameService
{
    @Autowired
    private GameRepository gamerepos;

    @Override
    public List<Game> findAll(Pageable pageable)
    {
        List<Game> list = new ArrayList<>();
        gamerepos.findAll(pageable)
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }
}

package com.jdw.switchlist.services;

import com.jdw.switchlist.models.Game;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GameService
{
    List<Game> findAll(Pageable pageable);
}

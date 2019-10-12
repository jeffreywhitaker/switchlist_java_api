package com.jdw.switchlist.repositories;

import com.jdw.switchlist.models.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, Long>
{
}

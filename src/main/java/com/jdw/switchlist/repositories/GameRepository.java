package com.jdw.switchlist.repositories;

import com.jdw.switchlist.models.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GameRepository extends PagingAndSortingRepository<Game, Long>
{
}

package com.jdw.switchlist.repositories;

import com.jdw.switchlist.models.Useremail;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UseremailRepository extends CrudRepository<Useremail, Long>
{
    List<Useremail> findAllByUser_Username(String name);
}

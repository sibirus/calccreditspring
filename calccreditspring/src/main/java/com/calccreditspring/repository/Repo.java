package com.calccreditspring.repository;

import com.calccreditspring.domain.BazaSQL;
import org.springframework.data.repository.CrudRepository;

public interface Repo extends CrudRepository<BazaSQL, Integer>
{
    //репозиторий позволяет найти полный список полей, либо по идентификатору


}

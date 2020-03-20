package com.example.dxc.springdatajpastoredprocedure.example.repository;

import com.example.dxc.springdatajpastoredprocedure.example.model.*;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

@Transactional
public interface PersonRepository extends CrudRepository<Person, Long> {

    @Autowired
    @Procedure(name = Person.NamedQuery_MoveToHistory)
    String movePersonToHistory(@Param("person_id_in") long personId);

    @Autowired
    @Procedure(name = Person.NamedQuery_FetchFromHistory)
    List<Person> fetchPersonHistory();
}
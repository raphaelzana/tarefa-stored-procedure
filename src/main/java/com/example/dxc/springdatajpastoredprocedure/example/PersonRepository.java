package com.example.dxc.springdatajpastoredprocedure.example;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

@Transactional
public interface PersonRepository extends CrudRepository<Person, Long> {

    @Procedure(name = Person.NamedQuery_MoveToHistory)
    String movePersonToHistory(@Param("person_id_in") long personId);

    @Procedure(name = Person.NamedQuery_FetchFromHistory)
    List<Person> fetchPersonHistory();
}
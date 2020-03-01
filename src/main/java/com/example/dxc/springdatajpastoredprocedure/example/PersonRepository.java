package com.example.dxc.springdatajpastoredprocedure.example;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Transactional
public interface PersonRepository extends CrudRepository<Person, Long> {

    @Procedure(name = Person.NamedQuery_MoveToHistory)
    String movePersonToHistory(@Param("person_id_in") long personId);

    @Procedure(name = Person.NamedQuery_FetchFromHistory)
    List<Person> fetchPersonHistory();
}
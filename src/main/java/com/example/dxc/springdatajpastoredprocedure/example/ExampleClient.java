package com.example.dxc.springdatajpastoredprocedure.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExampleClient {

    @Autowired
    private PersonRepository repo;

    public void run() {
        List<Person> persons = createPersons();
        repo.saveAll(persons);

        System.out.println(" -- getting all persons --");
        Iterable<Person> iterable = repo.findAll();
        List<Person> allPersons = StreamSupport.stream(iterable.spliterator(), false)
                                               .collect(Collectors.toList());
        allPersons.forEach(System.out::println);

        Person person = allPersons.get(0);
        System.out.printf("-- moving person with id %s to history --%n", person.getId());
        String b = repo.movePersonToHistory(person.getId());
        System.out.println("output status: " + b);

        person = allPersons.get(1);
        System.out.printf("-- moving person with id %s to history --%n", person.getId());
        b = repo.movePersonToHistory(person.getId());
        System.out.println("output status: " + b);

        System.out.println("-- getting all persons again --");
        repo.findAll().forEach(System.out::println);

        System.out.println("-- fetching from  person history --");
        repo.fetchPersonHistory().forEach(System.out::println);
        System.out.println("charagunca");
    }

    private List<Person> createPersons() {
        return Arrays.asList(Person.create("Dana", "Whitley", "464 Gorsuch Drive"),
                Person.create("Robin", "Cash", "64 Zella Park"),
                Person.create("Chary", "Mess", "112 Yellow Hill"),
                Person.create("Rose", "Kantata", "2736 Kooter Lane"),
                Person.create("Mike", "Togglie", "111 Cool Dr"));
    }
}
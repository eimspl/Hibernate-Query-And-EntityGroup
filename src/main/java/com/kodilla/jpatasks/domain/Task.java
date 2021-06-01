package com.kodilla.jpatasks.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Task {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    Status status;

    @OneToMany(targetEntity = Person.class, mappedBy = "task")
    Set<Person> persons = new HashSet<>();

    @OneToMany(targetEntity = Subtask.class, mappedBy = "task")
    private final Set<Subtask> subtasks = new HashSet<>();


    public Task() {
    }

    public Task(Long id, String name, Status status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public Set<Subtask> getSubtasks() {
        return subtasks;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Status getStatus() {
        return status;
    }

    public Set<Person> getPersons() {
        return persons;
    }
}

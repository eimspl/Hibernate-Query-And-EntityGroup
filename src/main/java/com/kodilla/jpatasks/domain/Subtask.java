package com.kodilla.jpatasks.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Subtask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    Status status;

    @OneToMany(targetEntity = Person.class, mappedBy = "subtask")
    List<Person> persons = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "task_id")
    Task task;

    public Subtask() {
    }

    public Subtask(Long id, String name, Status status, Task task) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.task = task;
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

    public List<Person> getPersons() {
        return persons;
    }
}

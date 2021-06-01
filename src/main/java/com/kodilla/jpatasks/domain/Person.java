package com.kodilla.jpatasks.domain;

import javax.persistence.*;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "subtask_id")
    private Subtask subtask;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    public Person() {
    }

    public Person(Long id, String firstName, String lastName, Task task, Subtask subtask) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.task = task;
        this.subtask = subtask;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Subtask getSubtask() {
        return subtask;
    }

    public Task getTask() {
        return task;
    }
}

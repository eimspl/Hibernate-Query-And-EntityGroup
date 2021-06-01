package com.kodilla.jpatasks.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class TestData {

    public static List<Long> insertExampleData(EntityManagerFactory emf) {

        Task task1 = new Task(null, "Buy something to eat", Status.IN_PROGRESS);
        Subtask subtask1_1 = new Subtask(null, "Go shopping online", Status.FINISHED, task1);
        Subtask subtask1_2 = new Subtask(null, "Order one cheese pizza", Status.IN_PROGRESS, task1);
        Subtask subtask1_3 = new Subtask(null, "Pay for delivery", Status.IN_PROGRESS, task1);

        Person person1 = new Person(null, "Jolanta", "Suszek", task1, subtask1_1);
        Person person2 = new Person(null, "Jacek", "Kukliński", task1, subtask1_2);
        Person person3 = new Person(null, "Ewelina", "Filipiak", task1, subtask1_3);
        Person person4 = new Person(null, "Dominik", "Marcinowski", task1, subtask1_1);

        task1.getSubtasks().addAll(List.of(subtask1_1, subtask1_2, subtask1_3));
        task1.getPersons().addAll(List.of(person1, person2, person3, person4));
        subtask1_1.getPersons().addAll(List.of(person1, person4));
        subtask1_2.getPersons().addAll(List.of(person2));
        subtask1_3.getPersons().addAll(List.of(person3));

        Task task2 = new Task(null, "Cook lunch", Status.IN_PROGRESS);
        Subtask subtask2_1 = new Subtask(null, "Prepare ingredients for pizza", Status.FINISHED, task2);
        Subtask subtask2_2 = new Subtask(null, "Cook pizza in the oven", Status.IN_PROGRESS, task2);
        Subtask subtask2_3 = new Subtask(null, "Use a dressing e.g. ketchup", Status.IN_PROGRESS, task2);

        Person person5 = new Person(null, "Magdalena", "Piotrowska", task2, subtask2_2);
        Person person6 = new Person(null, "Tomasz", "Kowalski", task2, subtask2_2);
        Person person7 = new Person(null, "Piotr", "Janczak", task2, subtask2_3);
        Person person8 = new Person(null, "Aleksandra", "Garncarz", task2, subtask2_2);

        task2.getSubtasks().addAll(List.of(subtask2_1, subtask2_2, subtask2_3));
        task2.getPersons().addAll(List.of(person5, person6, person7, person8));
        subtask2_2.getPersons().addAll(List.of(person5, person6));
        subtask2_2.getPersons().addAll(List.of(person7));
        subtask2_3.getPersons().addAll(List.of(person8));

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(person1);
        em.persist(person2);
        em.persist(person3);
        em.persist(person4);
        em.persist(person5);
        em.persist(person6);
        em.persist(person7);
        em.persist(person8);
        em.persist(subtask1_1);
        em.persist(subtask1_2);
        em.persist(subtask1_3);
        em.persist(subtask2_1);
        em.persist(subtask2_2);
        em.persist(subtask2_3);
        em.persist(task1);
        em.persist(task2);
        em.flush();
        em.getTransaction().commit();
        em.close();

        return List.of(task1.getId(), task2.getId());
    }
}

package com.kodilla.jpatasks.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;
import java.util.stream.Collectors;

import static com.kodilla.jpatasks.domain.TestData.insertExampleData;

@SpringBootTest
class TasksTestSuiteWithoutEntityGrapth {

    @PersistenceUnit
    private EntityManagerFactory emf;

    @Test
    void shouldNPlusOneProblemOccure() {
        //Given
        List<Long> savedTasks = insertExampleData(emf);
        EntityManager em = emf.createEntityManager();

        //When
        System.out.println("****************** BEGIN OF FETCHING *******************");
        System.out.println("*** STEP 1 – query for tasks ***");

        List<Task> tasks =
                em.createQuery(
                        "from Task "
                                + " where id in (" + tasksIds(savedTasks) + ")",
                        Task.class).getResultList();

        for (Task task : tasks) {
            System.out.println("*** STEP 2 – read data from task ***");
            System.out.println(task);

            System.out.println("*** STEP 3 – read the name ***");
            System.out.println(task.getName());

            System.out.println("*** STEP 4 – read the status ***");
            System.out.println(task.getStatus());

            System.out.println("*** STEP 5 – read persons ***");
            for (Person person : task.getPersons()) {
                System.out.println("*** STEP 6 – read the person ***");
                System.out.println(person);
                System.out.println("*** STEP 7 – read first name ***");
                System.out.println(person.getFirstName());
                System.out.println("*** STEP 8 – read last name ***");
                System.out.println(person.getLastName());
            }

            System.out.println("*** STEP 9 – read subtasks ***");
            for (Subtask subtask : task.getSubtasks()) {
                System.out.println("*** STEP 10 – read the subtask ***");
                System.out.println(subtask);
                System.out.println("*** STEP 11 – read the subtask name ***");
                System.out.println(subtask.getName());

                System.out.println("*** STEP 12 – read the subtask status ***");
                System.out.println(subtask.getStatus());

                System.out.println("*** STEP 13 – read subtask persons ***");
                for (Person person : subtask.getPersons()) {
                    System.out.println("*** STEP 14 – read the person ***");
                    System.out.println(person);
                    System.out.println("*** STEP 15 – read first name ***");
                    System.out.println(person.getFirstName());
                    System.out.println("*** STEP 16 – read last name ***");
                    System.out.println(person.getLastName());
                }
            }

        }

        System.out.println("****************** END OF FETCHING *******************");

    }

    private String tasksIds(List<Long> tasksIds) {
        return tasksIds.stream()
                .map(n -> "" + n)
                .collect(Collectors.joining(","));
    }
}
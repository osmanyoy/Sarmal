package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Repository
public class CustomRepository {
        @Autowired
        private EntityManagerFactory managerFactory;

        public void save(Employee employee){
            EntityManager entityManager = managerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            try {
                boolean contains = entityManager.contains(employee);
                System.out.println("Entity state : " + contains);
                entityManager.persist(employee);
                contains = entityManager.contains(employee);
                System.out.println("After persist Entity state : " + contains);
                entityManager.flush();
                contains = entityManager.contains(employee);
                System.out.println("After flush Entity state : " + contains);
                employee.setName("deneme");
                entityManager.getTransaction().commit();
                contains = entityManager.contains(employee);
                System.out.println("After commit Entity state : " + contains);
                entityManager.clear();
                contains = entityManager.contains(employee);
                System.out.println("After clear Entity state : " + contains);
                Employee employee1 = entityManager.find(Employee.class,
                                                        5L);

                Department department = employee1.getDepartment();
                Department merge = entityManager.merge(department);

                entityManager.getTransaction().begin();
                employee.setName("mehmet");
                entityManager.merge(employee);
                entityManager.getTransaction().commit();

            } catch (Exception ex){
                entityManager.getTransaction().rollback();
            }


        }

}

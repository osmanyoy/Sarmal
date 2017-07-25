package com.training.spring.data;

import com.training.spring.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

@Repository
public class CustomerCustomRepository {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public void save(Customer customer) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction()
                         .begin();
            entityManager.persist(customer);


            entityManager.getTransaction()
                         .commit();
        }
        catch (Exception ex) {
            entityManager.getTransaction()
                         .rollback();
            ex.printStackTrace();
        }
        finally {
            customer.setAge(150);
            entityManager.close();
        }


    }

    @Autowired
    private EntityManager entityManager2;

    @Transactional
    public void save2(Customer customer) {
        // EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager2.persist(customer);
        // entityManager.close();

    }

}

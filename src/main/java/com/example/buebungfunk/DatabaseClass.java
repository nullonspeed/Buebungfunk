package com.example.buebungfunk;

import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;

@Named("data")
@RequestScoped
public class DatabaseClass {

    List<Person> databases ;

    public List<Person> getDatabases()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        Query qu = em.createQuery("select p from Person p");
        databases = qu.getResultList();
        return databases;
    }
}

package com.example.buebungfunk;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@Named(value = "user")
@RequestScoped
public class User {
    String vorname;
    String nachname;

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public User() {
    }

    public User(String vorname, String nachname) {
        this.vorname = vorname;
        this.nachname = nachname;
    }

    public String upload(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        Person patient = new Person(getVorname(), getNachname());
        em.getTransaction().begin();
        em.persist(patient);

        em.getTransaction().commit();

        return "formularodaso.xhtml";

    }

}

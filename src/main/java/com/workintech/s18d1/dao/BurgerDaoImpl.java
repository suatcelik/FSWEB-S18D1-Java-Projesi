package com.workintech.s18d1.dao;

import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.entity.Burger;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BurgerDaoImpl implements BurgerDao{
    private EntityManager entityManager;

    public BurgerDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Autowired


    @Override
    public Burger save(Burger burger) {
        entityManager.persist(burger);
        return burger;
    }

    @Override
    public Burger findById(long id) {
        return entityManager.find(Burger.class,id);
    }

    @Override
    public List<Burger> findAll() {
        TypedQuery<Burger> query=entityManager.createQuery("SELECT b FROM Burger b", Burger.class);
        return query.getResultList();
    }

    @Override
    public List<Burger> findByPrice(double price) {
        TypedQuery<Burger> query=entityManager.createQuery("SELECT b FROM Burger b where b.price>=:price ORDER BY b.price desc", Burger.class);
        query.setParameter("price",price);
        return query.getResultList();
    }

    @Override
    public List<Burger> findBreadType(BreadType breadType) {
        TypedQuery<Burger> query=entityManager.
                createQuery("SELECT b FROM Burger b where b.breadType=:type ORDER BY b.name asc", Burger.class);
        query.setParameter("type",breadType.name());
        return query.getResultList();
    }

    @Override
    public List<Burger> findByContent(String content) {
        TypedQuery<Burger> query=entityManager.createQuery("SELECT b FROM Burger b where b.contents ilike '%:content%'", Burger.class);
        query.setParameter("content",content);
        return query.getResultList();
    }

    @Override
    public Burger update(Burger burger) {
        return entityManager.merge(burger);
    }

    @Override
    public Burger delete(Burger burger) {
        Burger foundB=findById(burger.getId());
        entityManager.remove(foundB);
        return foundB;
    }

    @Override
    public List<Burger> findByBreadType(BreadType breadType) {
        return null;
    }


}

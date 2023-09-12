package com.workintech.JPARestAPI.dao;

import com.workintech.JPARestAPI.entity.Burger;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BurgerDaoRepo implements BurgerDao {
    private EntityManager entityManager;

    @Autowired
    public BurgerDaoRepo(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public Burger save(Burger burger) {
        entityManager.persist(burger);
        return burger;
    }

    @Override
    public List<Burger> findAll() {
        TypedQuery<Burger> query = entityManager.createQuery("SELECT burg FROM Burger burg",Burger.class);
        return query.getResultList();
    }

    @Override
    public Burger findById(int id) {
        return entityManager.find(Burger.class,id);
    }

    @Override
    public List<Burger> findByPrice(double price) {
        TypedQuery<Burger> query = entityManager.createQuery("SELECT burg FROM Burger burg WHERE burg.price >= :price ORDER BY burg.price desc",Burger.class);
        query.setParameter("price",price);
        return query.getResultList();
    }

    @Override
    public List<Burger> findByBreadType(String breadType) {
        TypedQuery<Burger> query = entityManager.createQuery("SELECT burg FROM Burger burg WHERE burg.contents ilike '%breadType%'",Burger.class);
        query.setParameter("content",breadType);
        return query.getResultList();
    }

    @Override
    public List<Burger> findByContent(String content) {
        TypedQuery<Burger> query = entityManager.createQuery("SELECT burg FROM Burger burg WHERE burg.contents ilike '%content%'",Burger.class);
        query.setParameter("content",content);
        return query.getResultList();
    }

    @Transactional
    @Override
    public Burger update(Burger burger) {
        return entityManager.merge(burger);
    }

    @Transactional
    @Override
    public String delete(Burger burger) {
        entityManager.remove(burger.getId());
        return "Successfully deleted";
    }
}

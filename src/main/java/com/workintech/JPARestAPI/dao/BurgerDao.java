package com.workintech.JPARestAPI.dao;

import com.workintech.JPARestAPI.entity.Burger;

import java.util.List;

public interface BurgerDao {
    Burger save(Burger burger);
    List<Burger> findAll();
    Burger findById(int id);
    List<Burger> findByPrice(double price);
    List<Burger> findByBreadType(String breadType);
    List<Burger> findByContent(String content);
    Burger update(Burger burger);
    String delete(Burger burger);
}

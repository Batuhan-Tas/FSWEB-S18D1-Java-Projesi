package com.workintech.JPARestAPI.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name="Burger", schema="spring")
public class Burger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="price")
    private double price;

    @Column(name="breadType")
    private String breadType;

    @Column(name="isVegan")
    private boolean isVegan;

    @Column(name="contents")
    private List<String> contents;
}

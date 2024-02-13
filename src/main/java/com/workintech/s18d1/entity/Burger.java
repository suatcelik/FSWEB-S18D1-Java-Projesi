package com.workintech.s18d1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "burger", schema = "fsweb")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Burger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String name;

    private double price;

    private boolean isVegan;

    @Column(name = "bread")
    private String breadType;

    private String contents;
}

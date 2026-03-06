package com.github.gopalakrrish.springstore.jpa.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@ToString
@Setter
@Getter
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Byte id;

    @Column(name = "name")
    private String name;

//    @ToString.Exclude
    @OneToMany(mappedBy = "category")
    private Set<Product> products = new HashSet<>();

    public Category(String name) {
        this.name = name;
    }

    public Category(byte id) {
        this.id = id;
    }

    public void addProduct(Product product) {
        products.add(product);
        product.setCategory(this);
    }

    public void removeProduct(Product product) {
        products.remove(product);
        product.setCategory(null);
    }
}

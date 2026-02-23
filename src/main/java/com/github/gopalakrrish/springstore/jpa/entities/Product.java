package com.github.gopalakrrish.springstore.jpa.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@ToString
@Setter
@Getter
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name = "price")
    private BigDecimal price;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

/* Bidirectional mapping intentionally omitted.
   Wishlist is modeled as a unidirectional relationship from User to Product
   since retrieving users who wishlisted a product is generally not required.
   This can be enabled later if such navigation becomes necessary.

   Note: Add bidirectional mapping if product → wishlisted users navigation is required
   @ManyToMany(mappedBy = "wishlist")
   private Set<User> wishlistedBy = new HashSet<>();
*/

}

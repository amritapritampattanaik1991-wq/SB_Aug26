package com.qcommerce.backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String itemId;

    @Column(nullable = false)
    private String itemName;

    @Column(columnDefinition = "TEXT")
    private String itemdescription;

    @Column(nullable = false)
    private double itemPrice;

    private String image;

    @Column(nullable = false)
    private int availableQuantity;

    @Column(nullable = false)
    private boolean active = true;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}

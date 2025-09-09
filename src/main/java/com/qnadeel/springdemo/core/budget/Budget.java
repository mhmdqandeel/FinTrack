package com.qnadeel.springdemo.core.budget;

import com.qnadeel.springdemo.core.category.Category;
import com.qnadeel.springdemo.core.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "CATEGORIES")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Budget {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(nullable = false)
    private BigDecimal limitAmount;

    @Column(nullable = false)
    private BigDecimal spentAmount = BigDecimal.ZERO;

    @Column(nullable = false)
    private int month;

    @Column(nullable = false)
    private int year;
}
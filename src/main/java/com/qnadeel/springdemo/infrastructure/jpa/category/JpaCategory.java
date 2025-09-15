package com.qnadeel.springdemo.infrastructure.jpa.category;

import com.qnadeel.springdemo.core.entities.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JpaCategory extends JpaRepository<Category, UUID> {
}

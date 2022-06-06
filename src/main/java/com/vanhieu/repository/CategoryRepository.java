package com.vanhieu.repository;

import com.vanhieu.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    CategoryEntity getByCode(String code);

    @Query("SELECT c FROM CategoryEntity c WHERE c.viewToBeach = ?1")
    List<CategoryEntity> getByViewBeach(Integer viewBeach);
}

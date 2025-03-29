package com.westminster.pos.repo;

import com.westminster.pos.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface ItemRepo extends JpaRepository<Item, Integer>{

    List<Item> findAllByItemNameEqualsAndActiveStatusEquals(String itemName, boolean b);
}

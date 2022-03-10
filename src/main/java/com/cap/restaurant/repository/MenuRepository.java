package com.cap.restaurant.repository;

import com.cap.restaurant.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Integer> {

    @Query(value = "SELECT * FROM menus_rv WHERE available = true", nativeQuery = true)
    List<Menu> findByMenuActive();

    @Query(value = "SELECT * FROM menus_rv WHERE end_date >= CURDATE()", nativeQuery = true)
    List<Menu> findActiveMenuByDate();

    @Query(value = "SELECT * FROM menus_rv WHERE id = ?", nativeQuery = true)
    Menu findMenuByID(Integer dishID);
}

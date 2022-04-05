package com.cap.restaurant.service;

import com.cap.restaurant.exception.menu.MenuFieldNotAddedException;
import com.cap.restaurant.exception.menu.MenuNotFoundException;
import com.cap.restaurant.exception.menu.UpdateMenuFieldNotAddedException;
import com.cap.restaurant.model.Menu;
import com.cap.restaurant.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    public List<Menu> getActiveMenu() {
        List<Menu> activeMenuByDate = menuRepository.findActiveMenuByDate();
        List<Menu> activeMenu = new ArrayList<>();


        return activeMenuByDate;
    }

    public Menu getMenuById(int id) throws MenuNotFoundException {
        Menu menuById = menuRepository.findMenuByID(id);
        if(menuById == null){
            throw new MenuNotFoundException("MenuService Message");
        }
        return menuById;
    }

    public Menu addMenu(Menu menu) throws MenuFieldNotAddedException {
        if (menu.getDishName() == null || menu.getAmount() == null || menu.getAvailable() == null || menu.getEndDate() == null || menu.getStartDate() ==null || menu.getStock() == null) {
            throw new MenuFieldNotAddedException("MenuService Message");
        }
        return menuRepository.saveAndFlush(menu);
    }

    public Menu updateMenu(Integer menuID, Menu menu) throws UpdateMenuFieldNotAddedException, MenuNotFoundException {
        // TODO: 09/03/2022 update only a some fields 
        Menu menuForUpdate = menuRepository.findById(menuID).orElse(null);
        if (menuForUpdate == null){
            throw new MenuNotFoundException("MenuService Message");
        }

        if (menu.getId() == null || menu.getDishName() == null || menu.getAmount() == null || menu.getAvailable() == null || menu.getStartDate() == null || menu.getEndDate() == null) {
            throw new UpdateMenuFieldNotAddedException("MenuService Message");
        } else {
            menuForUpdate.setId(menu.getId());
            menuForUpdate.setDishName(menu.getDishName());
            menuForUpdate.setAmount(menu.getAmount());
            menuForUpdate.setStartDate(menu.getStartDate());
            menuForUpdate.setEndDate(menu.getEndDate());
            menuForUpdate.setStock(menu.getStock());
            menuForUpdate.setAvailable(menu.getAvailable());
        }
        return menuRepository.saveAndFlush(menu);
    }

    public List<Menu> allMenus(){
        return menuRepository.findAll();
    }

    public void deleteMenu(Integer id){
        menuRepository.deleteById(id);
    }
}

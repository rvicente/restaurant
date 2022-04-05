package com.cap.restaurant.controller;

import com.cap.restaurant.exception.menu.MenuFieldNotAddedException;
import com.cap.restaurant.exception.menu.MenuNotFoundException;
import com.cap.restaurant.exception.menu.UpdateMenuFieldNotAddedException;
import com.cap.restaurant.model.Menu;
import com.cap.restaurant.model.MenuResponse;
import com.cap.restaurant.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @CrossOrigin
    @GetMapping("/getAllMenus")
    public List<Menu> getMenu(){
       return menuService.allMenus();
    }



    @GetMapping("/getMenu")
    public ResponseEntity<MenuResponse> getActiveMenu(){
        MenuResponse menuResponse = new MenuResponse();
        menuResponse.setSentOn(new Date().toString());
        menuResponse.setTransactionID(UUID.randomUUID().toString());
        try{
            //menuResponse = new MenuResponse("OK",new Date().toString(),"200", UUID.randomUUID().toString(), "GetMenu Success",menuService.getActiveMenu());
            List<Menu> activeMenuList = menuService.getActiveMenu();

            menuResponse.setStatus("ok");
            if (!activeMenuList.isEmpty()) {
                menuResponse.setMsg("getMenu success");
                menuResponse.setResValues(activeMenuList);
            }else{
                menuResponse.setMsg("getMenu: No list to show");
                menuResponse.setResValues(activeMenuList);
            }
        }catch (Exception e){
            menuResponse.setStatus("NOK");
            menuResponse.setMsg("Error: " + e.getMessage());
        }
        //MenuResponse menuResponse = new MenuResponse("OK",new Date().toString(),"200", UUID.randomUUID().toString(), "GetMenu Success",menuService.getActiveMenu());
        return  new ResponseEntity<>(menuResponse, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/getMenuById/{id}")
    public ResponseEntity<MenuResponse> getMenuById (@PathVariable int id) throws MenuNotFoundException {
        Menu menuById = menuService.getMenuById(id);
        List<Menu> currentList = new ArrayList<>();
        currentList.add(menuById);
        MenuResponse menuResponse = new MenuResponse("ok",new Date().toString(),"200", UUID.randomUUID().toString(),"updateMenu Success", currentList );

        System.out.println(menuById.toString());

        return new ResponseEntity<>(menuResponse, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/addMenu")
    public ResponseEntity<MenuResponse> addMenu(@RequestBody Menu menu) throws MenuFieldNotAddedException {
        Menu menuForAdd = menuService.addMenu(menu);
        List<Menu> currentList = new ArrayList<>();
        currentList.add(menuForAdd);
        MenuResponse menuResponse = new MenuResponse("ok",new Date().toString(),"200", UUID.randomUUID().toString(),"addMenu Success", currentList );
        return new ResponseEntity<>(menuResponse, HttpStatus.OK);

    }

    @PostMapping("/updateMenu")
        public ResponseEntity<MenuResponse> updateMenu(@RequestBody Menu menu) throws UpdateMenuFieldNotAddedException, MenuNotFoundException {
        Menu menuForUpdate = menuService.updateMenu(menu.getId(),menu);
        List<Menu> currentList = new ArrayList<>();
        currentList.add(menuForUpdate);
        MenuResponse menuResponse = new MenuResponse("ok",new Date().toString(),"200", UUID.randomUUID().toString(),"updateMenu Success", currentList );
        return new ResponseEntity<>(menuResponse, HttpStatus.OK);
    }



    @DeleteMapping("/deleteMenu/{id}")
    public ResponseEntity<MenuResponse> deleteMenu(@PathVariable int id) {
        menuService.deleteMenu(id);
        List<Menu> currentList = new ArrayList<>();
        MenuResponse menuResponse = new MenuResponse("ok",new Date().toString(),"200", UUID.randomUUID().toString(),"updateMenu Success", currentList );
        return new ResponseEntity<>(menuResponse, HttpStatus.OK);

    }


}

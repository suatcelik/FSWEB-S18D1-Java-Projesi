package com.workintech.s18d1.controller;


import com.workintech.s18d1.dao.BurgerDao;
import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.entity.Burger;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/burger")
@Validated
public class BurgerController{
    public BurgerController(BurgerDao burgerDao) {
        this.burgerDao = burgerDao;
    }

    private BurgerDao burgerDao;


    @GetMapping("/")
    public List<Burger> findAll() {
        return burgerDao.findAll();
    }
    @GetMapping("/{id}")
    public Burger find(@PathVariable int id) {
        return burgerDao.findById(id);
    }
    @PostMapping("/")
    public Burger save(@Validated @RequestBody Burger burger){
        return burgerDao.save(burger);
    }
    @PutMapping("/")
    public Burger update(@RequestBody Burger burger) {
        return burgerDao.update(burger);
    }
    @DeleteMapping("/{id}")
    public Burger delete(@PathVariable int id) {
        Burger burger = find(id);
        burgerDao.delete(burger);
        return burger;
    }
    @GetMapping("/findByPrice/{price}")
    public List<Burger> findByPrice(@PathVariable int price){
        return burgerDao.findByPrice(price);
    }
    @GetMapping("/findByBreadType/{breadType}")
    public List<Burger> findByPrice(@PathVariable String breadType){
        return burgerDao.findByBreadType(BreadType.BURGER);
    }
    @GetMapping("/findByContent/{content}")
    public List<Burger> findByContent(@PathVariable String content){
        return burgerDao.findByContent(content);
    }
}

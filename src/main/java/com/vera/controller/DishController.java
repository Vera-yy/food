package com.vera.controller;

import com.vera.accessingdatamysql.model.Dish;
import com.vera.accessingdatamysql.repository.DishRepository;
import com.vera.apiResponse.ApiResponse;
import com.vera.service.ChooseDishService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/dish")
public class DishController {

    private Logger log = LoggerFactory.getLogger(DishController.class);

    @Autowired
    private ChooseDishService chooseDishService;

    @Autowired
    private DishRepository dishRepository;

    @GetMapping("/random")
    public @ResponseBody ResponseEntity<ApiResponse<Dish>> getRandomDish(){
        Dish randomDish = chooseDishService.getRandomDish();
        return ResponseEntity.ok(ApiResponse.success(randomDish));
    }

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody ResponseEntity<ApiResponse<Dish>> addNewDish (@RequestBody Dish dish) {
        Dish createdDish = dishRepository.save(dish);
        return ResponseEntity.ok(ApiResponse.success(createdDish));
    }

    @GetMapping(path = "/all", produces = "application/json")
    public @ResponseBody ResponseEntity<ApiResponse<Iterable<Dish>>> getAllDishes() {
        log.info("Fetching all dishes");
        Iterable<Dish> dishes = dishRepository.findAll();
        log.info("Dishes fetched: {}", dishes);
        return ResponseEntity.ok(ApiResponse.success(dishes));
    }

}

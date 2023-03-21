package com.vera.controller;

import com.vera.accessingdatamysql.model.Dish;
import com.vera.accessingdatamysql.repository.DishRepository;
import com.vera.service.ChooseDishService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/dish")
public class DishController {

    private Logger log = LoggerFactory.getLogger(DishController.class);

    @Autowired
    private ChooseDishService chooseDishService;

    @Autowired
    private DishRepository dishRepository;

    @GetMapping("/getRandomDish")
    public @ResponseBody String getRandomDish(){
        return "今天的菜谱是：" + chooseDishService.getRandomDish().getDishName();
    }


    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewDish (@RequestParam String dishType
            , @RequestParam String dishName, @RequestParam String dishCode) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        log.info("/dish/add dishType:{}, dishName:{}, dishCode:{}", dishType, dishName, dishCode );
        Dish dish = new Dish();
        dish.setDishType(dishType);
        dish.setDishName(dishName);
        dish.setDishCode(dishCode);
        dishRepository.save(dish);
        return "Saved!";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Dish> getAllDishes() {
        // This returns a JSON or XML with the users
        return dishRepository.findAll();
    }
}

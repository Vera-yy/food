package com.vera.service;

import com.vera.accessingdatamysql.model.Dish;
import com.vera.accessingdatamysql.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Service
public class ChooseDishService {

    @Autowired
    private DishRepository dishRepository;

    public Dish getRandomDish(){
        // 菜谱数组
        Iterable<Dish> dishes = dishRepository.findAll();
        List<Dish> dishList = new ArrayList<>();
        dishes.forEach(e -> dishList.add(e));
        // 随机生成数组下标
        Random random = new Random();
        // 输出选中的菜品
        return dishList.get(random.nextInt(dishList.size()));
    }
}

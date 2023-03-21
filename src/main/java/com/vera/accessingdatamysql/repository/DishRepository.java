package com.vera.accessingdatamysql.repository;

import com.vera.accessingdatamysql.model.Dish;
import org.springframework.data.repository.CrudRepository;

public interface DishRepository extends CrudRepository<Dish, Integer> {

}

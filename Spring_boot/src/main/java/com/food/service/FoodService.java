package com.food.service;

import java.util.List;

import com.food.models.Food;
import com.food.repositories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodService {
    @Autowired
    FoodRepository foodRepository;

    public Food createFood(Food food) {
        return foodRepository.save(food);
    }

    public List<Food> getAllFoods() {
        try {
            return foodRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Foods not found");
        }
    }

    public Food getFoodById(Long foodId) {
        return foodRepository.findById(foodId).orElseThrow(
                () -> new RuntimeException("Food not found with id: " + foodId)
        );
    }

    public void deleteFoodById(Long foodId) {
        foodRepository.deleteById(foodId);
    }

    public Food updateFood(Food food) {
        Food myFood = getFoodById(food.getId());
        myFood.setFoodName(food.getFoodName());
        myFood.setFoodType(food.getFoodType());
        myFood.setFoodDescription(food.getFoodDescription());
        myFood.setFoodPrice(food.getFoodPrice());
        myFood.setFoodDiscount(food.getFoodDiscount());
        myFood.setFoodDiscountPrice(food.getFoodDiscountPrice());
        myFood.setProvider(food.getProvider());
        myFood.setAction(food.isAction());
        return foodRepository.save(myFood);
    }

    public Food confirmFood(Food food) {
        Food myFood = getFoodById(food.getId());
        myFood.setAction(food.isAction());
        return foodRepository.save(myFood);
    }
}

package com.solid;

/**
 * SOLID Principles
 * SOLID is an acronym for the first five object-oriented design (OOD)
 * principles by Robert C. Martin
 * 
 * S -
 * 0 -
 * L -
 * I - Interface Segregation Principle
 * A client should never be forced to implement an interface that is do not use
 * D -
 */

interface VegRestaurant {
    void vegMeals();
}

interface NonVegRestaurant {
    void nonVegMeals();
}

class ABCVegRestaurant implements VegRestaurant {
    @Override
    public void vegMeals() {
        System.out.println("ABC - provide veg meals");
    }
}

class XYZRestaurant implements VegRestaurant, NonVegRestaurant {
    @Override
    public void nonVegMeals() {
        System.out.println("XYZ - provide veg meals");
    }

    @Override
    public void vegMeals() {
        System.out.println("XYZ - provide non veg meals");
    }
}

public class InterfaceSegEx1 {
    public static void main(String[] args) {
        ABCVegRestaurant abcVegRestaurant = new ABCVegRestaurant();
        abcVegRestaurant.vegMeals();

        XYZRestaurant xyzRestaurant = new XYZRestaurant();
        xyzRestaurant.vegMeals();
        xyzRestaurant.nonVegMeals();
    }
}

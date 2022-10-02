package com.solid;

/**
 * SOLID Principles
 * SOLID is an acronym for the first five object-oriented design (OOD)
 * principles by Robert C. Martin
 * 
 * S -
 * 0 -
 * L - Liskov Substitution Principle
 * Objects of super class shall be replaced with objects of subclasses
 * I -
 * D -
 */

class Vehicle {
    public void start() {
        System.out.println("starting a vehicle");
    }

    public void stop() {
        System.out.println("stopping a vehicle  ");
    }
}

class Bike extends Vehicle {
    public void start() {
        System.out.println("starting a bike");
    }

    public void stop() {
        System.out.println("stopping a bike");
    }
}

class Car extends Vehicle {
    public void start() {
        System.out.println("starting a car");
        // throw new RuntimeException("boom you are gone...");
    }

    public void stop() {
        System.out.println("stopping a car");
    }
}

public class LiskovSubstitutionEx1 {
    static void testDrive(Vehicle vehicle) {
        vehicle.start();
        vehicle.stop();
    }

    public static void main(String[] args) {
        testDrive(new Vehicle());
        testDrive(new Bike());
        testDrive(new Car());
    }
}

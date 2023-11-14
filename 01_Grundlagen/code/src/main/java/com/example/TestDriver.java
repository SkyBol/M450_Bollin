package com.example;

public class TestDriver {
    Price price = new Price();

    static void testAll() {
        TestDriver testDriver = new TestDriver();

        System.out.println("-------------------------------------------------");
        System.out.println("Test: Simple Price Calculation");
        System.out.println("Passing: " + testDriver.test_calculate_price());
        System.out.println("-------------------------------------------------");
        System.out.println("Test: No Discount for under 3 Extras");
        System.out.println("Passing: " + testDriver.test_no_extra_discount());
        System.out.println("-------------------------------------------------");
        System.out.println("Test: Discount only affects Base Price");
        System.out.println("Passing: " + testDriver.test_discount_only_for_basePrice());
        System.out.println("-------------------------------------------------");
    }

    // Simple Test to see if function works
    boolean test_calculate_price() {
        var result = price.calculatePrice(100.0, 10.0, 50.0, 3, 50);
        return result == 105.0;
    }

    // No Discount if extras below 3
    boolean test_no_extra_discount() {
        var result = price.calculatePrice(100, 0, 50, 1, 0);
        return result == 150;
    }

    boolean test_discount_only_for_basePrice() {
        var result = price.calculatePrice(100, 50, 50, 1, 50);
        return result == 150;
    }
}

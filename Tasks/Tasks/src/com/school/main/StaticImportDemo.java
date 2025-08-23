package com.school.main;

// Normal import
import com.school.util.MathUtils;

// Static import
import static com.school.util.MathUtils.PI;
import static com.school.util.MathUtils.square;

public class StaticImportDemo {
    public static void main(String[] args) {
        // Using normal import
        System.out.println("PI using normal import: " + MathUtils.PI);

        // Using static import (no class name needed)
        System.out.println("PI using static import: " + PI);
        System.out.println("Square of 5: " + square(5));
    }
}

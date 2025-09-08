package com.insurance;

import org.springframework.stereotype.Service;

@Service
public class PremiumService {

    /**
     * Calculates premium based on type, age, coverage, and duration (1 or 5 years)
     * @param type Policy type: health, life, vehicle
     * @param age Age of policyholder
     * @param coverage Coverage amount in INR
     * @param duration Duration in years (1 or 5)
     * @return Total premium in INR
     */
    public double calculate(String type, int age, double coverage, int duration) {
        double baseRate;

        switch (type.toLowerCase()) {
            case "health":
                baseRate = 0.05;  // 5% 
                break;
            case "life":
                baseRate = 0.04;  // 4% 
                break;
            case "vehicle":
                baseRate = 0.03;  // 3% 
                break;
            default:
                baseRate = 0.02;  
        }

        // Age factor: +50 years, 1.5x
        double ageFactor = age > 50 ? 1.5 : 1.0;

        // Annual premium
        double annualPremium = coverage * baseRate * ageFactor;

        // Total premium based on duration
        double totalPremium;
        if (duration == 1) {
            totalPremium = annualPremium; // 1-year 
        } else if (duration == 5) {
            totalPremium = annualPremium * 4; // 5-year premium with 1-year discount
        } else {
            throw new IllegalArgumentException("Only 1 or 5 years duration allowed.");
        }

        return totalPremium;
    }
}

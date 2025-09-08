package com.insurance;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Service class to handle all insurance policy business logic.
 * This class uses an in-memory list to store and manage policies.
 */
@Service
public class PolicyService {

    private final List<Policy> policies = new ArrayList<>();

    public double calculatePremium(String policyType, int age, double coverage,int duration,String fullname) {
        if (age <= 0 || coverage <= 0) {
            throw new IllegalArgumentException("Age and coverage must be positive values.");
        }

        double basePremium = 0;
        switch (policyType.toLowerCase()) {
            case "health":
                basePremium = 1000;
                // For a health policy, we will return a fixed premium of 1000.
                return basePremium;
            case "life":
                basePremium = 1000;
                break;
            case "vehicle":
                basePremium = 300;
                break;
            default:
                throw new IllegalArgumentException("Invalid policy type: " + policyType);
        }
        double annualPremium = basePremium + (age * 10) + (coverage * 0.01);

        double totalPremium;
        if (duration == 1) {
            totalPremium = annualPremium;
        } else if (duration == 5) {
            totalPremium = annualPremium * 4.0;
        } else {
            throw new IllegalArgumentException("Only 1 year or 5 years duration is allowed.");
        }

        return totalPremium;
    }

    /**
     * Creates and stores a new insurance policy.
     * @param policyType The type of policy.
     * @param fullName The full name of the policyholder.
     * @param age The age of the policyholder.
     * @param coverage The coverage amount.
     * @return The newly created Policy object.
     */
    public Policy createPolicy(String policyType, String fullName, int age, double coverage,int duration,String fullname) {
        double premium = calculatePremium(policyType, age, coverage,duration,fullname);
        String policyId = UUID.randomUUID().toString(); // Generate a unique ID
        Policy newPolicy = new Policy(policyId, policyType, fullName, age, coverage, premium);
        policies.add(newPolicy);
        return newPolicy;
    }

    /**
     * Submits a claim for a given policy.
     * This is a simplified method. In a real system, it would have more complex logic.
     * @param policyId The ID of the policy to submit a claim for.
     * @param description The description of the claim.
     * @return true if the claim was submitted successfully, false otherwise.
     */
    public boolean submitClaim(String policyId, String description) {
        Policy policy = findPolicyById(policyId);
        if (policy != null) {
            System.out.println("Claim for policy " + policyId + " submitted: " + description);
            // In a real application, this would update the policy's claim history
            return true;
        }
        return false;
    }

    /**
     * Renews an expired policy.
     * @param policyId The ID of the policy to renew.
     * @return true if the policy was renewed, false otherwise.
     */
    public boolean renewPolicy(String policyId) {
        Policy policy = findPolicyById(policyId);
        if (policy != null && "Expired".equals(policy.getStatus())) {
            policy.setStatus("Active");
            return true;
        }
        return false;
    }

    /**
     * Finds a policy by its ID.
     * @param policyId The ID of the policy.
     * @return The Policy object if found, otherwise null.
     */
    public Policy findPolicyById(String policyId) {
        return policies.stream()
                       .filter(p -> p.getPolicyId().equals(policyId))
                       .findFirst()
                       .orElse(null);
    }

    /**
     * Retrieves all policies.
     * @return A list of all policies.
     */
    public List<Policy> getAllPolicies() {
        return policies;
    }
}

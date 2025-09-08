package com.insurance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api")
public class PolicyController {

    private final List<Policy> policies = new ArrayList<>();

    @Autowired
    private PremiumService premiumService;

    // Get all policies
    @GetMapping("/policies")
    public ResponseEntity<List<Policy>> getAllPolicies() {
        return ResponseEntity.ok(policies);
    }

    // Calculate premium for 1-year or 5-year
    @GetMapping("/premiums/calculate")
    public ResponseEntity<Double> calculatePremium(
            @RequestParam String type,
            @RequestParam int age,
            @RequestParam double coverage,
            @RequestParam int duration) {

        try {
            double premium = premiumService.calculate(type, age, coverage, duration);
            return ResponseEntity.ok(premium);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(0.0);
        }
    }

    // Create policy (after successful payment)
    @PostMapping("/policies")
    public ResponseEntity<?> createPolicy(@RequestBody PolicyRequest request) {

        if (request.getCoverage() <= 0) {
            return ResponseEntity.badRequest().body("Coverage amount must be greater than 0.");
        }

        if (request.getDuration() != 1 && request.getDuration() != 5) {
            return ResponseEntity.badRequest().body("Duration must be 1 or 5 years.");
        }

        double premium = premiumService.calculate(
                request.getPolicyType(),
                request.getAge(),
                request.getCoverage(),
                request.getDuration()
        );

        boolean paymentSuccessful = mockPayment(premium);
        if (!paymentSuccessful) {
            return ResponseEntity.status(402).body("Payment failed. Policy not created.");
        }

        String newPolicyId = UUID.randomUUID().toString();
        Policy newPolicy = new Policy(
                newPolicyId,
                request.getPolicyType(),
                request.getFullName(),
                request.getAge(),
                request.getCoverage(),
                premium
        );

        // Set expiry date based on duration
        newPolicy.setStartDate(java.time.LocalDate.now());
        newPolicy.setExpiryDate(newPolicy.getStartDate().plusYears(request.getDuration()));

        policies.add(newPolicy);
        return ResponseEntity.ok(newPolicy);
    }

    // Submit claim
    @PostMapping("/claims/{policyId}")
    public ResponseEntity<String> submitClaim(@PathVariable String policyId, @RequestBody ClaimRequest request) {
        Policy policy = policies.stream()
                .filter(p -> p.getPolicyId().equals(policyId))
                .findFirst()
                .orElse(null);

        if (policy == null) {
            return ResponseEntity.status(404).body("Policy not found.");
        }

        return ResponseEntity.ok("Claim for policy " + policyId + " submitted successfully with description: " + request.getDescription());
    }

    // Renew policy
    @PostMapping("/policies/{id}/renew")
    public ResponseEntity<Policy> renewPolicy(@PathVariable String id) {
        for (Policy policy : policies) {
            if (policy.getPolicyId().equals(id)) {
                if ("Expired".equals(policy.getStatus())) {
                    policy.setStatus("Active");
                    return ResponseEntity.ok(policy);
                } else {
                    return ResponseEntity.badRequest().body(null);
                }
            }
        }
        return ResponseEntity.notFound().build();
    }

    // Mock payment method
    private boolean mockPayment(double amount) {
        return amount > 0;
    }

    // Request body classes
    static class PolicyRequest {
        private String fullName;
        private String policyType;
        private int age;
        private double coverage;
        private int duration; // 1 or 5 years

        public String getFullName() { return fullName; }
        public void setFullName(String fullName) { this.fullName = fullName; }

        public String getPolicyType() { return policyType; }
        public void setPolicyType(String policyType) { this.policyType = policyType; }

        public int getAge() { return age; }
        public void setAge(int age) { this.age = age; }

        public double getCoverage() { return coverage; }
        public void setCoverage(double coverage) { this.coverage = coverage; }

        public int getDuration() { return duration; }
        public void setDuration(int duration) { this.duration = duration; }
    }

    static class ClaimRequest {
        private String description;
        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }
    }
}

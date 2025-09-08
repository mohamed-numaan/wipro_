package com.insurance;

import java.util.*;

public class ClaimService {

    private Map<String, List<String>> claims = new HashMap<>();

    public boolean submitClaim(String policyId, String reason) {
        claims.computeIfAbsent(policyId, k -> new ArrayList<>()).add(reason);
        return true;
    }

    public List<String> getClaims(String policyId) {
        return claims.getOrDefault(policyId, Collections.emptyList());
    }
}

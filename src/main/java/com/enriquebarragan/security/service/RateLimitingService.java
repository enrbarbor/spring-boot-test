package com.enriquebarragan.security.service;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class RateLimitingService {

    // Un bucket por usuario
    private final Map<String, Bucket> buckets = new ConcurrentHashMap<>();

    private Bucket createNewBucket() {
        Bandwidth limit = Bandwidth.builder()
            .capacity(100)                          // 100 peticiones máximo
            .refillGreedy(100, Duration.ofMinutes(1)) // se recargan cada minuto
            .build();
        return Bucket.builder().addLimit(limit).build();
    }

    public Bucket resolveBucket(String userId) {
        return buckets.computeIfAbsent(userId, id -> createNewBucket());
    }

    public boolean tryConsume(String userId) {
        return resolveBucket(userId).tryConsume(1);
    }
}
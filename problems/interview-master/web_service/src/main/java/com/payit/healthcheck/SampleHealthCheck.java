package com.payit.healthcheck;

import com.codahale.metrics.health.HealthCheck;

public class SampleHealthCheck extends HealthCheck {
    @Override
    protected Result check() throws Exception {
        return Result.healthy();
    }
}

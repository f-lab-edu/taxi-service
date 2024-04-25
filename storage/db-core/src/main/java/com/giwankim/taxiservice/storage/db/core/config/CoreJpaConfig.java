package com.giwankim.taxiservice.storage.db.core.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaAuditing
@EnableTransactionManagement
@EntityScan(basePackages = "com.giwankim.taxiservice.storage.db.core")
@EnableJpaRepositories(basePackages = "com.giwankim.taxiservice.storage.db.core")
public class CoreJpaConfig {
}

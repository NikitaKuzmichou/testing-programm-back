package com.vsu.by.app.common.config.db;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public interface DbConfiguration {
    DriverManagerDataSource dataSource();
}

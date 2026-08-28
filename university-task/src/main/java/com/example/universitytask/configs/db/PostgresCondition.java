package com.example.universitytask.configs.db;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class PostgresCondition implements Condition {
    @Override
    public boolean matches(final ConditionContext context, final AnnotatedTypeMetadata metadata) {
        final Environment environment = context.getEnvironment();
        final boolean isPostgresEnabled = retrieveBooleanProperty(environment, "db.postgres.enabled");
        final boolean isLiquibaseEnabled = retrieveBooleanProperty(environment, "db.liquibase.enabled");

        return isLiquibaseEnabled && isPostgresEnabled;
    }

    private static boolean retrieveBooleanProperty(final Environment environment, final String property) {
        return Boolean.parseBoolean(environment.getProperty(property));
    }
}

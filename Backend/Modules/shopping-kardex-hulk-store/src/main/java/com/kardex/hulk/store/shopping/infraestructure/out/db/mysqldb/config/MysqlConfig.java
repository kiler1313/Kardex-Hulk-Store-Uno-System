package com.kardex.hulk.store.shopping.infraestructure.out.db.mysqldb.config;

import com.zaxxer.hikari.HikariConfig;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Objects;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "mysqlEntityManagerFactory",
        transactionManagerRef = "mysqlTransactionManager",
        basePackages = {"com.kardex.hulk.store.shopping.infraestructure.out.db.mysqldb.repository"})
public class MysqlConfig {

    private static final int PREP_STMT_CACHE_SIZE = 250;
    private static final int PREP_STMT_CACHE_SQL_LIMIT = 2048;


    @Primary
    @Bean(name = "mysqlDataSource")
    public DataSource mysqlDataSource(Environment env) {

        HikariConfig configMysql = new HikariConfig();
        configMysql.setDriverClassName(env.getProperty("spring.datasource.mysql.driver-class-name"));
        configMysql.setPoolName(env.getProperty("spring.datasource.mysql.hikari.pool-name"));
        configMysql.setJdbcUrl(env.getProperty("spring.datasource.mysql.jdbcUrl"));
        configMysql.setUsername(env.getProperty("spring.datasource.mysql.username"));
        configMysql.setPassword(env.getProperty("spring.datasource.mysql.password"));
        configMysql.setMinimumIdle(Integer.parseInt(Objects.requireNonNull(env.getProperty("spring.datasource.mysql.hikari.minimum-idle"))));
        configMysql.setMaximumPoolSize(Integer.parseInt(Objects.requireNonNull(env.getProperty("spring.datasource.mysql.hikari.maximum-pool-size"))));
        configMysql.setConnectionTimeout(Long.parseLong(Objects.requireNonNull(env.getProperty("spring.datasource.mysql.hikari.connection-timeout"))));
        configMysql.setAutoCommit(Boolean.parseBoolean(env.getProperty("spring.datasource.mysql.hikari.auto-commit")));
        configMysql.setIdleTimeout(Long.parseLong(Objects.requireNonNull(env.getProperty("spring.datasource.mysql.hikari.idle-timeout"))));
        configMysql.setMaxLifetime(Long.parseLong(Objects.requireNonNull(env.getProperty("spring.datasource.mysql.hikari.max-lifetime"))));
        configMysql.setCatalog(Objects.requireNonNull(env.getProperty("spring.datasource.mysql.hikari.catalog")));

        // Optimización predefinida DEL POOL
        configMysql.addDataSourceProperty("cachePrepStmts", Boolean.TRUE);
        configMysql.addDataSourceProperty("prepStmtCacheSize", PREP_STMT_CACHE_SIZE);
        configMysql.addDataSourceProperty("prepStmtCacheSqlLimit", PREP_STMT_CACHE_SQL_LIMIT);
        configMysql.addDataSourceProperty("useServerPrepStmts", Boolean.FALSE);
        configMysql.addDataSourceProperty("useLocalSessionState", Boolean.TRUE);
        configMysql.addDataSourceProperty("rewriteBatchedStatements", Boolean.TRUE);
        configMysql.addDataSourceProperty("cacheResultSetMetadata", Boolean.TRUE);
        configMysql.addDataSourceProperty("elideSetAutoCommits", Boolean.TRUE);
        configMysql.addDataSourceProperty("maintainTimeStats", Boolean.TRUE);

        return new MysqlHikariDatasource(configMysql);
    }

    /**
     * Mysql entity
     * @param builder entity manager builder
     * @param mysqlDataSource mysql properties
     * @param env environment
     * @return manager entity
     */
    @Primary
    @Bean(name = "mysqlEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                            @Qualifier("mysqlDataSource") DataSource mysqlDataSource,
                                                                            Environment env) {
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));

        return builder
                .dataSource(mysqlDataSource)
                .packages("com.kardex.hulk.store.shopping.infraestructure.out.db.mysqldb.entities")
                .persistenceUnit("mysql")
                .properties(properties)
                .build();
    }

    /**
     * Transaction manager
     * @param mysqlEntityManagerFactory this manager factory
     * @return jpa transaction manager
     */
    @Primary
    @Bean(name = "mysqlTransactionManager")
    public PlatformTransactionManager mysqlTransactionManager(@Qualifier("mysqlEntityManagerFactory") EntityManagerFactory mysqlEntityManagerFactory) {
        return new JpaTransactionManager(mysqlEntityManagerFactory);
    }
}

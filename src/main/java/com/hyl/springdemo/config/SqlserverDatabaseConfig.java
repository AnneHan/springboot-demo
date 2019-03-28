package com.hyl.springdemo.config;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableEncryptableProperties
@PropertySource({ "classpath:persistence-multiple-db.properties" })
@EnableJpaRepositories(
        basePackages = "com.hyl.springdemo.repository.sqlserver",
        entityManagerFactoryRef = "sqlserverEntityManager",
        transactionManagerRef = "sqlserverTransactionManager"
)
public class SqlserverDatabaseConfig {

    @Autowired
    private Environment env;

    @Bean
    public DataSource sqlserverDataSource() {

        HikariDataSource dataSource = DataSourceBuilder.create().type(HikariDataSource.class).build();
        dataSource.setDriverClassName(env.getProperty("app.datasource.sqlserver.driver-class-name"));
        dataSource.setJdbcUrl(env.getProperty("app.datasource.sqlserver.url"));
        dataSource.setUsername(env.getProperty("app.datasource.sqlserver.username"));
        dataSource.setPassword(env.getProperty("app.datasource.sqlserver.password"));
        dataSource.setMaximumPoolSize(Integer.parseInt(env.getProperty("app.datasource.sqlserver.maximum-pool-size")));

        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean sqlserverEntityManager() {

        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(sqlserverDataSource());
        em.setPackagesToScan(
                new String[] { "com.hyl.springdemo.domain.sqlserver" });

        HibernateJpaVendorAdapter vendorAdapter
                = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setPersistenceUnitName("SqlserverPersistenceUnit");
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto",
                env.getProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect",
                "org.hibernate.dialect.SQLServer2005Dialect");
        em.setJpaPropertyMap(properties);

        return em;
    }

    @Bean
    public PlatformTransactionManager sqlserverTransactionManager() {

        JpaTransactionManager transactionManager
                = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                sqlserverEntityManager().getObject());
        return transactionManager;
    }
}

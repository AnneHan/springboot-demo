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
        basePackages = "com.hyl.springdemo.repository.oracle",
        entityManagerFactoryRef = "oracleEntityManager",
        transactionManagerRef = "oracleTransactionManager"
)
public class OracleDatabaseConfig {

    @Autowired
    private Environment env;

    @Bean
    public DataSource oracleDataSource() {

        HikariDataSource dataSource = DataSourceBuilder.create().type(HikariDataSource.class).build();
        dataSource.setDriverClassName(env.getProperty("app.datasource.oracle.driver-class-name"));
        dataSource.setJdbcUrl(env.getProperty("app.datasource.oracle.url"));
        dataSource.setUsername(env.getProperty("app.datasource.oracle.username"));
        dataSource.setPassword(env.getProperty("app.datasource.oracle.password"));
        dataSource.setMaximumPoolSize(Integer.parseInt(env.getProperty("app.datasource.oracle.maximum-pool-size")));

        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean oracleEntityManager() {

        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(oracleDataSource());
        em.setPersistenceUnitName("OraclePersistenceUnit");
        em.setPackagesToScan(
                new String[] { "com.hyl.springdemo.domain.oracle" });

        HibernateJpaVendorAdapter vendorAdapter
                = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>(2);
        properties.put("hibernate.hbm2ddl.auto",
                env.getProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect",
                //"org.hibernate.dialect.Oracle8iDialect");
                "org.hibernate.dialect.Oracle10gDialect");
        em.setJpaPropertyMap(properties);

        return em;
    }

    @Bean
    public PlatformTransactionManager oracleTransactionManager() {

        JpaTransactionManager transactionManager
                = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                oracleEntityManager().getObject());
        return transactionManager;
    }
}

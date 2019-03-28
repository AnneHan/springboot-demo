package com.hyl.springdemo.config;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
        basePackages = "com.hyl.springdemo.repository.mysql",
        entityManagerFactoryRef = "mysqlEntityManager",
        transactionManagerRef = "mysqlTransactionManager"
)
public class MysqlDatabaseConfig {

    @Autowired
    private Environment env;

    @Bean
    @Primary
    public DataSource mysqlDataSource() {

        HikariDataSource dataSource = DataSourceBuilder.create().type(HikariDataSource.class).build();
        dataSource.setDriverClassName(env.getProperty("app.datasource.mysql.driver-class-name"));
        dataSource.setJdbcUrl(env.getProperty("app.datasource.mysql.url"));
        dataSource.setUsername(env.getProperty("app.datasource.mysql.username"));
        dataSource.setPassword(env.getProperty("app.datasource.mysql.password"));
        dataSource.setMaximumPoolSize(Integer.parseInt(env.getProperty("app.datasource.mysql.maximum-pool-size")));

        return dataSource;
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean mysqlEntityManager() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(mysqlDataSource());
        em.setPackagesToScan(
                new String[] { "com.hyl.springdemo.domain.mysql" });

        HibernateJpaVendorAdapter vendorAdapter
                = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setPersistenceUnitName("MysqlPersistenceUnit");
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto",
                env.getProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect",
                "org.hibernate.dialect.MySQL5Dialect");
        em.setJpaPropertyMap(properties);

        return em;
    }

    @Bean
    @Primary
    public PlatformTransactionManager mysqlTransactionManager() {

        JpaTransactionManager transactionManager
                = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                mysqlEntityManager().getObject());
        return transactionManager;
    }
}

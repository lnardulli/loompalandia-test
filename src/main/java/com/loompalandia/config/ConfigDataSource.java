package com.loompalandia.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@PropertySource({ "classpath:persistence-mysql-db.properties" })
@EnableJpaRepositories(
        basePackages = "com.loompalandia",
        entityManagerFactoryRef = "oompaloompaEntityManager",
        transactionManagerRef = "oompaloompaTransactionManager"
)
public class ConfigDataSource {
    @Autowired
    private Environment env;

    @Bean
    public LocalContainerEntityManagerFactoryBean oompaloompaEntityManager() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(oompaloompaDataSource());
        em.setPackagesToScan(
                new String[] { "com.loompalandia" });

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.ddl-auto",
                env.getProperty("hibernate.ddl-auto"));
        properties.put("hibernate.dialect",
                env.getProperty("hibernate.dialect"));
        em.setJpaPropertyMap(properties);

        return em;
    }

    @Bean
    public DataSource oompaloompaDataSource() {

        DriverManagerDataSource dataSource
                = new DriverManagerDataSource();
        dataSource.setDriverClassName(
                env.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.user"));
        dataSource.setPassword(env.getProperty("jdbc.pass"));

        return dataSource;
    }

    @Bean
    public PlatformTransactionManager oompaloompaTransactionManager() {

        JpaTransactionManager transactionManager
                = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                oompaloompaEntityManager().getObject());
        return transactionManager;
    }
}
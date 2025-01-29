package com.pinnacle.database.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.pinnacle.database.repository", 
        entityManagerFactoryRef = "mysqlEntityManagerFactory",  
        transactionManagerRef = "mysqlTransactionManager" // Corrected name for consistency
)
@EnableTransactionManagement
public class MysqlConfig {

    // Define the DataSource bean
    @Bean(name = "mysqlDataSource")
    @Primary
    public DataSource mysqlDataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:mysql://localhost:3306/vehicledb")
                .username("root")
                .password("")  // Add your password here
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .build();
    }

    // Define the EntityManagerFactory bean
    @Bean(name = "mysqlEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactory(
            @Qualifier("mysqlDataSource") DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        
        // Set the data source
        factoryBean.setDataSource(dataSource);

        // Specify the base package to scan for entities (adjust this as per your actual package structure)
        factoryBean.setPackagesToScan("com.example.demo.model");

        // Set Hibernate as the JPA vendor
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        factoryBean.setJpaVendorAdapter(vendorAdapter);

        // Additional JPA properties (Optional)
        factoryBean.getJpaPropertyMap().put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        factoryBean.getJpaPropertyMap().put("hibernate.hbm2ddl.auto", "update");
        factoryBean.getJpaPropertyMap().put("hibernate.show_sql", "true");

        return factoryBean;
    }

    // Define the PlatformTransactionManager bean
    @Bean(name = "mysqlTransactionManager")
    @Primary
    public PlatformTransactionManager transactionManager(@Qualifier("mysqlEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

}

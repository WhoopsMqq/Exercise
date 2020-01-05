package com.whoops.cloud.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(
        basePackages = {"com.whoops.cloud.repository.foreign"},// 1. dao 层所在的包
        entityManagerFactoryRef = "foreignEntityManagerFactory",
        transactionManagerRef = "foreignTransactionManager")
@EnableTransactionManagement
public class ForeignConfig {

    @Bean
    public PlatformTransactionManager foreignTransactionManager() {
        return new JpaTransactionManager(foreignEntityManagerFactory().getObject());
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean foreignEntityManagerFactory() {

        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();

        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(foreignDataSource());
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        factoryBean.setJpaProperties(hibernateProperties());

        factoryBean.setPackagesToScan("com.whoops.cloud.entity");// 2. 实体类所在的包

        return factoryBean;
    }

    @Bean
    @ConfigurationProperties("spring.datasource.foreign")
    public DataSourceProperties foreignDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.foreign.configuration")
    public DataSource foreignDataSource() {
        return foreignDataSourceProperties()
                .initializeDataSourceBuilder()
                .type(HikariDataSource.class) // 3. 可以显示指定连接池，也可以不显示指定；即此行代码可以注释掉
                .build();
    }

    private Properties hibernateProperties() {
        final Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
        return hibernateProperties;
    }

}

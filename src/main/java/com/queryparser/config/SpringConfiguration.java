package com.queryparser.config;

//import ch.qos.logback.classic.BasicConfigurator;
//import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class SpringConfiguration {
    @Autowired
    private Environment environment;

    @Bean
    @Primary
    public DataSource mysqlDataSource()
    {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
       // dataSource.setDriverClassName(environment.getProperty("spring.datasource1.driver-class-name"));
        dataSource.setUrl(environment.getProperty("spring.datasource.instacart.url"));
        dataSource.setUsername(environment.getProperty("spring.datasource.username"));
        dataSource.setPassword(environment.getProperty("spring.datasource.password"));
        return dataSource;
    }

    @Bean
    public DataSource mysqlAdniDataSource()
    {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
        dataSource.setUrl(environment.getProperty("spring.datasource.adnimerge.url"));
        dataSource.setUsername(environment.getProperty("spring.secondDatasource.username"));
        dataSource.setPassword(environment.getProperty("spring.secondDatasource.password"));
        return dataSource;
    }

    @Bean
    public DataSource redshiftDataSource()
    {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
        dataSource.setUrl(environment.getProperty("spring.secondDatasource.url"));
        dataSource.setUsername(environment.getProperty("spring.secondDatasource.username"));
        dataSource.setPassword(environment.getProperty("spring.secondDatasource.password"));
        return dataSource;
    }

//    @Bean
//    public DataSource redshiftAdniDataSource()
//    {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(environment.getProperty("spring.Adni.Redshift.Datasource.url"));
//        dataSource.setUrl(environment.getProperty("spring.secondDatasource.url"));
//        dataSource.setUsername(environment.getProperty("spring.secondDatasource.username"));
//        dataSource.setPassword(environment.getProperty("spring.secondDatasource.password"));
//        return dataSource;
//    }

//    @Bean
//    public DataSource mongoDbDataSource()
//    {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(environment.getProperty("spring.datasource.driver-classname"));
//        dataSource.setUrl(environment.getProperty("spring.mongoDbDatasource.url"));
//        return dataSource;
//    }

    @Bean
    public JdbcTemplate jdbcTemplateMysql(@Qualifier("mysqlDataSource") DataSource ds)
    {
        return new JdbcTemplate(ds);
    }

    @Bean
    public JdbcTemplate jdbcTemplateAdniMysql(@Qualifier("mysqlAdniDataSource") DataSource ds)
    {
        return new JdbcTemplate(ds);
    }

    @Bean
    public JdbcTemplate jdbcTemplateRedshift(@Qualifier("redshiftDataSource") DataSource ds)
    {
        return new JdbcTemplate(ds);
    }

//    @Bean
//    public JdbcTemplate jdbcTemplateAdniRedshift(@Qualifier("redshiftAdniDataSource") DataSource ds)
//    {
//        return new JdbcTemplate(ds);
//    }

//    @Bean
//    public DataSource jdbcTemplateMongoDb(@Qualifier("mongoDbDataSource") DataSource ds)
//    {
//        return ds;
//    }



}

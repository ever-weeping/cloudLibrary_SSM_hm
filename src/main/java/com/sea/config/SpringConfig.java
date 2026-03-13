package com.sea.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
/*
将MyBatisConfig类和JdbcConfig类交给Spring管理
 */
@Import({MyBatisConfig.class,JdbcConfig.class})
/*
等同于<context:component-scan base-package = "com.sea.service">
 */
@ComponentScan("com.sea.service")
/*
开启事务
等同于<tx:annotation-driven transaction-manager="transactionManner"/>
 */
@EnableTransactionManagement
public class SpringConfig {
    /*
    等同于<bean class = "org.springframework.jdbc.datasource.DataSourceTransactionManner">
     */
    @Bean("transactionManager")
    public DataSourceTransactionManager getDataSourceTxManager(@Autowired DataSource dataSource){
        DataSourceTransactionManager dtm = new DataSourceTransactionManager();
        // 等同于<property name = "dataSource" ref = "dataSource"/>
        dtm.setDataSource(dataSource);
        return dtm;
    }
}

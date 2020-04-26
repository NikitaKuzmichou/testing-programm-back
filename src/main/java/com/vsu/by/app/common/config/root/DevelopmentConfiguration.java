package com.vsu.by.app.common.config.root;

import com.vsu.by.app.common.config.db.DbConfiguration;
import com.vsu.by.app.common.config.db.H2DbConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class DevelopmentConfiguration {
    /**TODO Ну такое. В релиз не нужно в таком виде отправлять*/
    private DbConfiguration dbConfiguration = new H2DbConfiguration();

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            DriverManagerDataSource dataSource) {
        LocalContainerEntityManagerFactoryBean
                entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setPackagesToScan(
                "com.vsu.by.app.people.groups",
                "com.vsu.by.app.people.pupils",
                "com.vsu.by.app.people.teacher",
                "com.vsu.by.app.people.user",
                "com.vsu.by.app.role",
                "com.vsu.by.app.education.attempt",
                "com.vsu.by.app.education.pupilattempt",
                "com.vsu.by.app.education.pupilmistake",
                "com.vsu.by.app.education.mistake",
                "com.vsu.by.app.education.rule",
                "com.vsu.by.app.education.subject",
                "com.vsu.by.app.education.task",
                "com.vsu.by.app.education.tasktype");
        entityManagerFactoryBean.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setJpaProperties(this.getJpaProperty());
        return entityManagerFactoryBean;
    }

    @Bean
    public DriverManagerDataSource dataSource(){
        DriverManagerDataSource dataSource = this.dbConfiguration.dataSource();
        return dataSource;
    }

    private Properties getJpaProperty(){
        Properties props = new Properties();
        //props.setProperty("hibernate.hbm2ddl.auto", "update");
        props.setProperty("hibernate.show_sql", "true");
        props.setProperty("hibernate.format_sql", "true");
        props.setProperty("logging.level.org.hibernate.SQL", "DEBUG");
        props.setProperty("hibernate.use_sql_comments","true");
        //props.setProperty("spring.jpa.hibernate.ddl-auto", "create-drop");
        //props.setProperty("spring.jpa.properties.hibernate.show-sql", "true");
        //props.setProperty("spring.jpa.properties.hibernate.format_sql", "true");
        //props.setProperty("spring.jpa.properties..hibernate.SQL", "debug");
        //props.setProperty("spring.jpa.properties.hibernate.use_sql_comments","true");
        return props;
    }
}

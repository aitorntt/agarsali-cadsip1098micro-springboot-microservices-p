package com.dedalow.cad.micro.config;

import com.zaxxer.hikari.HikariDataSource;
import java.util.Properties;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(
    basePackages = {"com.dedalow.cad.micro.repository.internal"},
    entityManagerFactoryRef = "internalEntityManagerFactory",
    transactionManagerRef = "internalTransactionManager")
public class InternalDataSourceConfig {

  @Value("${domain.internal.datasource.username}")
  private String username;

  @Value("${domain.internal.datasource.password}")
  private String password;

  @Value("${domain.internal.datasource.url}")
  private String dataSourceUrl;

  @Value("${domain.internal.datasource.schema}")
  private String schema;

  @Value("${domain.internal.datasource.className}")
  private String dataSourceClassName;

  @Value("${domain.internal.datasource.connectionTimeout}")
  private int connectionTimeout;

  @Value("${domain.internal.datasource.maxLifetime}")
  private int maxLifetime;

  @Value("${domain.internal.datasource.maxPoolSize}")
  private int maxPoolSize;

  @Value("${domain.internal.datasource.ddlStrategy}")
  private String ddlStrategy;

  @Value("${domain.internal.datasource.dialect}")
  private String hibernateDialect;

  @Bean
  public DataSource internalDataSource() {
    final HikariDataSource source = new HikariDataSource();
    source.setDriverClassName(dataSourceClassName);
    source.setJdbcUrl(dataSourceUrl);
    source.setUsername(username);
    source.setPassword(password);
    source.setMaximumPoolSize(maxPoolSize);
    if (!StringUtils.isEmpty(schema)) {
      source.setSchema(schema);
    }
    return source;
  }

  @Bean
  @Primary
  public PlatformTransactionManager internalTransactionManager() {
    final JpaTransactionManager txManager = new JpaTransactionManager();
    txManager.setEntityManagerFactory(internalEntityManagerFactory());
    return txManager;
  }

  @Bean
  @Primary
  public EntityManagerFactory internalEntityManagerFactory() {
    final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

    final Properties jpaProperties = new Properties();
    jpaProperties.setProperty("hibernate.dialect", this.hibernateDialect);
    jpaProperties.setProperty("hibernate.hbm2ddl.auto", this.ddlStrategy);

    final LocalContainerEntityManagerFactoryBean factory =
        new LocalContainerEntityManagerFactoryBean();
    factory.setJpaProperties(jpaProperties);
    factory.setJpaVendorAdapter(vendorAdapter);
    factory.setPackagesToScan(new String[] {"com.dedalow.cad.micro.repository.internal"});
    factory.setDataSource(internalDataSource());
    factory.afterPropertiesSet();

    return factory.getObject();
  }
}

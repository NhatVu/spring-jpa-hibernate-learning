package org.example.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
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
import java.util.Objects;

/**
 * For multiple datasource, disable autoconfigure for datasource
 * Need to config datasource, entityManager and transactionManager
 * For each datasource, need to have unique entityManager and unqie transactionManager to use JPA.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "org.example.repository.one", // this package will use OneDatasource automatically
        entityManagerFactoryRef = "oneEntityManagerFactory",
        transactionManagerRef = "oneTransactionManager"
)
public class DatasourceOneConfig {
    @Bean
    @Primary // need one datasource to be Primary
    @ConfigurationProperties(prefix = "one.datasource.config") // use for hikari properties
    public DataSource oneDataSource() {
        return oneDataSourceProperties().initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
    }
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "one.datasource")
    public DataSourceProperties oneDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean oneEntityManagerFactory(@Qualifier("oneDataSource") DataSource oneDataSource) {
        EntityManagerFactoryBuilder builder = new EntityManagerFactoryBuilder(new HibernateJpaVendorAdapter(), new JpaProperties().getProperties(), null);
        return builder.dataSource(oneDataSource)
                .packages("org.example.entity") // entity package, not repository package.
                .build();
    }

    @Bean
    public PlatformTransactionManager oneTransactionManager(
            @Qualifier("oneEntityManagerFactory") LocalContainerEntityManagerFactoryBean oneEntityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(oneEntityManagerFactory.getObject()));
    }
}

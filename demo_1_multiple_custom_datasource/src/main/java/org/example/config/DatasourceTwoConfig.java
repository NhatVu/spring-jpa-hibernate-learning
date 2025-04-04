package org.example.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "org.example.repository.two",
        entityManagerFactoryRef = "twoEntityManagerFactory",
        transactionManagerRef = "twoTransactionManager"
)
public class DatasourceTwoConfig {
    @Bean
    @ConfigurationProperties(prefix = "two.datasource.config")
    public DataSource twoDataSource(@Qualifier("twoDataSourceProperties") DataSourceProperties twoDataSourceProperties) {
        return twoDataSourceProperties.initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
    }
    @Bean
    @ConfigurationProperties(prefix="two.datasource")
    public DataSourceProperties twoDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean twoEntityManagerFactory(@Qualifier("twoDataSource") DataSource firstDataSource) {
        EntityManagerFactoryBuilder builder = new EntityManagerFactoryBuilder(new HibernateJpaVendorAdapter(), new JpaProperties().getProperties(), null);
        return builder.dataSource(firstDataSource)
                .packages("org.example.entity")
                .build();
    }

    @Bean
    public PlatformTransactionManager twoTransactionManager(
            @Qualifier("twoEntityManagerFactory") LocalContainerEntityManagerFactoryBean oneEntityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(oneEntityManagerFactory.getObject()));
    }

    @Bean(name = "twoDataSourceJdbcTemplate")
    public NamedParameterJdbcTemplate twoDataSourceJdbcTemplate(@Qualifier("twoDataSource") DataSource twoDataSource) {
        return new NamedParameterJdbcTemplate(twoDataSource);
    }
}

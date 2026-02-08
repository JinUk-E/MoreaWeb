package com.moraegames.adminweb.config

import com.moraegames.adminweb.util.JPAUtills
import com.zaxxer.hikari.HikariDataSource
import jakarta.persistence.EntityManagerFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.sql.DataSource

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    entityManagerFactoryRef = "shortdownEntityManagerFactory",
    transactionManagerRef = "shortdownTransactionManager",
    basePackages = ["com.moraegames.adminweb.api.shortdown.repository"]
)
class ShortdownConfig {

    @Bean(name = ["shortdownDataSourceProperties"])
    @ConfigurationProperties(prefix = "shortdown.datasource")
    fun shortdownDataSourceProperties(): DataSourceProperties = DataSourceProperties()

    @Bean(name = ["shortdownDataSource"])
    @ConfigurationProperties(prefix = "shortdown.datasource.configuration")
    fun shortdownDataSource(
        @Qualifier("shortdownDataSourceProperties")
        shortdownDataSourceProperties: DataSourceProperties) : DataSource
    = shortdownDataSourceProperties
        .initializeDataSourceBuilder()
        .type(HikariDataSource::class.java)
        .build()

    @Bean(name = ["shortdownEntityManagerFactory"])
    fun shortdownEntityManagerFactory(
        @Qualifier("shortdownDataSource") shortdownDataSource: DataSource,
        builder: EntityManagerFactoryBuilder
    ) : LocalContainerEntityManagerFactoryBean
    = builder
        .dataSource(shortdownDataSource)
        .packages("com.moraegames.adminweb.api.shortdown.entity")
        .persistenceUnit("shortdown")
        .properties(JPAUtills.multiDBJpaProperties())
        .build()

    @Bean(name = ["shortdownTransactionManager"])
    fun shortdownTransactionManager(
        @Qualifier("shortdownEntityManagerFactory")
        shortdownEntityManagerFactory : EntityManagerFactory
    ): PlatformTransactionManager
    = JpaTransactionManager(shortdownEntityManagerFactory)

}
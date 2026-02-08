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
import org.springframework.context.annotation.Primary
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.sql.DataSource

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    entityManagerFactoryRef = "webEntityManagerFactory",
    transactionManagerRef = "webTransactionManager",
    basePackages = ["com.moraegames.adminweb.api.web.repository"]
)
class WebConfig {

    @Primary
    @Bean(name = ["webDataSourceProperties"])
    @ConfigurationProperties(prefix = "web.datasource")
    fun webDataSourceProperties(): DataSourceProperties = DataSourceProperties()

    @Primary
    @Bean(name=["webDataSource"])
    @ConfigurationProperties(prefix = "web.datasource.configuration")
    fun webDataSource(@Qualifier("webDataSourceProperties") webDataSourceProperties:
                      DataSourceProperties)
    = webDataSourceProperties
        .initializeDataSourceBuilder()
        .type(HikariDataSource::class.java)
        .build()

    @Primary
    @Bean(name = ["webEntityManagerFactory"])
    fun webEntityManagerFactory(
        @Qualifier("webDataSource") webDataSource: DataSource,
        builder: EntityManagerFactoryBuilder
    ) : LocalContainerEntityManagerFactoryBean =
        builder
            .dataSource(webDataSource)
            .packages("com.moraegames.adminweb.api.web.entity")
            .persistenceUnit("web")
            .properties(JPAUtills.multiDBJpaProperties())
            .build()


    @Primary
    @Bean(name = ["webTransactionManager"])
    fun webTransactionManager(
        @Qualifier("webEntityManagerFactory") webEntityManagerFactory: EntityManagerFactory
    ) : PlatformTransactionManager
    = JpaTransactionManager(webEntityManagerFactory)
}
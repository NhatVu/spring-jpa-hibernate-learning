
## Demo 1: multiple datasource with Hikari Config 

Typically, the SpringBoot application will only work with a unique  Datasource. In that case, we can use Auto-configuration and datasource in the _application.properties_ file with the prefix *spring.datasource.**

However, in some scenarios, we need two or more Datasource parallel. This demo briefly shows how to do it. For more details, please look at the references section. 

### Overview of how Auto-Configuration work with JPA and Hibernate 
For Entity object, it will denote with annotation *@Entity*

By default, in the Main class, when SpringBoot starts the application with *@SpringBootApplication*, DataSourceAutoConfiguration will be run. It will automatically scan sub-packages for finding Entity,  EnableJpaRepositories, creating EntityManager, transactionManager and setting Hikari connection pool.

When working with JPA, it's required to have EntityManager (the same with Session in Hibernate). 

For each datasource, it only has one entityManager and one transactionManager. 

### Multiple datasource
With multiple datasource, it requires to config manually. As per SpringBoot document said: _"If you need to use JPA against multiple data sources, you likely need one EntityManagerFactory per data source."_, and _"You should provide a similar configuration for any additional data sources for which you need JPA access. To complete the picture, you need to configure a JpaTransactionManager for each EntityManagerFactory as well."_. 

In the code example, under the config package, each datasource will have a separate config file.

There are some steps below:
1. The first step is to disable _DataSourceAutoConfiguration_ by property: spring.autoconfigure.exclude
2. For each datasource, config datasourceProperties, datasource, entityManager and transactionManager. In EntityManager, we need to specify the Entity package that will be handled by the EntityManager. Make sure to expose the prefix config for the Hikari pool.
3. Each datasource also handles repositories based on config in *EnableJpaRepositories*. Check DatasourceOneConfig class for more information.

**References:** 
1. https://www.baeldung.com/spring-boot-configure-multiple-datasources
2. https://docs.spring.io/spring-boot/docs/2.7.16/reference/html/howto.html#howto.data-access.use-custom-entity-manager
3. https://stackoverflow.com/questions/69289976/spring-boot-2-multiple-datasource-work-only-the-one-with-primay-annotation

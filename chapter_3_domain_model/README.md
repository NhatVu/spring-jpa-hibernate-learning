## Chapter 3: Domain model and metadata 
Please read book for more information 

In short, there exists object/relation mismatch (ex: many-to-many relationship, we need to create additional table, but object doesn't need), ORM can work well for nearly 95% scenario. ORM is not a perfect solution but it's good to use 

**Java Bean Validation** is a way to validate Bean object, to check whether satisfied behaviour. Instead of writing if/else, we can use annotation for it. The specification is described in *jakarta.validation-api* and *hibernate-validation* is an implementation of it. 

Note that, we need to check which validation-api specification supported by hibernate. There are distinguish between version 2 and 3. Check at: https://hibernate.org/validator/releases/

In this example, we call validation manually. But when using framework like Spring, the validation is triggered automatically. Importatn to note that we can validate bean at any layer we want, not restricted on persistant layer.

Some validation annotation can effect DDL, such as NOT NULL. However, it recommends to use Flyway for database schema management. Don't try to create schema from entity class. 
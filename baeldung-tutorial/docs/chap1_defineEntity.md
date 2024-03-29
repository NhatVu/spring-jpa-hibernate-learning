## Chapter 1: Defining Entity 

In order to define Entity, using @Entity annotation at class level. We need to use POJO object with no-arg constructor with primary key. 

To custom table name, we can use @Entity(name="student") or @Table(name="STUDENT", schema="SCHOOL")

```java
@Entity(name="student")
public class Student {
    
    // fields, getters and setters
    
}

// or 

@Entity
@Table(name="STUDENT", schema="SCHOOL")
// normally, SpringBoot is only use 1 datasource, then we can use default schema in connectionString. However, if we want to use multiple datasource, need so specify schema name in Entity. 
public class Student {

    // fields, getters and setters
    
}
```

Each JPA entity must have a primary key that uniquely identifies it. Using @Id and @GeneratedValue annotation. For this example, we use GenerationType.SEQUENCE. We will create a custom sequence for each entity. Check StudentEntity class for more detail. 

If we want to custom column name in Entity, using @Column annotation. The @Column annotation has many elements such as name, length, nullable, and unique

If we want to make a non-persist field, using @Transient annotation. 

```java
@Entity
@Table(name="STUDENT")
public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    @Column(name="STUDENT_NAME", length=50)
    private String name;
    
    @Transient
    private Integer age;
    
    // other fields, getters and setters
}
```

### Table name 
By default, JPA defines table name thorough *ImplicitNamingStrategy* contract. It will capitalize the first character of the class. We can change this behaviour by implementing a *PhysicalNamingStrategy* interface.

I prefer to use annotation approach, @jakarta.persistence.Table. Check previous example.

###  Overwriting the Table Name in JPQL Queries 
```java
@Entity
public class Article {
    // ...
}
```

By default, in JPQL queries, we use the entity class name: `select * from Article`

If we change the Entity table name to `@Entity(name = "MyArticle")`, JPQL becomes `select * from MyArticle`.

References:
1. https://www.baeldung.com/jpa-entities 
2. https://www.baeldung.com/hibernate-identifiers
3. https://www.baeldung.com/jpa-entity-table-names
## Chapter 3: Default Column values 

When talking about default value, there can be two ways;
- Default value when creating Entity 
- Default value in schema definition. (I don't recommend this approach. In production env, we should you Flyway to manage database schema)

If we choose default value when creating Entity, it can be: 
```java
@Entity
public class User {
    @Id
    private Long id;
    private String firstName = "John Snow";
    private Integer age = 25;
    private Boolean locked = false;
}
```

If we let Hibernate create Schema for us, we can do as following:
```java
@Entity
public class User {
    @Id
    Long id;

    @Column(columnDefinition = "varchar(255) default 'John Snow'")
    private String name;

    @Column(columnDefinition = "integer default 25")
    private Integer age;

    @Column(columnDefinition = "boolean default false")
    private Boolean locked;
}
```

Above code will generate below schema: 
```roomsql
create table user
(
    id     bigint not null constraint user_pkey primary key,
    name   varchar(255) default 'John Snow',
    age    integer      default 35,
    locked boolean      default false
);
```

by using Schema default solution, we won’t be able to set a given column to null when saving the entity for the first time. Personally, I think this approach is not flexible and I don't recommend it.

### Using default value with @Builder (lombok library)
Normally, Entity have many properties. Thus, it's better to use Builder pattern.

Refs:
1. https://www.baeldung.com/jpa-default-column-values
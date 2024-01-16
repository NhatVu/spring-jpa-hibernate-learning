## Chapter 4. Difference Between @Size, @Length, and @Column(length=value)

This is a short note from artical [1]

Used for validadtion
- @Size: Java standard annotation 
- @Length: Hibernate specific annotation

Used for DDL 
- @Column(length=value): JPA annotation to control DDL statement. When we use Flyway or table is already exist, I think it won't work 

We can combine to use @Size and @Column together 

Example:

```java
import javax.persistence.Table;

@Entity
@Table(name = "UserInfo")
public class User {

    // ... 

    @Column(length = 5) // JPA annotation, used for DDL
    @Size(min = 3, max = 5) // Java bean validation annotation
    private String city;

    // ...

}
```

For SpringBoot validation, add 
```xml
<dependency> 
    <groupId>org.springframework.boot</groupId> 
    <artifactId>spring-boot-starter-validation</artifactId> 
</dependency>
```
References: 
1. https://www.baeldung.com/jpa-size-length-column-differences
2. https://www.baeldung.com/spring-boot-bean-validation
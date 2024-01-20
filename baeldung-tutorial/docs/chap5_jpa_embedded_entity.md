## Jpa @Embedded and @Embeddable

Entity can contain Embedded object (not primary type like String, int), but the table can only contain flat columns. 

For example, Compnay table can be like: 
```java
public class Company {

    private Integer id;

    private String name;

    private String address;

    private String phone;

    private String contactFirstName;

    private String contactLastName;

    private String contactPhone;

    // standard getters, setters
}
```

However, it seems like the contact person should be abstracted out to a separate class, the ContactPerson class. And we don't want to create another table to store contact. We need to use the old schema. 

We can use @Embeddable and @Embedded annotation 

```java
@Embeddable
@AttributeOverrides({
        @AttributeOverride( name = "firstName", column = @Column(name = "contact_first_name")),
        @AttributeOverride( name = "lastName", column = @Column(name = "contact_last_name")),
        @AttributeOverride( name = "phone", column = @Column(name = "contact_phone"))
})
public class ContactPerson {

    private String firstName;

    private String lastName;

    private String phone;

    // standard getters, setters
}

@Entity
public class Company {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String address;

    private String phone;

    @Embedded
    private ContactPerson contactPerson;

    // standard getters, setters
}
```






Reference: 
1. https://www.baeldung.com/jpa-embedded-embeddable 
2. 
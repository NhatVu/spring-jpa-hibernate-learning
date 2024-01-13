## Chapter 2: JPA Entity Lifecycle Events 

JPA specifies seven optional lifecycle events that are called:
- before persist is called for a new entity – @PrePersist
- after persist is called for a new entity – @PostPersist
- before an entity is removed – @PreRemove
- after an entity has been deleted – @PostRemove
- before the update operation – @PreUpdate
- after an entity is updated – @PostUpdate
- after an entity has been loaded – @PostLoad

There are two approaches for using the lifecycle event annotations: 
- annotating methods in the entity 
- creating an EntityListener with annotated callback methods.

As I understand, these Entity lifecycle event is only apply for database provider that implement JPA specification. Hibernate supports this feature. With MongoDB, we can't use these event lifecycle. Check ref [2]


References:
1. https://www.baeldung.com/jpa-entity-lifecycle-events
2. https://docs.spring.io/spring-data/mongodb/reference/mongodb/lifecycle-events.html
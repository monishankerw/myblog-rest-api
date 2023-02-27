package com.myblogrestapi.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"username"}),
        @UniqueConstraint(columnNames = {"email"})
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String username;
    private String email;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles;
    //    The fetch attribute in this annotation is used to control the fetching strategy for the related entities. The FetchType.EAGER value indicates that the related entities should be fetched eagerly, meaning they will be loaded from the database along with the parent entity when the parent entity is loaded. In contrast, if FetchType.LAZY is used, the related entities would be loaded only when they are accessed, not immediately when the parent entity is loaded.
    //
    //It's worth noting that choosing the appropriate fetch strategy depends on your application's specific use case and requirements. Eager fetching can be more performant if you always need the related entities, but it can also consume more memory and resources, especially if the related entities are large. On the other hand, lazy fetching can be more efficient, but can result in additional database queries when the related entities are accessed.
}

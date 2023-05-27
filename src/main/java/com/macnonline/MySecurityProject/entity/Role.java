package com.macnonline.MySecurityProject.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany
    @JoinTable(name="users_roles",joinColumns=
            @JoinColumn(name="users_id"),inverseJoinColumns =
            @JoinColumn(name="roles_id"))

    private List<Users> users;
}

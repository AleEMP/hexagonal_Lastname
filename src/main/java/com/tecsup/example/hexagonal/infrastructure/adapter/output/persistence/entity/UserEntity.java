package com.tecsup.example.hexagonal.infrastructure.adapter.output.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 150)
    private String email;

    private String password;

    @Column (nullable = true , length = 9)
    private String phone;
    @Column (nullable = false, length = 8)
    private String dni;
    @Column (nullable = false, length = 100)
    private String father_lastname;
    @Column (nullable = true, length = 100)
    private String mother_lastname;
    @Column
    private int age;

    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "role_id", nullable=false)
    private RoleEntity role;

}

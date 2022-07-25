package com.JavaCourse.Course.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@ToString @EqualsAndHashCode
public class User {
    @Getter @Setter @Column(name = "name")
    private String name;
    @Getter @Setter @Column(name = "lastname")
    private String lastName;
    @Getter @Setter @Column(name = "address")
    private String address;
    @Getter @Setter @Column(name = "email")
    private String email;
    @Getter @Setter @Column(name = "phone")
    private String phoneNumber;
    @Getter @Setter @Column(name = "password")
    private String password;

    @Id
    @Getter @Setter
    private Long id;


}

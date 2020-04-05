package com.studio.studio.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User extends AuditModel {
//learn how to input the primary key here for userid. use annotation @id
@Id
@Column(name = "userid", updatable = false, nullable = false)
@GeneratedValue(generator = "userid")
@GenericGenerator(
        name = "userid",
        strategy = "org.hibernate.id.UUIDGenerator"
)
private UUID userid;

@NotBlank
@Column(name = "username")  
private String username;

@NotBlank
@Column(name = "password")
private String password;

@Column(name = "age")
private Integer age;

@Column(name = "firstname")
private String firstname;

@Column(name = "lastname")
private String lastname;

@Column(name = "phonenumber")
private String phonenumber;

    public UUID getUserid() {
        return userid;
    }

    public void setUserid(UUID userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }


}

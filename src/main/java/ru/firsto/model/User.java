package ru.firsto.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by razor on 21.11.15.
 */

@Entity
@Table(name="User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int age;
//    @Type(type="true_false")
    @Column(name = "isadmin", columnDefinition = "BIT", length = 1)
    private boolean isAdmin;
    @Column(name = "createddate")
    private Timestamp createdDate;

    protected User() {}

    public User(String name, int age, boolean isAdmin, Timestamp createdDate) {
        this.name = name;
        this.age = age;
        this.isAdmin = isAdmin;
        this.createdDate = createdDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Date getCreatedDate() {
        return new Date(createdDate.getTime());
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }
}

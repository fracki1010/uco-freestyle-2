package com.ucofreestyle2.ucoFreestyle2.models;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy="native")
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String passwordConfirmation;
    private String dni;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="membership_id")
    private Membrership membership;

    public Client(){
    }

    public Client(String firstName, String lastName, String email, String password, String passwordConfirmation, String dni) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.passwordConfirmation = passwordConfirmation;
        this.dni = dni;
    }


    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Membrership getMembership() {
        return membership;
    }

    public void setMembership(Membrership membership) {
        this.membership = membership;
    }


}

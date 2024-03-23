package com.ucofreestyle2.ucoFreestyle2.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private String name;
    private String description;
    private String image;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="membership_id")
    private Membrership membership;

    public Event() {
    }

    public Event(String name, String description, String image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public Membrership getMembrership() {
        return membership;
    }

    public void setMembrership(Membrership membrership) {
        this.membership = membrership;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }



    /*@OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private Set<Membrership> membrerships = new HashSet<>();*/

}
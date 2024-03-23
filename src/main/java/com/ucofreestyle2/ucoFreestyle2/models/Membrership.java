package com.ucofreestyle2.ucoFreestyle2.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Membrership {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy="native")
    private Long id;

    private String name;
    private AFFILIATION affiliation;
    private Boolean enabled;

    @OneToMany(mappedBy = "membership", fetch = FetchType.EAGER)
    private Set<Client> clients = new HashSet<>();

    @OneToMany(mappedBy = "membership", fetch = FetchType.EAGER)
    private Set<Event> events = new HashSet<>();

    public Membrership() {
    }

    public Membrership(String name, AFFILIATION affiliation, Boolean enabled) {
        this.name = name;
        this.affiliation = affiliation;
        this.enabled = enabled;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AFFILIATION getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(AFFILIATION affiliation) {
        this.affiliation = affiliation;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    public void addClient(Client client) {
        client.setMembership(this);
        clients.add(client);
    }

    public void removeClient(Client client) {
        clients.remove(client);
    }

    public void addEvent(Event event){
        event.setMembrership(this);
        events.add(event);
    }
}

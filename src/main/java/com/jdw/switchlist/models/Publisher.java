package com.jdw.switchlist.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "publishers")
public class Publisher extends Auditable
{
    // fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long publisherid;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("publisher")
    private List<Game> games = new ArrayList<>();

    // constructors
    public Publisher()
    {
    }

    public Publisher(String name)
    {
        this.name = name;
    }

    // getters and setters
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<Game> getGames()
    {
        return games;
    }

    public void setGames(List<Game> games)
    {
        this.games = games;
    }
    // methods
}

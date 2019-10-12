package com.jdw.switchlist.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "games")
public class Game extends Auditable
{
    // fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long gameid;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String releasedate;

    private String series;

    @ManyToOne
    @JoinColumn(name = "publisherid", nullable = false)
    @JsonIgnoreProperties("games")
    private Publisher publisher;

    @Column(nullable = false)
    private String caseimg;

    // constructors
    public Game()
    {
    }

    public Game(String name, String releasedate, String series, Publisher publisher, String caseimg)
    {
        this.name = name;
        this.releasedate = releasedate;
        this.series = series;
        this.publisher = publisher;
        this.caseimg = caseimg;
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

    public String getReleasedate()
    {
        return releasedate;
    }

    public void setReleasedate(String releasedate)
    {
        this.releasedate = releasedate;
    }

    public String getSeries()
    {
        return series;
    }

    public void setSeries(String series)
    {
        this.series = series;
    }

    public Publisher getPublisher()
    {
        return publisher;
    }

    public void setPublisher(Publisher publisher)
    {
        this.publisher = publisher;
    }

    public String getCaseimg()
    {
        return caseimg;
    }

    public void setCaseimg(String caseimg)
    {
        this.caseimg = caseimg;
    }

    // methods
}

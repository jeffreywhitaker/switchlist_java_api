package com.jdw.switchlist;

import com.jdw.switchlist.models.Game;
import com.jdw.switchlist.models.Publisher;
import com.jdw.switchlist.repositories.GameRepository;
import com.jdw.switchlist.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
public class SeedData implements CommandLineRunner
{
    private GameRepository gamerepos;
    private PublisherRepository publisherrepos;

    public SeedData(GameRepository gamerepos, PublisherRepository publisherrepos)
    {
        this.gamerepos = gamerepos;
        this.publisherrepos = publisherrepos;
    }

    @Override
    public void run(String[] args) throws Exception
    {
        // user seed data

        // publisher seed data
        Publisher p01 = new Publisher("Nintendo");
        Publisher p02 = new Publisher("Motion Twin");

        // game seed data
        Game g01 = new Game("Super Mario Odyssey", "10-27-2017", "Super Mario", p01, "https://upload.wikimedia.org/wikipedia/en/8/8d/Super_Mario_Odyssey.jpg");
        Game g02 = new Game("Dead Cells", "08-07-2018", null, p02, "https://www.mobygames.com/images/covers/l/498109-dead-cells-xbox-one-front-cover.jpg");
        Game g03 = new Game("Fire Emblem: Three Houses", "06-26-2019", "Fire Emblem", p01, "https://upload.wikimedia.org/wikipedia/en/1/16/Fire_Emblem_Three_Houses.jpg");

        publisherrepos.save(p01);
        publisherrepos.save(p02);

        gamerepos.save(g01);
        gamerepos.save(g02);
        gamerepos.save(g03);





        // director seed data


    }
}

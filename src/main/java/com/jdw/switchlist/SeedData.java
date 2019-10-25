package com.jdw.switchlist;

import com.jdw.switchlist.models.*;
import com.jdw.switchlist.repositories.GameRepository;
import com.jdw.switchlist.repositories.PublisherRepository;
import com.jdw.switchlist.services.RoleService;
import com.jdw.switchlist.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Transactional
@Component
public class SeedData implements CommandLineRunner
{
    private GameRepository gamerepos;
    private PublisherRepository publisherrepos;
    private RoleService roleService;
    private UserService userService;

    public SeedData(GameRepository gamerepos, PublisherRepository publisherrepos, RoleService roleService, UserService userService)
    {
        this.gamerepos = gamerepos;
        this.publisherrepos = publisherrepos;
        this.roleService = roleService;
        this.userService = userService;
    }

    @Override
    public void run(String[] args) throws Exception
    {
        // roles
        Role r1 = new Role("admin");
        Role r2 = new Role("user");
        Role r3 = new Role("data");

        roleService.save(r1);
        roleService.save(r2);
        roleService.save(r3);

        // admin account
        ArrayList<UserRoles> admins = new ArrayList<>();
        admins.add(new UserRoles(new User(),
                r1));
        admins.add(new UserRoles(new User(),
                r2));
        admins.add(new UserRoles(new User(),
                r3));
        User u1 = new User("admin",
                "password",
                "admin@lambdaschool.local",
                admins);
        u1.getUseremails()
                .add(new Useremail(u1,
                        "admin@email.local"));
        u1.getUseremails()
                .add(new Useremail(u1,
                        "admin@mymail.local"));

        userService.save(u1);

        // testUser account
        ArrayList<UserRoles> users;

        users = new ArrayList<>();
        users.add(new UserRoles(new User(),
                r2));
        User u4 = new User("testUser", "password", "test@email.com", users);

        User u4Saved = userService.save(u4);

        // publisher seed data
        Publisher p01 = new Publisher("Nintendo");
        Publisher p02 = new Publisher("Motion Twin");

        publisherrepos.save(p01);
        publisherrepos.save(p02);

        // game seed data
        Game g01 = new Game("Super Mario Odyssey", "10-27-2017", "Super Mario", p01, "https://upload.wikimedia.org/wikipedia/en/8/8d/Super_Mario_Odyssey.jpg");
        Game g02 = new Game("Dead Cells", "08-07-2018", null, p02, "https://www.mobygames.com/images/covers/l/498109-dead-cells-xbox-one-front-cover.jpg");
        Game g03 = new Game("Fire Emblem: Three Houses", "06-26-2019", "Fire Emblem", p01, "https://upload.wikimedia.org/wikipedia/en/1/16/Fire_Emblem_Three_Houses.jpg");

        gamerepos.save(g01);
        gamerepos.save(g02);
        gamerepos.save(g03);

        // director seed data


    }
}

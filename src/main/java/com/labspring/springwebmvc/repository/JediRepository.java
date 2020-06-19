package com.labspring.springwebmvc.repository;

import com.labspring.springwebmvc.model.Jedi;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class JediRepository {
    private List<Jedi> jedis;

    public JediRepository() {
        this.jedis = new ArrayList<>();
        this.jedis.add(new Jedi("Luke", "Skywalker"));
        this.jedis.add(new Jedi("Obi-Wan", "Kenobi"));
        this.jedis.add(new Jedi("Qui-Gon", "Jinn"));
    }

    public List<Jedi> getAll() {
        return this.jedis;
    }

    public void add(final Jedi jedi) {
        this.jedis.add(jedi);
    }
}

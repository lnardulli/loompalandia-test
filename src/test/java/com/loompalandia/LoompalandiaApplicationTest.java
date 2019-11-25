package com.loompalandia;

import com.loompalandia.repository.OompaloompaRepository;
import com.loompalandia.entity.Oompaloompa;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@RunWith(SpringRunner.class)
class LoompalandiaApplicationTes2t {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private OompaloompaRepository oompaloompaRepository;

    @Before
    public void before() {

    }

    @Test
    public void createOompaloompaRepository() {

        Oompaloompa oompaloompa = oompaloompaRepository.save(new Oompaloompa("Johnny Depp", 37, "actor", 200, 123, "description"));

        assertEquals("Johnny Depp", oompaloompa.getName());
        assertEquals(37, oompaloompa.getAge());
        assertEquals("actor", oompaloompa.getJob());
        assertEquals(200, oompaloompa.getHeight());
        assertEquals(123, oompaloompa.getWeight());
    }

    @Test
    public void getByIdOompaloompaRepository() {

        oompaloompaRepository.save(new Oompaloompa("Willy Wonka", 37, "job", 200, 123, "description"));

        Oompaloompa oompaloompa = oompaloompaRepository.findById(2L).get();

        assertEquals("Willy Wonka", oompaloompa.getName());
    }

    @Test
    public void listOompaloompaRepository() {

        oompaloompaRepository.save(new Oompaloompa("Johnny Depp", 70, "job", 200, 123, "description"));
        oompaloompaRepository.save(new Oompaloompa("Willy Wonka", 71, "job", 200, 123, "description"));

        List<Oompaloompa> oompaloompaList = oompaloompaRepository.findAll();

        assertEquals(2, oompaloompaList.size());
        Oompaloompa actual = oompaloompaList.get(0);

        assertEquals("Johnny Depp", actual.getName());
        assertEquals(70, actual.getAge());
    }

    @Test
    public void updateOompaloompaRepository() {

        oompaloompaRepository.save(new Oompaloompa("Willy Wonka", 37, "job", 200, 123, "description"));

        List<Oompaloompa> oompaloompaList = oompaloompaRepository.findAll();

        assertEquals(1, oompaloompaList.size());
        Oompaloompa oompaloompa = oompaloompaList.get(0);

        assertEquals("Willy Wonka", oompaloompa.getName());

        oompaloompa.setName("Johnny Depp");

        Oompaloompa oompaloompaUpdate = oompaloompaRepository.save(oompaloompa);

        assertEquals("Johnny Depp", oompaloompaUpdate.getName());
    }

    @After
    public void cleanUp() {
        oompaloompaRepository.deleteAll();
    }

}
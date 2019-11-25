package com.loompalandia.repository;

import com.loompalandia.entity.Oompaloompa;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OompaloompaRepository extends PagingAndSortingRepository<Oompaloompa, Long> {

    List<Oompaloompa> findAll();

    Oompaloompa findById(Integer id);
}

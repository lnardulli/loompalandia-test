package com.loompalandia.repository;

import com.loompalandia.entity.Oompaloompa;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface OompaloompaJpaRepositoryImp extends PagingAndSortingRepository<Oompaloompa, Long> {

    List<Oompaloompa> findAll();

    Oompaloompa findById(Integer id);

    Optional<Oompaloompa> findOneById(Long id);

    Oompaloompa save(Oompaloompa account);
}

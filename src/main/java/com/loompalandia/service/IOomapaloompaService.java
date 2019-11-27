package com.loompalandia.service;

import com.loompalandia.entity.Oompaloompa;
import com.loompalandia.response.OompaloompaResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IOomapaloompaService {

    List<OompaloompaResponse> list(Pageable pageable);

    Oompaloompa getFullDataById(Long id);

    Oompaloompa create(Oompaloompa article);

    void update(Long id, Oompaloompa article);

}

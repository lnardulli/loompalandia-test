package com.loompalandia.service;

import com.loompalandia.repository.OompaloompaRepository;
import com.loompalandia.response.OompaloompaResponse;
import com.loompalandia.entity.Oompaloompa;
import com.loompalandia.exceptions.OompaloompaNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OompaloompaService implements IOomapaloompaService {

    @Autowired
    private OompaloompaRepository oompaloompaRepository;

    public OompaloompaService(OompaloompaRepository oompaloompaRepository) {
        this.oompaloompaRepository = oompaloompaRepository;
    }

    public List<OompaloompaResponse> list(Pageable pageable) {

        Page<Oompaloompa> page = oompaloompaRepository.findAll(pageable);

        if(page.getContent().size() > 0) {

            List<OompaloompaResponse> listResponse = new ArrayList<>(page.getSize());
            for(Oompaloompa oompaloompa : page.getContent()) {
                listResponse.add(new OompaloompaResponse(oompaloompa.getName(), oompaloompa.getAge(), oompaloompa.getJob()));
            }
            return listResponse;

        } else {
            throw new OompaloompaNotFoundException();
        }
    }

    public Oompaloompa getFullDataById(Long id) {

        try {
            Oompaloompa oompaloompa = oompaloompaRepository.findById(id).get();
            return oompaloompa;
        } catch (Exception e) {
            throw new OompaloompaNotFoundException();
        }
    }

    public Oompaloompa create(Oompaloompa oompaloompa) {
        try {
            return oompaloompaRepository.save(oompaloompa);
        } catch (Exception e) {
            throw new OompaloompaNotFoundException();
        }
    }

    public void update(Oompaloompa oompaloompa) {
        try {
            oompaloompaRepository.save(oompaloompa);
        } catch (Exception e) {
            throw new OompaloompaNotFoundException();
        }

    }

}

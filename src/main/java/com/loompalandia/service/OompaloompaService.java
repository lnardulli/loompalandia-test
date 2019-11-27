package com.loompalandia.service;

import com.loompalandia.entity.Oompaloompa;
import com.loompalandia.exceptions.OompaloompaException;
import com.loompalandia.exceptions.OompaloompaNotFoundException;
import com.loompalandia.repository.OompaloompaRepository;
import com.loompalandia.response.OompaloompaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@CacheConfig(cacheNames={"oompaloompa"})
@Service
public class OompaloompaService implements IOomapaloompaService {

    @Autowired
    private OompaloompaRepository oompaloompaRepository;

    public List<OompaloompaResponse> list(Pageable pageable) {
    	
        Page<Oompaloompa> page = oompaloompaRepository.findAll(pageable);

        if(page.getContent().size() > 0) {

            List<OompaloompaResponse> listResponse = new ArrayList<>(page.getSize());
            for(Oompaloompa oompaloompa : page.getContent()) {
                listResponse.add(new OompaloompaResponse(oompaloompa.getId(), oompaloompa.getName(), oompaloompa.getAge(), oompaloompa.getJob()));
            }

            return listResponse;

        } else {
            throw new OompaloompaNotFoundException("Oompa Loompas Not found");
        }
    }

    public Oompaloompa getFullDataById(Long id) {

        try {
            Oompaloompa oompaloompa = oompaloompaRepository.findById(id).get();
            return oompaloompa;
        } catch (Exception e) {
            throw new OompaloompaNotFoundException("Oompa Loompa id: " + id.toString() + " Not found");
        }
    }

    public Oompaloompa create(Oompaloompa oompaloompa) {

        try {
            return oompaloompaRepository.save(oompaloompa);
        } catch (Exception e) {
            throw new OompaloompaException("Error to create Oompa Loompa");
        }
    }

    public void update(Long id, Oompaloompa replaceOompaloompa) {

        Optional<Oompaloompa> oompaloompa = oompaloompaRepository.findById(id);

        if (!oompaloompa.isPresent())
            throw new OompaloompaNotFoundException("Oompa Loompa id: " + id.toString() + " Not found");

        replaceOompaloompa.setId(id);

        try {
            oompaloompaRepository.save(replaceOompaloompa);
        } catch (Exception e) {
            throw new OompaloompaException("Error to update Oompa Loompa: " + id.toString() );
        }
    }

}

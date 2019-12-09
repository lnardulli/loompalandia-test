package com.loompalandia.repository;

import com.loompalandia.dto.OompaloompaDto;
import com.loompalandia.dto.OompaloompaFullDto;
import com.loompalandia.entity.Oompaloompa;
import com.loompalandia.exceptions.OompaloompaNotFoundException;
import com.loompalandia.mapper.OompaloompaFullMapper;
import com.loompalandia.mapper.OompaloompaMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**A Repository for OompaLoompa entities implemented with Data JPA.
 * @author Leandro Nardulli
 *
 */
@Service
public class OompaloompaJpaRepository implements OompaloompaRepository {

    private final OompaloompaJpaRepositoryImp impl;

    @Autowired
    public OompaloompaJpaRepository(final OompaloompaJpaRepositoryImp impl) {
        this.impl = impl;
    }

    private OompaloompaFullMapper oompaloompaFullMapper = Mappers.getMapper(OompaloompaFullMapper.class);

    public List<OompaloompaDto> list(Pageable pageable) {

        Page<Oompaloompa> page = impl.findAll(pageable);
        OompaloompaMapper oompaloompaMapper = Mappers.getMapper(OompaloompaMapper.class);

        if(page!= null && page.getContent() != null && page.getContent().size() > 0)
            return page.getContent().stream()
                        .map(content -> oompaloompaMapper.oompaToDto(content))
                    .collect(Collectors.toList());

        throw new OompaloompaNotFoundException("Oompa Loompas Not found");
    }

    public OompaloompaFullDto getFullDataById(Long id) {

        try {
            return oompaloompaFullMapper.oompaToDto(impl.findById(id).get());

        } catch (Exception e) {
            throw new OompaloompaNotFoundException("Oompa Loompa id: " + id.toString() + " Not found");
        }
    }

    public OompaloompaFullDto create(OompaloompaFullDto oompaloompaFullDto) {

        return oompaloompaFullMapper.oompaToDto(impl.save(oompaloompaFullMapper.dtoToOmmpa(oompaloompaFullDto)));
    }

    public void update(Long id, OompaloompaFullDto replaceOompaloompa) {

        Optional<Oompaloompa> oompaloompa = impl.findById(id);

        if (!oompaloompa.isPresent())
            throw new OompaloompaNotFoundException("Oompa Loompa id: " + id.toString() + " Not found");

        replaceOompaloompa.setId(id);

        impl.save(oompaloompaFullMapper.dtoToOmmpa(replaceOompaloompa));

    }



}

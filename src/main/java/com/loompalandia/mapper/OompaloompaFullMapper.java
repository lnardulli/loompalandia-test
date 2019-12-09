package com.loompalandia.mapper;

import com.loompalandia.dto.OompaloompaFullDto;
import com.loompalandia.entity.Oompaloompa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface OompaloompaFullMapper {

    OompaloompaFullDto oompaToDto(Oompaloompa oompaloompa);

    Oompaloompa dtoToOmmpa(OompaloompaFullDto oompaloompa);

}

package com.loompalandia.mapper;

import com.loompalandia.dto.OompaloompaDto;
import com.loompalandia.entity.Oompaloompa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface OompaloompaMapper {

    OompaloompaDto oompaToDto(Oompaloompa oompaloompa);

}

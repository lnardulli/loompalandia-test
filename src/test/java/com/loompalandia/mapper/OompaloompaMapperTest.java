package com.loompalandia.mapper;

import com.loompalandia.dto.OompaloompaDto;
import com.loompalandia.entity.Oompaloompa;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class OompaloompaMapperTest {

    @Test
    void oompaToDto() {

        OompaloompaMapper instance = Mappers.getMapper(OompaloompaMapper.class);

        Oompaloompa oompaloompa = new Oompaloompa(null, "Morris", 27, "Ninja develop", 189, 90, "De todo");

        OompaloompaDto oompaDto = instance.oompaToDto(oompaloompa);

        assertEquals("Morris", oompaDto.name);

        assertThat( oompaDto ).isNotNull();
        assertThat( oompaDto.age ).isEqualTo( 27 );
        assertThat( oompaDto.name ).isEqualTo( "Morris" );
        assertThat( oompaDto.job ).isEqualTo( "Ninja develop" );
        assertThat( oompaDto ).isInstanceOf( OompaloompaDto.class );

    }
}
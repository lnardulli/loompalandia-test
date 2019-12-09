package com.loompalandia.mapper;

import com.loompalandia.dto.OompaloompaDto;
import com.loompalandia.dto.OompaloompaFullDto;
import com.loompalandia.entity.Oompaloompa;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OompaloompaFullMapperTest {

    @Test
    void oompaToDto() {
        OompaloompaFullMapper instance = Mappers.getMapper(OompaloompaFullMapper.class);

        Oompaloompa oompaloompa = new Oompaloompa(54L, "Morris", 27, "Ninja develop", 189, 90, "De todo");

        OompaloompaFullDto oompaDto = instance.oompaToDto(oompaloompa);

        assertEquals("Morris", oompaDto.getName());

        assertThat( oompaDto ).isNotNull();
        assertThat( oompaDto.getAge() ).isEqualTo( 27 );
        assertThat( oompaDto.getName() ).isEqualTo( "Morris" );
        assertThat( oompaDto.job ).isEqualTo( "Ninja develop" );
        assertThat( oompaDto.height ).isEqualTo( 189 );
        assertThat( oompaDto.weight ).isEqualTo( 90 );
        assertThat( oompaDto.description ).isEqualTo( "De todo" );


        assertThat( oompaDto ).isInstanceOf( OompaloompaFullDto.class );
    }
}
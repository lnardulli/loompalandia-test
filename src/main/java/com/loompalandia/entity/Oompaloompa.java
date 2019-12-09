package com.loompalandia.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Entity model to database.
 * @author Leandro Nardulli
 *
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public @Data class Oompaloompa {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;
    private String name;
    private Integer age;
    private String job;
    private Integer height;
    private Integer weight;
    private String description;


}

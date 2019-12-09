package com.loompalandia.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public @Data class OompaloompaFullDto {

    public Long id;

    @NotEmpty(message = "Name must not be empty")
    public String name;

    @Min(value = 1, message = "Age should not be less than 1")
    @NotNull(message = "Age must not be empty")
    public Integer age;

    @NotEmpty(message = "Job must not be empty")
    public String job;

    public Integer height;

    public Integer weight;

    public String description;

}

package com.loompalandia.controller;

import com.loompalandia.dto.OompaloompaDto;
import com.loompalandia.dto.OompaloompaFullDto;
import com.loompalandia.repository.OompaloompaRepository;
import com.loompalandia.entity.Oompaloompa;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.List;

/**
 * MVC controller with REST service for accessing all external operations of the application.
 * @author Leandro Nardulli
 *
 */

@RestController
@RequestMapping("/v1/api")
@Validated
public class OompaloompaController {

    @Autowired
    private OompaloompaRepository oompaloompaRepository;

    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query",
                    value = "Results page you want to retrieve.", defaultValue = "0"),
            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
                    value = "Number of records per page.", defaultValue = "5")
    })
    @ApiOperation(value = "View a list of available Oompa Loompa", response = Oompaloompa.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list of Oompa Loompa"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/list")

    public @ResponseBody ResponseEntity<List<OompaloompaDto>> list(@ApiIgnore() @PageableDefault(page = 0, size = 20) Pageable pageable) {
        return new ResponseEntity<>(oompaloompaRepository.list(pageable), HttpStatus.OK);
    }

    @ApiOperation(value = "Get an Oompa Loompa by Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/full/{id}")
    public @ResponseBody ResponseEntity<OompaloompaFullDto> getFullDetail(@ApiParam(value = "Oompa Loompa Id to get full data", required = true) @PathVariable("id") Long id) {
        return new ResponseEntity<>(oompaloompaRepository.getFullDataById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Create an Oompa Loompa")
    @PostMapping("/create")
    public @ResponseBody ResponseEntity<OompaloompaFullDto> create(@ApiParam(value = "Update employee object", required = true) @RequestBody @Valid OompaloompaFullDto oompaloompa) {
        return new ResponseEntity<>(oompaloompaRepository.create(oompaloompa), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update an Oompa Loompa")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Update succefull"),
            @ApiResponse(code = 400, message = "Validation error")
    })
    @PutMapping("/update/{id}")
    public  @ResponseBody ResponseEntity<?> update(@ApiParam(value = "Oompa Loompa Id from which employee object will update from database table", required = true) @PathVariable("id") Long id, @ApiParam(value = "Update Oompa Loompa object", required = true) @RequestBody @Valid OompaloompaFullDto oompaloompa) {
        oompaloompaRepository.update(id, oompaloompa);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

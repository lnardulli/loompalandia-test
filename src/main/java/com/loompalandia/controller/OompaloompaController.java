package com.loompalandia.controller;

import com.loompalandia.response.OompaloompaResponse;
import com.loompalandia.service.OompaloompaService;
import com.loompalandia.entity.Oompaloompa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class OompaloompaController {

    @Autowired
    private OompaloompaService oompaloompaService;

    @GetMapping("/list")
    public @ResponseBody ResponseEntity<List<OompaloompaResponse>> list(@PageableDefault(page = 0, size = 20) Pageable pageable) {
        return new ResponseEntity<>(oompaloompaService.list(pageable), HttpStatus.OK);
    }

    @GetMapping("/full/{id}")
    public @ResponseBody ResponseEntity<Oompaloompa> getFullDetail(@PathVariable("id") Long id) {
        return new ResponseEntity<>(oompaloompaService.getFullDataById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public @ResponseBody ResponseEntity<Oompaloompa> create(@RequestBody Oompaloompa oompaloompa) {
        Oompaloompa oompaloompaCreate = oompaloompaService.create(oompaloompa);
        return new ResponseEntity<>(oompaloompaCreate, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public  @ResponseBody ResponseEntity<Void> update(@RequestBody Oompaloompa oompaloompa) {
        oompaloompaService.update(oompaloompa);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

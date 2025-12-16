package com.gabeDev.hexagonalAPI.adapter.controller;

import com.gabeDev.hexagonalAPI.adapter.persistence.mapper.ProduceMapper;
import com.gabeDev.hexagonalAPI.application.dto.CreateProduceRequest;
import com.gabeDev.hexagonalAPI.application.service.ProduceService;
import com.gabeDev.hexagonalAPI.domain.model.Produce;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/produce")
public class ProduceController {

    private final ProduceService produceService;

    public ProduceController(ProduceService produceService){
        this.produceService = produceService;
    }

    @GetMapping
    public ResponseEntity<List<Produce>> findAll(){
        return ResponseEntity.ok(produceService.retrieveAllProduce());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produce> findById(@PathVariable UUID id){
        return ResponseEntity.ok(produceService.retrieveProduce(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Produce> create(@RequestBody CreateProduceRequest request){
        return ResponseEntity.ok(produceService.createNew(ProduceMapper.toDomainFromDto(request)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        produceService.removeProduce(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

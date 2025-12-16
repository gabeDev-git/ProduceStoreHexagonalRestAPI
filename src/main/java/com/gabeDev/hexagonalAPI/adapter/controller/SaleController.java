package com.gabeDev.hexagonalAPI.adapter.controller;

import com.gabeDev.hexagonalAPI.application.dto.CreateSaleRequest;
import com.gabeDev.hexagonalAPI.application.service.SaleService;
import com.gabeDev.hexagonalAPI.domain.model.Sale;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/sale")
public class SaleController {

    private final SaleService saleService;

    public SaleController(SaleService saleService){
        this.saleService = saleService;
    }

    @GetMapping
    public ResponseEntity<List<Sale>> findAll(){
        return ResponseEntity.ok(saleService.retrieveAll());

    }
    @PostMapping("/create")
    public ResponseEntity<Sale> create(@RequestBody CreateSaleRequest request){
        Sale sale = saleService.createNew(request.checkoutMap(), request.paymentMethod());

        return ResponseEntity.status(HttpStatus.CREATED).body(sale);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Sale> findById(@PathVariable UUID id){
        return ResponseEntity.ok(saleService.retrieveSale(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id){
        saleService.deleteSale(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

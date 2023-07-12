package com.paqtafood.controllers;

import com.paqtafood.models.Factura;
import com.paqtafood.services.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1/facturas")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public List<Factura> findAll() {
        return facturaService.findAll();
    }

    @GetMapping("/{id}")
    public Factura findById(@PathVariable("id") Long id) {
        return facturaService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Factura create(@RequestBody Factura factura) {
        return facturaService.save(factura);
    }

    @GetMapping("/user/{id}")
    public List<Factura> getOrdersByUserId(@PathVariable("id") Long id) {
        return new ArrayList<>();
    }

}

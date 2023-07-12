package com.paqtafood.services;

import com.paqtafood.models.Factura;

import java.util.List;

public interface FacturaService {
    List<Factura> findAll();
    Factura findById(Long id);
    Factura save(Factura factura);

    List<Factura> findOrdersByUserId(Long id);
}

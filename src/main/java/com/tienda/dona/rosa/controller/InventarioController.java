package com.tienda.dona.rosa.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.tienda.dona.rosa.model.Producto;
import com.tienda.dona.rosa.service.ProductoService;



@Controller
public class InventarioController {

    private final ProductoService productoService;

    public InventarioController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/inventario")
    public String mostrarInventario(Model model) {
        List<Producto> inventario = productoService.obtenerInventario();
        double costoTotalInventario = productoService.calcularCostoTotalInventario();

        model.addAttribute("inventario", inventario);
        model.addAttribute("costoTotalInventario", costoTotalInventario);
        return "inventario"; 
    }
}
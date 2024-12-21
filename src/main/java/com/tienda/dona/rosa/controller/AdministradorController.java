package com.tienda.dona.rosa.controller;

import java.util.List;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import com.tienda.dona.rosa.model.Producto;
import com.tienda.dona.rosa.service.ProductoService;



@Controller
@RequestMapping("/administrador")
public class AdministradorController {
	
	 private final ProductoService productoService;

	    public AdministradorController(ProductoService productoService) {
	        this.productoService = productoService;
	    }
	
	@GetMapping("")
	public String home(Model model) {
		
		List<Producto> productos=productoService.findAll();
	 model.addAttribute("productos", productos);
		
		return "administrador/home";
	}
	
	@GetMapping("/producto-cercano-acabarse")
    public String obtenerProductoCercanoAcabarse(Model model) {
        Producto producto = productoService.obtenerProductoCercaDeAcabarse();
        model.addAttribute("productoCercano", producto);
        return "productos/producto-cercano-acabarse";
    }

    @GetMapping("/costototal_inventario")
    public String costoTotalInventario(Model model) {
        Double costoTotal = productoService.calcularCostoTotalInventario();
        model.addAttribute("costoTotal", costoTotal);
        return "administrador/costo-total-inventario";
    }
}



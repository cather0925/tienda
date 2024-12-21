package com.tienda.dona.rosa.controller;



import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tienda.dona.rosa.model.Producto;
import com.tienda.dona.rosa.service.ProductoService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	private final ProductoService productoService;

    public HomeController(ProductoService productoService) {
        this.productoService = productoService;
    }
	
	@SuppressWarnings("unused")
	private final Logger log= LoggerFactory.getLogger(AdministradorController.class);

	
	
	@GetMapping("")
	public String home(Model model) {
		
		
	 model.addAttribute("productos", productoService.findAll());
		
		return "administrador/home";
	}
	
	@GetMapping("/productohome/{id}")
	public String productoHome(@PathVariable Integer id, Model model) {
	    Optional<Producto> productoOptional = productoService.get(id);
	    if (productoOptional.isPresent()) {
	        Producto producto = productoOptional.get();
	        model.addAttribute("producto", producto);
	    } else {
	        
	        throw new RuntimeException("Producto no encontrado");
	    }
	    return "administrador/productohome";
	}
	
	
		
}


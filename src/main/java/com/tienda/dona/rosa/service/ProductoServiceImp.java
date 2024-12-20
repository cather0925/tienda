package com.tienda.dona.rosa.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;



import org.springframework.stereotype.Service;

import com.tienda.dona.rosa.model.Producto;
import com.tienda.dona.rosa.repository.ProductoRepository;


@Service
public class ProductoServiceImp implements ProductoService {

   
    private final ProductoRepository productoRepository;
    
    public ProductoServiceImp(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }
    
    public Producto obtenerProductoCercaDeAcabarse() {
        return productoRepository.findAll().stream()
                .filter(producto -> producto.getCantidad() <= producto.getCantidadInicial() * 0.1)
                .min(Comparator.comparingInt(Producto::getCantidad))
                .orElse(null);
    }
    
    public List<Producto> obtenerInventario() {
        return productoRepository.findAll();
 }
    
    public Double calcularCostoTotalInventario() {
        return productoRepository.findAll().stream()
                .mapToDouble(producto -> producto.getPrecio() * producto.getCantidad())
                .sum();
    }
    

    public void guardarCostoTotal(double costoTotal) {
        
    }

    @Override
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Optional<Producto> get(Integer id) {
        return productoRepository.findById(id);
    }

    @Override
    public void update(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public void delete(Integer id) {
        productoRepository.deleteById(id);
    }

    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

	@Override
	public Producto productoCercaDeAcabarse() {
		return null;
	}


	@Override
	public List<Producto> obtenerProductosCalculados() {
				return null;
	}

	@Override
	public List<Producto> productosCercaDeAcabarse() {
	
		return null;
	}

	@Override
	public void actualizarProducto(Long id, int cantidadActual) {
		
		
	}
	
	 
}

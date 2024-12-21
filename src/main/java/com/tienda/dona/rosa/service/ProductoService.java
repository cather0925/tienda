package com.tienda.dona.rosa.service;

import java.util.List;
import java.util.Optional;

import com.tienda.dona.rosa.model.Producto;


public interface ProductoService {
    Producto save(Producto producto);
    Optional<Producto> get(Integer id);
    void update(Producto producto);
    void delete(Integer id);
    List<Producto> findAll();
    Producto productoCercaDeAcabarse();
    Double calcularCostoTotalInventario();
    Producto obtenerProductoCercaDeAcabarse();
    public List<Producto> productosCercaDeAcabarse();
	void guardarCostoTotal(double costoTotal);
	List<Producto> obtenerProductosCalculados();
	List<Producto> obtenerInventario();
	void actualizarProducto(Long id, int cantidadActual);
	
	
 
	
}
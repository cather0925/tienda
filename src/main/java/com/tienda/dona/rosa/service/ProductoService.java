package com.tienda.dona.rosa.service;

import java.util.Optional;

import com.tienda.dona.rosa.model.Producto;

public interface ProductoService {
	public Producto save(Producto producto);
	public Optional<Producto> get(Integer id);
	public void update(Producto producto);
	public void delete(Integer id);
	
}

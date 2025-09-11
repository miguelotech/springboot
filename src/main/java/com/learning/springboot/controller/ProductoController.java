package com.learning.springboot.controller;

import com.learning.springboot.entity.Producto;
import com.learning.springboot.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;


    @GetMapping
    public List<Producto> getProductos() {
        return productoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Producto getProductoById(@PathVariable("id") Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Producto create(@RequestBody Producto producto) {
        return productoRepository.save(producto);
    }

    @PutMapping("/{id}")
    public Producto update(@PathVariable("id") Long id ,@RequestBody Producto producto) {
        Producto productoToUpdate = productoRepository.findById(id).orElse(null);
        if (productoToUpdate != null) {
            productoToUpdate.setNombre(producto.getNombre());
            productoToUpdate.setPrecioUnitario(producto.getPrecioUnitario());
            productoToUpdate.setStock(producto.getStock());
            return productoRepository.save(productoToUpdate);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        productoRepository.deleteById(id);
    }
}

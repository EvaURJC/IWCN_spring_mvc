package com.iwcn.master.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iwcn.products.Producto;

@Controller
public class AppController {

	// Creacion de un producto
	@Autowired
	private Producto pi;
	
	
	// Creacion de una lista que contiene todos los datos de los productos
	List<Producto> prods = new ArrayList<>();
	
	 // Vista Principal
 	@RequestMapping("/")
 	public ModelAndView Principal() {
 		return new ModelAndView("principal_template");
     }
 	
 	// Vista que contiene Lista de Productos (list_template)
     @RequestMapping("/list")
     public ModelAndView listaProducto() {
    	 return new ModelAndView("list_template").addObject("prods", prods);
     }
     
    // Vista que contiene el Formulario (newProduct_template)
     @RequestMapping("/new")
     public ModelAndView nuevoProducto(Model model) {
     	model.addAttribute(pi);
     	return new ModelAndView("newProduct_template");
     }
    
    // Vista que muestra que el producto se ha añadido 
    @RequestMapping("/fin")
    public ModelAndView nuevoProducto2(Producto pi) {
    	prods.add(pi);
    	return new ModelAndView("fin_template").addObject("producto", pi.getNombre() + " ");
    }
    
    
    // Vista del producto en si
    @RequestMapping("/product/{optio}")
    public ModelAndView mostrarProducto(@PathVariable String optio) {
    	int index = Integer.parseInt(optio);
    	Producto p = prods.get(index);
    	return new ModelAndView("product_template").addObject("nombre", p.getNombre()).addObject("codigo", 
    			p.getCodigo()).addObject("descripcion", p.getDescripcion()).addObject("precio", p.getPrecio());
    }
    
 // Vista que contiene Lista de Productos (list_template)
    @RequestMapping("/borrar/{optio}")
    public ModelAndView borrarProducto(@PathVariable String optio) {
    	int index = Integer.parseInt(optio);
    	Producto p = prods.get(index);
    	prods.remove(index);
   	 return new ModelAndView("borrar_template").addObject("producto", p.getNombre());
    }
}
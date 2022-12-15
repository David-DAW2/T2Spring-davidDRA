package com.example.nttdataT2SpringdavidDRA.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nttdataT2SpringdavidDRA.persistence.Order;
import com.example.nttdataT2SpringdavidDRA.persistence.Product;
import com.example.nttdataT2SpringdavidDRA.repositores.OrderRepositoryI;

@Service
public interface ManagementsOrdersServicesI {
	

	/**
	 * Método añadir productos a un pedido
	 */
	public void addProductToAnOrder(Product product, Order pedido);
	
	/**
	 * Método calcular suma general de los precios de los productos
	 */
	public double breakdownOrder(Order pedido);

	/**
	 * Método crear pedido y volcar en la base de datos
	 */
	public void createOrder(Order pedido);
	
	
}

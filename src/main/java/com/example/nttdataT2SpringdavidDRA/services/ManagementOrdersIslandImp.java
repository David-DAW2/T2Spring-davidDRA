package com.example.nttdataT2SpringdavidDRA.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nttdataT2SpringdavidDRA.persistence.Order;
import com.example.nttdataT2SpringdavidDRA.persistence.Product;
import com.example.nttdataT2SpringdavidDRA.repositores.OrderRepositoryI;
import com.example.nttdataT2SpringdavidDRA.repositores.ProductRepositoryI;

@Service("islandService")
public class ManagementOrdersIslandImp implements ManagementsOrdersServicesI {

	/**
	 * Inyección de repositorios
	 */
	@Autowired
	OrderRepositoryI repoOrder;
	@Autowired
	ProductRepositoryI repoProduct;

	
	@Override
	public double breakdownOrder(Order pedido) {
		//Crear variable para guardar la cantidad total
		double totalAmount = 0;
		
		//Iterar sobre los productos
		for (Product product : pedido.getProducts()) {
			
		//calcular precio venta publico
			product.setPricePVP(product.getPriceNoTax() + (product.getPriceNoTax() * 4 / 100));
			
			//Añadir precio al total
			totalAmount += product.getPricePVP();

		}
		return totalAmount;
	}

	
	@Override
	public void createOrder(Order pedido) {

		//Declarar a verdadero que el envio es a fuera de la peninsula
		pedido.setIslands(true);
		
		//Volcar pedido en la BBDD
		repoOrder.save(pedido);

	}


	@Override
	public void addProductToAnOrder(Product product, Order pedido) {

		//Obtener lista de productos y añadir productos
		pedido.getProducts().add(product);
		
		//Volcar producto en la BBDD
		repoProduct.save(product);

	}

}

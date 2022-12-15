package com.example.nttdataT2SpringdavidDRA;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.nttdataT2SpringdavidDRA.persistence.Order;
import com.example.nttdataT2SpringdavidDRA.persistence.Product;
import com.example.nttdataT2SpringdavidDRA.services.ManagementsOrdersServicesI;

@SpringBootApplication
public class NttdataT2SpringDavidDraApplication implements CommandLineRunner{

	private static final Logger LOG =LoggerFactory.getLogger(NttdataT2SpringDavidDraApplication.class);


	/**
	 * Inyección de servicios usados para pedidos
	 */
	@Autowired
	@Qualifier("islandService")
	ManagementsOrdersServicesI servicioIslas;
	
	@Autowired
	@Qualifier("peninsulaService")
	ManagementsOrdersServicesI servicioPeninsula;
	public static void main(String[] args) {
		SpringApplication.run(NttdataT2SpringDavidDraApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		/**
		 * Instanciar Lista de productos para pedidos
		 */
		List<Product> nuevaLista1=new ArrayList<Product>();
		List<Product> nuevaLista2=new ArrayList<Product>();
		List<Product> nuevaLista3=new ArrayList<Product>();


		/**
		 * Instanciar pedidos
		 */
		Order pedido1=new Order("JuanCarlos","Sevilla",null,nuevaLista1);
		Order pedido2=new Order("Nandi","Baleares",null,nuevaLista2);
		Order pedido3=new Order("David","Canarias",null,nuevaLista3);

		/**
		 * Crear pedidos y volcar en BBDD
		 */

		servicioPeninsula.createOrder(pedido1);
		servicioPeninsula.createOrder(pedido2);
		servicioIslas.createOrder(pedido3);
		

		/**
		 * Instanciar productos
		 */
		
		Product aguacates=new Product("melocoton",5.20);
		Product sandia=new Product("sandia",6.20);
		Product filipinos=new Product("filipinos",1.10);
		Product croquetas=new Product("croquetas",2.40);
		Product magdalenas=new Product("magdalenas",1.30);
		Product jamonYork=new Product("Jamon York",1.80);
		Product jamonSerrano=new Product("Jamon York",10.80);


	
		/**
		 * Añadir productos a la lista de un pedido y volcar producto en la BBDD
		 */
		servicioPeninsula.addProductToAnOrder(sandia,pedido1);
		servicioPeninsula.addProductToAnOrder(aguacates,pedido1);

		
		servicioIslas.addProductToAnOrder(croquetas,pedido2);
		servicioIslas.addProductToAnOrder(filipinos,pedido2);
		
		servicioIslas.addProductToAnOrder(magdalenas,pedido3);
		servicioIslas.addProductToAnOrder(jamonYork,pedido3);
		servicioIslas.addProductToAnOrder(jamonSerrano,pedido3);


		/**
		 * Mostrar por consola/log el total del contenido de un pedido, hacemos uso de un servicio determinado que calcula el porcentaje dependiendo de la zona de venta
		 */
		System.out.println("El importe del pedido 1 es: "+servicioPeninsula.breakdownOrder(pedido1)+" €");
		System.out.println("El importe del pedido 2 es: "+servicioIslas.breakdownOrder(pedido2)+" €");
		System.out.println("El importe del pedido 3 es: "+servicioIslas.breakdownOrder(pedido3)+" €");



		
	}

}

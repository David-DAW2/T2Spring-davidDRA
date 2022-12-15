package com.example.nttdataT2SpringdavidDRA.persistence;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "T_DRA_PRODUCT")
public class Product implements Serializable  {

	private static final long serialVersionUID = 1L;

	/**
	 * ID DEL PRODUCTO
	 */
	private Integer id;

	/**
	 *NOMBRE DEL PRODUCTO
	 */
	private String name;
	
	/**
	 * PRECIO VENTA AL PUBLICO DEL PRODUCTO
	 */
	private double pricePVP;
	
	/**
	 * PRECIO SIN IMPUESTOS DEL PRODUCTO
	 */
	private double priceNoTax;
	
	/**
	 * CLAVE FORÁNEA DEL PRODUCTO
	 */
	private Order pedido_fk;

	
	/**
	 * 
     * CONSTRUCTOR DE PRODUCTO
	 */
	public Product(String name, double priceNoTax) {
		super();
		this.name = name;
		this.priceNoTax = priceNoTax;
	}


	/**
	 * RECUPERAR FK DEL PEDIDO
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "C_PEDIDOFK")
	public Order getPedido_fk() {
		return pedido_fk;
	}

	/**
	 * RECUPERAR FK DEL PEDIDO
	 */
	public void setPedido_fk(Order pedido_fk) {
		this.pedido_fk = pedido_fk;
	}

	/**
	 * RECUPERAR ID DEL PRODUCTO
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "C_ID")
	public Integer getId() {
		return id;
	}

	/**
	 * DECLARAR ID DEL PRODUCTO
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * RECUPERAR NOMBRE DEL PRODUCTO
	 */
	@Column(name = "C_NAME")
	public String getName() {
		return name;
	}
	
	/**
	 * DECLARAR NOMBRE DEL PRODUCTO
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * RECUPERAR PRECIO VENTA AL PUBLICO DEL PRODUCTO
	 */
	@Column(name = "C_PRICEPVP")
	public double getPricePVP() {
		return pricePVP;
	}

	/**
	 * DECLARAR PRECIO VENTA AL PUBLICO DEL PRODUCTO
	 */
	public void setPricePVP(double pricePVP) {
		this.pricePVP = pricePVP;
	}

	/**
	 * RECUPERAR PRECIO VENTA SIN IMPUESTOS DEL PRODUCTO
	 */
	@Column(name = "C_PRICENOTAX")
	public double getPriceNoTax() {
		return priceNoTax;
	}


	/**
	 * DECLARAR PRECIO VENTA SIN IMPUESTOS DEL PRODUCTO
	 */
	public void setPriceNoTax(double priceNoTax) {
		this.priceNoTax = priceNoTax;
	}
}

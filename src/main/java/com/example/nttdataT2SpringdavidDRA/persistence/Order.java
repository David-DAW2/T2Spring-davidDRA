package com.example.nttdataT2SpringdavidDRA.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "T_DRA_ORDER")
public class Order implements Serializable {

	/**
	 * ID DEL PEDIDO
	 */
	private Integer id;
	
	/**
	 * CLIENTE DEL PEDIDO
	 */

	private String customer;

	/**
	 * DIRECCIÓN DE ENTREGA DEL PEDIDO
	 */
	private String adress;
	
	/**
	 * ENVIO A ISLAS
	 */
	private Boolean islands;

	/**
	 * LISTA DE PRODUCTOS PERTENECIENTES AL PEDIDO
	 */
	private List<Product> products;

	/**
	 * CONSTRUCTOR CLASE PEDIDO
	 */
	public Order(String customer, String adress, Boolean islands, List<Product> products) {
		super();
		this.customer = customer;
		this.adress = adress;
		this.islands = islands;
		this.products = products;
	}

	/**
	 * RECUPERAR ID DEL PEDIDO
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "C_ID")
	public Integer getId() {
		return id;
	}

	/**
	 * DECLARAR ID DEL PEDIDO
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * RECUPERAR CLIENTE DEL PEDIDO
	 */
	@Column(name = "C_CUSTOMER")
	public String getCustomer() {
		return customer;
	}

	/**
	 * DECLARAR CLIENTE DEL PEDIDO
	 */
	public void setCustomer(String customer) {
		this.customer = customer;
	}


	/**
	 * RECUPERAR DIRECCIÓN DEL PEDIDO
	 */
	@Column(name = "C_ADRESS")
	public String getAdress() {
		return adress;
	}

	/**
	 * DECLARAR DIRECCIÓN DEL PEDIDO
	 */
	public void setAdress(String adress) {
		this.adress = adress;
	}

	/**
	 * RECUPERAR BOLEAN ENVIO A ISLAS
	 */
	@Column(name = "C_ISLAND")
	public Boolean getIslands() {
		return islands;
	}

	/**
	 * DECLARAR BOLEAN ENVIO A ISLAS
	 */
	public void setIslands(Boolean islands) {
		this.islands = islands;
	}

	/**
	 * RECUPERAR LISTA DE PRODUCTOS DEL PEDIDO
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido_fk")
	public List<Product> getProducts() {
		return products;
	}

	/**
	 * DECLARAR LISTA DE PRODUCTOS DEL PEDIDO
	 */
	public void setProducts(List<Product> products) {
		this.products = products;
	}

}

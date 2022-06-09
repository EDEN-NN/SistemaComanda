package fatec.edu.walison.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	@Column(nullable = false, name = "name")
	private String name;
	@Column(nullable = false, name = "price")
	private Double price;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "orders_id")
	private Orders orders;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "store_id")
	private Store store;

	@Column(nullable = false, name = "quantity")
	private Integer quantity;

	public Product(Long productId, String name, Double price, Integer quantity) {
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public Product() {}

	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Store getStore() {return store;}

	public void setStore(Store store) {
		this.store = store;
	}

	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
	
}

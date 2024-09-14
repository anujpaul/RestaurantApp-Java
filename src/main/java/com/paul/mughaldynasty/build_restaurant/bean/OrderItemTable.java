package com.paul.mughaldynasty.build_restaurant.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "orderitemtable")
public class OrderItemTable {


	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderitemtable_seq")
	@SequenceGenerator(name = "orderitemtable_seq", sequenceName = "orderitemtable_seq", allocationSize = 1)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "ordernumber")
	@JsonBackReference
	private OrderTable orderTable;

	@ManyToOne
	@JoinColumn(name = "itemid")
	private ItemTable itemTable;

	@Column(name = "qty")
	private int quantity;

	public OrderItemTable() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {

		this.id = id;
	}

	public OrderTable getOrderTable() {
		return orderTable;
	}

	public void setOrderTable(OrderTable orderTable) {
		this.orderTable = orderTable;
	}

	public ItemTable getItemTable() {
		return itemTable;
	}

	public void setItemTable(ItemTable itemTable) {
		this.itemTable = itemTable;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderItemTable [id=" + id + ", orderTable=" + orderTable + ", itemTable=" + itemTable + ", quantity="
				+ quantity + "]";
	}



}

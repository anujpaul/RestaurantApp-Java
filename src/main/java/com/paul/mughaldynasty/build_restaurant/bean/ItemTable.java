package com.paul.mughaldynasty.build_restaurant.bean;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "itemtable")
public class ItemTable {

	@Id
	@Column(name = "itemid")
	private Long itemId;
//	@Id
//	private Long id;
	private String itemname;
	private Double amount;

	@OneToMany(mappedBy = "itemTable")
	private List<OrderItemTable> orderItemTable;

	public ItemTable() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ItemTable(Long itemId, String itemname, Double amount) {
		super();
		this.itemId = itemId;
		this.itemname = itemname;
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "MenuItem [id=" + itemId + ", itemName=" + itemname + ", amount=" + amount + "]";
	}

	public Long getId() {
		return itemId;
	}

	public String getItemName() {
		return itemname;
	}

	public Double getAmount() {
		return amount;
	}


	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public void setId(Long id) {
		this.itemId = id;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}



}

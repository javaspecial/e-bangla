package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SHOP_TABLE_TYPE")
public class ShopTableType {
	public static final String ID = "id";
	public final static String DESCRIPTION = "description";
	public final static String NAME = "name";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = ID, unique = true, nullable = false)
	private Integer shopTableTypeId;

	@Column(name = DESCRIPTION)
	private String description;

	@Column(name = NAME)
	private String name;

	public ShopTableType() {
	}

	public Integer getShopTableTypeId() {
		return shopTableTypeId;
	}

	public void setShopTableTypeId(Integer shopTableTypeId) {
		this.shopTableTypeId = shopTableTypeId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
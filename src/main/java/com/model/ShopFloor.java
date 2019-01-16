package com.model;

import java.sql.Blob;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SHOP_FLOOR")
public class ShopFloor {
	private byte[] imageData;

	public static final String ID = "shopFloorId";
	public final static String NAME = "name";
	public final static String OCCUPIED = "occupied";
	public final static String IMAGE = "image";
	public final static String SHOP_TABLE = "shopTable";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = ID, unique = true, nullable = false)
	private Integer shopFloorId;

	@Column(name = NAME)
	private String name;

	@Column(name = OCCUPIED)
	private boolean occupied;

	@Column(name = IMAGE)
	private Blob image;

	@Column(name = ShopTable.ID)
	private Integer shopTableId;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = SHOP_TABLE)
	private Set<ShopTable> shopTable;

	public ShopFloor() {
	}

	public Integer getShopFloorId() {
		return shopFloorId;
	}

	public void setShopFloorId(Integer shopFloorId) {
		this.shopFloorId = shopFloorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	public Set<ShopTable> getShopTable() {
		return shopTable;
	}

	public void setShopTable(Set<ShopTable> shopTable) {
		this.shopTable = shopTable;
	}

	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}

	public byte[] getImageData() {
		return imageData;
	}

	public Integer getShopTableId() {
		return shopTableId;
	}

	public void setShopTableId(Integer shopTableId) {
		this.shopTableId = shopTableId;
	}

}

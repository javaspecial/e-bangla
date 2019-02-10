package com.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "SHOP_TABLE")
public class ShopTable {
	private boolean isTemporary;
	private Date ticketCreateTime;

	public static final String ID = "shopTableId";
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String CAPACITY = "capacity";
	public static final String X = "x";
	public static final String Y = "y";
	public static final String SHOP_FLOOR = "shopFloor";
	public static final String SHOP_TABLE_TYPE = "shopTableType";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = ID, unique = true, nullable = false)
	private Integer shopTableId;

	@Column(name = ShopFloor.ID)
	private Integer shopFloorId;

	@Column(name = NAME)
	private String name;

	@Column(name = DESCRIPTION)
	private String description;

	@Column(name = CAPACITY)
	private Integer capacity;

	@Column(name = X)
	private Integer x;

	@Column(name = Y)
	private Integer y;

	@OneToMany(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name = SHOP_TABLE_TYPE)
	private List<ShopTableType> shopTableType;

	@ManyToOne(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name = SHOP_FLOOR, referencedColumnName = ShopFloor.ID)
	private ShopFloor shopFloor;

	@OneToOne(cascade = CascadeType.ALL)
	private ShopTableStatus shopTableStatus;

	public ShopTable() {
	}

	public ShopTable(Integer id) {
	}

	public ShopTable(Integer x, Integer y) {
		setX(x);
		setY(y);
	}

	public ShopTable(ShopFloor floor, Integer x, Integer y, Integer id) {
		setCapacity(4);
		setId(id);
		setShopFloor(floor);
		setX(x);
		setY(y);
	}

	public Integer getId() {
		return shopTableId;
	}

	public void setId(Integer id) {
		this.shopTableId = id;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	public List<ShopTableType> getShopTableType() {
		return shopTableType;
	}

	public void setShopTableType(List<ShopTableType> shopTableType) {
		this.shopTableType = shopTableType;
	}

	public ShopFloor getShopFloor() {
		return shopFloor;
	}

	public void setShopFloor(ShopFloor shopFloor) {
		this.shopFloor = shopFloor;
	}

	public ShopTableStatus getShopTableStatus() {
		return shopTableStatus;
	}

	public void setShopTableStatus(ShopTableStatus shopTableStatus) {
		this.shopTableStatus = shopTableStatus;
	}

	public Integer getTableNumber() {
		return getId();
	}

	@Override
	public String toString() {
		return String.valueOf(getTableNumber());
	}

	public boolean isTemporary() {
		return isTemporary;
	}

	public void setTemporary(boolean isTemporary) {
		this.isTemporary = isTemporary;
	}
}
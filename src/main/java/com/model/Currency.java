package com.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CURRENCY")
public class Currency implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String CURRENCY_ID = "currency_id";
	public static final String CURRENCY_CODE = "currency_code";
	public static final String CURRENCY_NAME = "currency_name";
	public static final String CURRENCY_SYMBOL = "currency_symbol";
	public static final String CURRENCY_EXCHANGE_RATE = "currency_exchange_rate";
	public static final String CURRENCY_DECIMAL_PLACES = "currency_decimal_places";
	public static final String CURRENCY_TOLERANCE = "currency_tolerance";
	public static final String CURRENCY_BUY_PRICE = "currency_buy_price";
	public static final String CURRENCY_SALES_PRICE = "currency_sales_price";
	public static final String CURRENCY_MAIN = "currency_main";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = CURRENCY_ID, nullable = false, unique = true)
	private Integer currencyId;

	@Column(name = CURRENCY_CODE)
	private String code;

	@Column(name = CURRENCY_NAME)
	private String name;

	@Column(name = CURRENCY_SYMBOL)
	private String symbol;

	@Column(name = CURRENCY_EXCHANGE_RATE)
	private double exchangeRate;

	@Column(name = CURRENCY_DECIMAL_PLACES)
	private Integer decimalPlaces;

	@Column(name = CURRENCY_TOLERANCE)
	private double tolerance;

	@Column(name = CURRENCY_BUY_PRICE)
	private double buyPrice;

	@Column(name = CURRENCY_SALES_PRICE)
	private double salesPrice;

	@Column(name = CURRENCY_MAIN)
	private boolean main;

	public Currency() {
	}

	/**
	 * @return the currencyId
	 */
	public Integer getCurrencyId() {
		return currencyId;
	}

	/**
	 * @param currencyId the currencyId to set
	 */
	public void setCurrencyId(Integer currencyId) {
		this.currencyId = currencyId;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * @param symbol the symbol to set
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	/**
	 * @return the exchangeRate
	 */
	public double getExchangeRate() {
		return exchangeRate;
	}

	/**
	 * @param exchangeRate the exchangeRate to set
	 */
	public void setExchangeRate(double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	/**
	 * @return the decimalPlaces
	 */
	public Integer getDecimalPlaces() {
		return decimalPlaces;
	}

	/**
	 * @param decimalPlaces the decimalPlaces to set
	 */
	public void setDecimalPlaces(Integer decimalPlaces) {
		this.decimalPlaces = decimalPlaces;
	}

	/**
	 * @return the tolerance
	 */
	public double getTolerance() {
		return tolerance;
	}

	/**
	 * @param tolerance the tolerance to set
	 */
	public void setTolerance(double tolerance) {
		this.tolerance = tolerance;
	}

	/**
	 * @return the buyPrice
	 */
	public double getBuyPrice() {
		return buyPrice;
	}

	/**
	 * @param buyPrice the buyPrice to set
	 */
	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}

	/**
	 * @return the salesPrice
	 */
	public double getSalesPrice() {
		return salesPrice;
	}

	/**
	 * @param salesPrice the salesPrice to set
	 */
	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}

	/**
	 * @return the main
	 */
	public boolean isMain() {
		return main;
	}

	/**
	 * @param main the main to set
	 */
	public void setMain(boolean main) {
		this.main = main;
	}

}
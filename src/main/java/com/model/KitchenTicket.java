package com.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.format.Printer;

@Entity
@Table(name = "KITCHEN_TICKET")
public class KitchenTicket implements Comparable<Object>, Serializable {
	private static final long serialVersionUID = 1L;
	private int hashCode = Integer.MIN_VALUE;

	public final static String KITCHEN_TICKET_ID = "kitchen_ticket_id";
	public final static String KITCHEN_TICKET_CREATE_DATE = "kitchen_ticket_create_date";
	public final static String KITCHEN_TICKET_CLOSE_DATE = "kitchen_ticket_close_date";
	public final static String KITCHEN_TICKET_VOIDED = "kitchen_ticket_voided";
	public final static String KITCHEN_TICKET_SEQUENCE_NUMBER = "kitchen_ticket_sequence_number";
	public final static String KITCHEN_TICKET_STATUS = "kitchen_ticket_status";
	public final static String KITCHEN_TICKET_SERVER_NAME = "kitchen_ticket_server_name";
	public final static String KITCHEN_TICKET_TYPE = "kitchen_ticket_type";
	public final static String KITCHEN_TICKET_PRINTER_GROUP = "printerGroup";
	public final static String KITCHEN_TICKET_PRINTER = "printer";
	public static final String PROP_TABLE_NUMBERS = "tableNumbers";
	public static final String PROP_CUSTOMER_NAME = "customerName";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = KITCHEN_TICKET_ID, unique = true, nullable = false)
	private Integer kitchenTicketId;

	@Column(name = KITCHEN_TICKET_CREATE_DATE)
	private Date kitchenTicketCreateDate;

	@Column(name = KITCHEN_TICKET_CLOSE_DATE)
	private Date kitchenTicketCloseDate;

	@Column(name = KITCHEN_TICKET_VOIDED)
	private boolean isKitchenTicketVoided;

	@Column(name = KITCHEN_TICKET_SEQUENCE_NUMBER)
	private Integer kitchenTicketSequenceNumber;

	@Column(name = KITCHEN_TICKET_STATUS)
	private String kitchenTicketStatus;

	@Column(name = KITCHEN_TICKET_SERVER_NAME)
	private String kitchenTicketServerName;

	@Column(name = PROP_CUSTOMER_NAME)
	private String customerName;

	@Column(name = KITCHEN_TICKET_TYPE)
	private String kitchenTicketType;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = KITCHEN_TICKET_PRINTER_GROUP, referencedColumnName = PrinterGroup.PRINTER_GROUP_ID)
	private PrinterGroup printerGroup;

	@OneToMany(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name = KITCHEN_TICKET_ID)
	private List<KitchenTicketItem> kitchenTicketItem;

	@ElementCollection
	@CollectionTable(name = PROP_TABLE_NUMBERS, joinColumns = @JoinColumn(name = KITCHEN_TICKET_ID))
	@Column(name = PROP_TABLE_NUMBERS)
	private List<Integer> tableNumbers;

	@Transient
	private Printer printer;

	public KitchenTicket() {

	}

	public Integer getKitchenTicketId() {
		return kitchenTicketId;
	}

	public void setKitchenTicketId(Integer kitchenTicketId) {
		this.kitchenTicketId = kitchenTicketId;
	}

	public Date getKitchenTicketCreateDate() {
		return kitchenTicketCreateDate;
	}

	public void setKitchenTicketCreateDate(Date kitchenTicketCreateDate) {
		this.kitchenTicketCreateDate = kitchenTicketCreateDate;
	}

	public Date getKitchenTicketCloseDate() {
		return kitchenTicketCloseDate;
	}

	public void setKitchenTicketCloseDate(Date kitchenTicketCloseDate) {
		this.kitchenTicketCloseDate = kitchenTicketCloseDate;
	}

	public boolean isKitchenTicketVoided() {
		return isKitchenTicketVoided;
	}

	public void setKitchenTicketVoided(boolean isKitchenTicketVoided) {
		this.isKitchenTicketVoided = isKitchenTicketVoided;
	}

	public Integer getKitchenTicketSequenceNumber() {
		return kitchenTicketSequenceNumber;
	}

	public void setKitchenTicketSequenceNumber(Integer kitchenTicketSequenceNumber) {
		this.kitchenTicketSequenceNumber = kitchenTicketSequenceNumber;
	}

	public String getKitchenTicketStatus() {
		return kitchenTicketStatus;
	}

	public void setKitchenTicketStatus(String kitchenTicketStatus) {
		this.kitchenTicketStatus = kitchenTicketStatus;
	}

	public String getKitchenTicketServerName() {
		return kitchenTicketServerName;
	}

	public void setKitchenTicketServerName(String kitchenTicketServerName) {
		this.kitchenTicketServerName = kitchenTicketServerName;
	}

	public String getKitchenTicketType() {
		return kitchenTicketType;
	}

	public void setKitchenTicketType(String kitchenTicketType) {
		this.kitchenTicketType = kitchenTicketType;
	}

	public PrinterGroup getPrinterGroup() {
		return printerGroup;
	}

	public void setPrinterGroup(PrinterGroup printerGroup) {
		this.printerGroup = printerGroup;
	}

	public List<KitchenTicketItem> getKitchenTicketItem() {
		return kitchenTicketItem;
	}

	public void setKitchenTicketItem(List<KitchenTicketItem> kitchenTicketItem) {
		this.kitchenTicketItem = kitchenTicketItem;
	}

	public List<Integer> getTableNumbers() {
		return tableNumbers;
	}

	public void setTableNumbers(List<Integer> tableNumbers) {
		this.tableNumbers = tableNumbers;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setPrinter(Printer printer) {
		this.printer = printer;
	}

	public Printer getPrinter() {
		return this.printer;
	}

	@Override
	public int compareTo(Object o) {
		return 0;
	}
}
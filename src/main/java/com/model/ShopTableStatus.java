package com.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

import com.enum_.TableStatus;

@Entity
@Table(name = "SHOP_TABLE_STATUS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "shop_table_status_id", discriminatorType = DiscriminatorType.INTEGER, length = 30)
public class ShopTableStatus {
	public static final String ID = "id";
	public static final String TABLE_STATUS_NUM = "tableStatusNum";
	public static final String TICKET_NUMBERS = "ticketNumbers";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = ID, unique = true, nullable = false)
	private Integer id;

	@Column(name = TABLE_STATUS_NUM)
	private Integer tableStatusNum;

	@ElementCollection
	@MapKeyColumn(name = ID)
	@Column(name = ShopTableTicket.PROP_TICKET_ID)
	@CollectionTable(name = TICKET_NUMBERS)
	private List<ShopTableTicket> ticketNumbers;

	public ShopTableStatus() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTableStatusNum() {
		return tableStatusNum;
	}

	public void setTableStatusNum(Integer tableStatusNum) {
		this.tableStatusNum = tableStatusNum;
	}

	public List<ShopTableTicket> getTicketNumbers() {
		return ticketNumbers;
	}

	public void setTicketNumbers(List<ShopTableTicket> ticketNumbers) {
		this.ticketNumbers = ticketNumbers;
	}

	public TableStatus getTableStatus() {
		Integer tableStatus = getTableStatusNum();
		return TableStatus.get(tableStatus);
	}

	public void setTableStatus(TableStatus tableStatus) {
		setTableStatusNum(tableStatus.getValue());
	}

	public Integer getTicketId() {
		List<Integer> ticketNumbers = getListOfTicketNumbers();
		if (ticketNumbers != null && ticketNumbers.size() > 0)
			return ticketNumbers.get(0);
		return null;
	}

	public List<Integer> getListOfTicketNumbers() {
		List<ShopTableTicket> shopTableTickets = getTicketNumbers();
		List<Integer> listOfTicketNumbers = new ArrayList<>();
		if (shopTableTickets != null) {
			for (ShopTableTicket shopTableTicket : shopTableTickets) {
				listOfTicketNumbers.add(shopTableTicket.getTicketId());
			}
		}
		return listOfTicketNumbers;
	}

	public boolean hasMultipleTickets() {
		List<ShopTableTicket> ticketNumbers = getTicketNumbers();
		if (ticketNumbers != null && ticketNumbers.size() > 0)
			return true;
		return false;
	}

	public void setTicketId(Integer ticketId) {
		setTableTicket(ticketId, null, null);
	}

	public void setTableTicket(Integer ticketId, Integer userId, String userFirstName) {
		if (ticketId == null) {
			setTableStatus(TableStatus.Available);
			setTicketNumbers(null);
		} else {
			ShopTableTicket shopTableTicket = null;
			List<ShopTableTicket> shopTableTickets = getTicketNumbers();
			if (shopTableTickets != null && !shopTableTickets.isEmpty()) {
				for (ShopTableTicket shopT : shopTableTickets) {
					if (shopT.getTicketId() == ticketId)
						shopTableTicket = shopT;
				}
			} else {
				shopTableTickets = new ArrayList<ShopTableTicket>();
			}
			if (shopTableTicket == null) {
				shopTableTicket = new ShopTableTicket();
				shopTableTickets.add(shopTableTicket);
			}
			shopTableTicket.setTicketId(ticketId);
			shopTableTicket.setUserId(userId);
			shopTableTicket.setUserName(userFirstName);
			setTicketNumbers(shopTableTickets);
		}
	}

	public void addToTableTickets(List<Ticket> tickets) {
		if (tickets == null)
			return;
		List<Integer> existingTicketIds = new ArrayList<>();
		List<ShopTableTicket> shopTableTickets = getTicketNumbers();
		if (shopTableTickets == null) {
			shopTableTickets = new ArrayList<>();
			setTicketNumbers(shopTableTickets);
		}
		for (ShopTableTicket shopTableTicket : shopTableTickets) {
			Integer ticketId = shopTableTicket.getTicketId();
			if (ticketId != null)
				existingTicketIds.add(ticketId);
		}
		for (Ticket ticket : tickets) {
			if (existingTicketIds.contains(ticket.getTicketId()))
				continue;
			ShopTableTicket shopTableTicket = new ShopTableTicket();
			shopTableTicket.setTicketId(ticket.getTicketId());
			shopTableTicket.setUserId(ticket.getOwner().getUserId());
			shopTableTicket.setUserName(ticket.getOwner().getUserName());
			shopTableTickets.add(shopTableTicket);
		}
	}

	public Integer getUserId() {
		List<ShopTableTicket> shopTableTickets = getTicketNumbers();
		if (shopTableTickets == null || shopTableTickets.isEmpty())
			return null;
		return shopTableTickets.get(0).getUserId();
	}

	public String getUserName() {
		List<ShopTableTicket> shopTableTickets = getTicketNumbers();
		if (shopTableTickets == null || shopTableTickets.isEmpty())
			return "";
		int size = shopTableTickets.size();
		if (size > 1) {
			List<Integer> userIds = new ArrayList<>();
			for (Iterator iterator = shopTableTickets.iterator(); iterator.hasNext();) {
				ShopTableTicket shopTableTicket = (ShopTableTicket) iterator.next();
				if (userIds.contains(shopTableTicket.getUserId()))
					continue;
				userIds.add(shopTableTicket.getUserId());
			}
			if (userIds.size() > 1)
				return "Multi owner";
		}
		return shopTableTickets.get(0).getUserName();
	}

	public String getTicketIdAsString() {
		List<ShopTableTicket> shopTableTickets = getTicketNumbers();
		if (shopTableTickets == null || shopTableTickets.isEmpty())
			return "";
		int size = shopTableTickets.size();
		if (size == 1) {
			return String.valueOf(shopTableTickets.get(0).getTicketId());
		}
		String displayString = "";
		int count = 1;
		for (Iterator iterator = shopTableTickets.iterator(); iterator.hasNext();) {
			ShopTableTicket shopTableTicket = (ShopTableTicket) iterator.next();
			displayString += String.valueOf(shopTableTicket.getTicketId());
			if (count == 4) {
				if (size > 4)
					displayString += "...";
				break;
			}
			count++;
			if (iterator.hasNext()) {
				displayString += ",";
			}
		}
		return displayString;
	}
}
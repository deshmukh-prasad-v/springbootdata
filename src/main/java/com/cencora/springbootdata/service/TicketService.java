package com.cencora.springbootdata.service;

import java.time.LocalDate;
import java.util.List;
import com.cencora.springbootdata.model.Ticket;

public interface TicketService {
	void findAllTickets();
	void findTicketById(Integer id);
	void saveTicket(Ticket ticket);
	void deleteTicketById(Integer id);
	void findTicketsByDate();
	void findFirstFiveTicketsByIssue();
	void findLastFiveTicketsByIssue();
	void getAllTicketsOrderById();
	void readAllTicketsByRaisedonAfter();
	void queryAllTicketsByIssueAndRaisedon();
	void getAllTicketsByRaisedon();
	void updateTicketIssueById();
	void getTicketsByIssue();
}

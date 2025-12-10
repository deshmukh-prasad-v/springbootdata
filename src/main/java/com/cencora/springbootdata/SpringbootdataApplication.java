package com.cencora.springbootdata;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.cencora.springbootdata.service.TicketService;

@SpringBootApplication
public class SpringbootdataApplication implements CommandLineRunner{

	@Autowired
	private TicketService ticketService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootdataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//ticketService.findAllTickets();
		//ticketService.findTicketById(123);
		//ticketService.saveTicket(new Ticket(0,"Gradle access needed",LocalDate.now()));
		//ticketService.deleteTicketById(12);
		//ticketService.findTicketsByDate();
		//ticketService.findFirstFiveTicketsByIssue();
		//ticketService.findLastFiveTicketsByIssue();
		//ticketService.getAllTicketsOrderById();
		//ticketService.readAllTicketsByRaisedonAfter();
		//ticketService.queryAllTicketsByIssueAndRaisedon();
		//ticketService.getAllTicketsByRaisedon();
		//ticketService.updateTicketIssueById();
		//ticketService.findTicketById(9);
		ticketService.getTicketsByIssue();
	}
}
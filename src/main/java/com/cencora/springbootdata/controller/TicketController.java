package com.cencora.springbootdata.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.cencora.springbootdata.model.Ticket;
import com.cencora.springbootdata.repository.TicketRepository;
import com.cencora.springbootdata.service.TicketService;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {
	
	@Autowired
	//private TicketService ticketService;
	private TicketRepository ticketRepository;
	
	@GetMapping("/getAll")
	public Iterable<Ticket> getAllTickets(){
		System.out.println(">>> getAll endpoint HIT <<<");
		return ticketRepository.findAll();
	}
	
	@GetMapping("get/{id}")
	public Ticket getTicketById(@PathVariable("id") int index) {
		return ticketRepository.findById(index).get();
	}
}

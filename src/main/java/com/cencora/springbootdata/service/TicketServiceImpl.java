package com.cencora.springbootdata.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cencora.springbootdata.model.Ticket;
import com.cencora.springbootdata.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {
	@Autowired
	private TicketRepository ticketRepository;
	
	@Override
	public void findAllTickets() {
		//System.out.println(ticketRepository.findAll());
		ticketRepository.findAll().forEach(System.out::println);
	}

	@Override
	public void findTicketById(Integer id) {
		//Optional<Ticket>ticket=ticketRepository.findById(id);
		//ticket.ifPresent(System.out::println);
		//ticket.ifPresentOrElse(System.out::println, ()->{System.out.println("Ticket not found");});
		ticketRepository.findById(id).ifPresentOrElse(System.out::println, ()->{System.out.println("Ticket not found");});
	}

	@Override
	public void saveTicket(Ticket ticket) {
		System.out.println(ticketRepository.save(ticket));
	}

	@Override
	public void deleteTicketById(Integer id) {
		ticketRepository.deleteById(id);
	}

	@Override
	public void findTicketsByDate() {
		System.out.println("Enter date");
		ticketRepository.findAllByRaisedon(LocalDate.parse(new Scanner(System.in).nextLine(),DateTimeFormatter.ofPattern("dd-MM-yyyy"))).forEach(System.out::println);
	}

	@Override
	public void findFirstFiveTicketsByIssue() {
		System.out.println(ticketRepository.findFirst5ByIssue("Gradle access needed"));
	}

	@Override
	public void findLastFiveTicketsByIssue() {
		//System.out.println(ticketRepository.findLast5ByIssue("[(?i)^.*\\wGradle\\w.*$]"));
		ticketRepository.findLast5ByIssue("Gradle access needed").forEach(System.out::println);
	}

	@Override
	public void getAllTicketsOrderById() {
		System.out.println(ticketRepository.getAllByOrderByIdDesc());	
	}

	@Override
	public void readAllTicketsByRaisedonAfter() {
		ticketRepository.readAllByRaisedonAfter(LocalDate.of(2025, 11, 12)).forEach(System.out::println);
	}

	@Override
	public void queryAllTicketsByIssueAndRaisedon() {
		ticketRepository.queryAllByIssueAndRaisedon("Gradle access needed", LocalDate.of(2025, 12, 01)).forEach(System.out::println);
	}

	@Override
	public void getAllTicketsByRaisedon() {
		ticketRepository.getAllByRaisedon(LocalDate.of(2025, 11, 26)).forEach(System.out::println);;
	}

	@Override
	public void updateTicketIssueById() {
		ticketRepository.updateTicketIssueBasedOnId(9, "Azure and AWS access required");
	}

	@Override
	public void getTicketsByIssue() {
		ticketRepository.getByIssue("New Issue").forEach(System.out::println);
	}
}
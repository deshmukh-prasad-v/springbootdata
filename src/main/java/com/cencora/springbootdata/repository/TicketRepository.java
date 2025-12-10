package com.cencora.springbootdata.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cencora.springbootdata.model.Ticket;

import jakarta.transaction.Transactional;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Integer>{
	List<Ticket>findAllByRaisedon(LocalDate raisedon);
	List<Ticket>findFirst5ByIssue(String issue);
	List<Ticket>findLast5ByIssue(String issue);
	List<Ticket>getAllByOrderByIdDesc();
	List<Ticket>readAllByRaisedonAfter(LocalDate raisedon);
	List<Ticket>queryAllByIssueAndRaisedon(String issue, LocalDate raisedon);
	@Query("select ticket from Ticket ticket where ticket.raisedon=:date")
	List<Ticket>getAllByRaisedon(@Param("date")LocalDate raisedon);
	@Query("update Ticket ticket set ticket.issue=:new_issue where ticket.id=:id")
	@Modifying
	@Transactional
	public void updateTicketIssueBasedOnId(@Param("id")int id, @Param("new_issue")String issue);
	public Iterable<Ticket> getByIssue(@Param("issue") String issue);
}
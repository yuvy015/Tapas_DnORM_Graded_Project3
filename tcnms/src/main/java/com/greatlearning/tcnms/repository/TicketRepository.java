package com.greatlearning.tcnms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.tcnms.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
	
	java.util.List<Ticket> findByTicketTitleContainsAndTshortdesContainsAllIgnoreCase(String ticketTitle, String tshortdes);  

}

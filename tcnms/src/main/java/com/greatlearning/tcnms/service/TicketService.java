package com.greatlearning.tcnms.service;

import java.util.List;

import com.greatlearning.tcnms.entity.Ticket;

public interface TicketService {

	  public List<Ticket> findAll();
	  
	  public void save(Ticket ticket);
	  
	  public Ticket findById(int id);
	  
	  public void saveOrUpdate(int id, String ticketTitle, String tshortdes, String creationDate, String detailedIssue);
	  
	  public void deleteById(int id);
      
	  public List<Ticket> searchBy(String ticketTitle, String tshortdes);
	}  

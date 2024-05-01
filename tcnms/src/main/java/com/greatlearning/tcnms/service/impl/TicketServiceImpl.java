package com.greatlearning.tcnms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.tcnms.entity.Ticket;
import com.greatlearning.tcnms.repository.TicketRepository;
import com.greatlearning.tcnms.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService{

  @Autowired
  TicketRepository ticketRepository;

  @Override
  public List<Ticket> findAll() {
    List<Ticket> tickets = ticketRepository.findAll();
    return tickets;
  }
  @Override
  public void save(Ticket ticket) {
      ticketRepository.save(ticket);                    
  }  

  @Override
  public Ticket findById(int ticketId) {
      return ticketRepository.findById(ticketId).get();
  }
  @Override
  public void saveOrUpdate(int id, String ticketTitle, String tshortdes, String creationDate, String detailedIssue) 
  {

    System.out.println("Ticket ID ->" + id);

    Ticket ticketObj = null;
    if (id == 0) {

      ticketObj = new Ticket(ticketTitle, tshortdes, creationDate, detailedIssue);
      System.out.println("Add Ticket Scenario");
    } else {

      System.out.println("Update Ticket Scenario");

      ticketObj = this.findById(id);
      ticketObj.setTicketTitle(ticketTitle);
      ticketObj.setTshortdes(tshortdes);
      ticketObj.setCreationDate(creationDate);
      ticketObj.setDetailedIssue(detailedIssue);
    }

    // Save/Update the book
    this.save(ticketObj);
  }          
  @Override
  public void deleteById(int id) {
      ticketRepository.deleteById(id);    
  }  
  @Override
  public List<Ticket> searchBy(String ticketTitle, String tshortdes) {
    List<Ticket> tickets 
      = ticketRepository.findByTicketTitleContainsAndTshortdesContainsAllIgnoreCase(
    		  ticketTitle, tshortdes);
    return tickets;
  }  
} 

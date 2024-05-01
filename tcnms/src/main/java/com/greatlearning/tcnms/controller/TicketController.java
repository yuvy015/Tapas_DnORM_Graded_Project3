package com.greatlearning.tcnms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

import com.greatlearning.tcnms.entity.Ticket;
import com.greatlearning.tcnms.service.TicketService;

@Controller
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;
    
    @RequestMapping("/list")
    public String listTickets(Model theModel) {
        
        List<Ticket> theTickets = ticketService.findAll();

        theModel.addAttribute("tickets", theTickets);                

        return "list-tickets";
    }
    @RequestMapping("/displayTicketForm")
    public String addTicket_Step1(Model theModel) {

        Ticket ticket = new Ticket();

        theModel.addAttribute("ticket", ticket);

        return "ticket-form";
    }
    
    @PostMapping("/save")
    public String saveTicket(@RequestParam("id") int id, @RequestParam("Ticket Title") String ticketTitle,
            @RequestParam("Ticket Short Description") String tshortdes, @RequestParam("Ticket Created On") String creationDate, @RequestParam("Detailed Issue") String detailedIssue) {

      ticketService.saveOrUpdate(id, ticketTitle, tshortdes, creationDate, detailedIssue);
      
      // use a redirect to 'books-listing'
      return "redirect:/tickets/list";
    }  
    
    @RequestMapping("/displayTicketForm_Update")
    public String updateTicket_Step1(
        @RequestParam("ticketId") int ticketId,
            Model theModel) {

        Ticket ticket = ticketService.findById(ticketId);

        // set Ticket as a model attribute to pre-populate the form
        theModel.addAttribute("ticket", ticket);

        // send over to our form
        return "ticket-form";   
    }  
    @RequestMapping("/displayTicketForm_View")
    public String viewTicket_Step1(
        @RequestParam("ticketId") int ticketId,
            Model theModel) {

        Ticket ticket = ticketService.findById(ticketId);

        // set Ticket as a model attribute to pre-populate the form
        theModel.addAttribute("ticket", ticket);

        // send over to our form
        return "ticket-view";   
    } 
    @RequestMapping("/delete")
    public String delete(@RequestParam("ticketId") int ticketId) {

        // delete the Book
        ticketService.deleteById(ticketId);

        // redirect to 'tickets-listing'
        return "redirect:/tickets/list";
    }  
    
    @RequestMapping("/search")
    public String search(@RequestParam("Ticket Title") String ticketTitle, @RequestParam("Ticket Short Description") String tshortdes, Model theModel) 
    {

      // Check the name and the author names
      // If both of them are empty, then just give list of all Tickets
      if (ticketTitle.trim().isEmpty() && tshortdes.trim().isEmpty()) {
        return "redirect:/tickets/list";
      } 
      else 
      {

        // Else, search by 'Ticket Title' and 'Short Description'
        List<Ticket> tickets = ticketService.searchBy(ticketTitle, tshortdes);

        // Add it to the UI Model
        theModel.addAttribute("tickets", tickets);

        // Returns the 'tickets-listing' page
        return "list-tickets";
      }
    }            
    
}  

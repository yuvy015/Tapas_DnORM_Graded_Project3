package com.greatlearning.tcnms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ticket")
@Getter
@Setter
public class Ticket {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "TICKET_TITLE")
  private String ticketTitle;

  @Column(name = "TICKET_SHORT_DESCRIPTION")
  private String tshortdes;

  @Column(name = "TICKET_CREATED_ON")
  private String creationDate;
  
  @Column(name = "DETAILED_ISSUE")
  private String detailedIssue;

  public Ticket() {
  }

  public Ticket(String ticketTitle, String tshortdes, String creationDate, String detailedIssue)
  {
    this.ticketTitle = ticketTitle;
    this.tshortdes = tshortdes;
    this.creationDate = creationDate;
    this.detailedIssue = detailedIssue;
  }
}          

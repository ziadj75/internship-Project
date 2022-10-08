package com.example.projetstage.service;

import com.example.projetstage.domain.Ticket;

import java.util.List;

public interface TicketService {
    List<Ticket> findAll();
    List<Ticket> findByEtatTicket(String etat);
    Ticket findByRef(String ref);
    int deleteTicketByRef(String ref);
    int save(Ticket ticket);
    int update(Ticket ticket);
}

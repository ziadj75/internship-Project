package com.example.projetstage.service.impl;

import com.example.projetstage.domain.TacheTicket;
import com.example.projetstage.domain.Ticket;
import com.example.projetstage.domain.User;
import com.example.projetstage.enumeration.Etat;
import com.example.projetstage.repository.TicketRepository;
import com.example.projetstage.service.TacheTicketService;
import com.example.projetstage.service.TicketService;

import com.example.projetstage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final UserService userService;
    private final TacheTicketService tacheTicketService;


    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository,UserService userService,TacheTicketService tacheTicketService) {
        this.ticketRepository = ticketRepository;
        this.userService = userService;
        this.tacheTicketService = tacheTicketService;
    }

    @Override
    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    @Override
    public List<Ticket> findByEtatTicket(String etat) {
        return ticketRepository.findByEtatTicket(etat);
    }

    @Override
    public Ticket findByRef(String ref) {
        return ticketRepository.findByRef(ref);
    }

    @Override
    public int deleteTicketByRef(String ref) {
        return ticketRepository.deleteTicketByRef(ref);
    }

    @Override
    public int save(Ticket ticket) {
        Ticket ticketfound=findByRef(ticket.getRef());
        List<User> userSave=new ArrayList<>();
        List<TacheTicket> tacheTickets=new ArrayList<>();
        if(ticketfound==null){
            ticket.setEtatTicket(String.valueOf(Etat.BEGIN));
            ticket.getEmploye().forEach(user->{
                User userFound = userService.findUserByUsername(user.getUsername());
                userSave.add(userFound);
            });
            ticket.setEmploye(userSave);
            ticket.getTaches().forEach(tacheTicket -> {
                tacheTicketService.save(tacheTicket);
                tacheTickets.add(tacheTicket);
            });
            ticket.setTaches(tacheTickets);
            ticketRepository.save(ticket);
            return 1;
        }
        return -2;
    }

    @Override
    public int update(Ticket ticket) {

        return 0;
    }



}


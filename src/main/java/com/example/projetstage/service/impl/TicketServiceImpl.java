package com.example.projetstage.service.impl;

import com.example.projetstage.domain.Ticket;
import com.example.projetstage.repository.TicketRepository;
import com.example.projetstage.service.TicketService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    private TicketRepository ticketRepository;


    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;

    }

    @Override
    public Ticket findByCode(String code) {
        return ticketRepository.findByCode(code);
    }

    @Override
    public List<Ticket> findByDateDeProbleme(String dateDeProbleme) {
        return ticketRepository.findByDateDeProbleme(dateDeProbleme);
    }

    @Override
    public List<Ticket> findByDateDebutAndDateFin(String dateDebut, String DateFin) {
        return ticketRepository.findByDateDebutAndDateFin(dateDebut, DateFin);
    }

    @Override
    public List<Ticket> findByEtatTicket(String etatTicket) {
        return ticketRepository.findByEtatTicket(etatTicket);
    }

    @Override
    public List<Ticket> findAll() {
        return null;
    }


    @Override
    public List<Ticket> findByTicketMembreEquipeEquipeRef(String ref) {
        return ticketRepository.findByTicketMembreEquipeEquipeRef(ref);
    }

    @Override
    public List<Ticket> findByTicketMembreEquipeMembreEquipeCollaborateurCodeCollaborateur(String code) {
        return ticketRepository.findByTicketMembreEquipeMembreEquipeCollaborateurCodeCollaborateur(code);
    }

    @Transactional
    public int deleteByCode(String code) {
        return ticketRepository.deleteByCode(code);
    }

    @Transactional
    public int deleteByEtatTicket(String etatTicket) {
        return ticketRepository.deleteByEtatTicket(etatTicket);
    }

    @Override
    public int save(Ticket ticket) {
        return 0;
    }

    @Override
    public int update(Ticket ticket) {
        return 0;
    }


}


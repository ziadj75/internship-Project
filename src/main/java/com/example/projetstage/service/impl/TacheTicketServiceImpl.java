package com.example.projetstage.service.impl;

import com.example.projetstage.domain.TacheTicket;
import com.example.projetstage.repository.TacheTicketRepository;
import com.example.projetstage.service.TacheTicketService;
import com.example.projetstage.service.TicketService;
import com.example.projetstage.service.MembreEquipeService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TacheTicketServiceImpl implements TacheTicketService {

    private TacheTicketRepository tacheTicketRepository;

    private TicketService ticketService;



    @Override
    public List<TacheTicket> findAll() {
        return tacheTicketRepository.findAll();
    }

    @Transactional
    public int deleteByCode(String code) {
        return tacheTicketRepository.deleteByCode(code);
    }

    @Override
    public TacheTicket findByCode(String code) {
        return tacheTicketRepository.findByCode(code);
    }

    @Override
    public List<TacheTicket> findByMembreEquipeCollaborateurCodeCollaborateur(String codeCollaborateur) {
        return tacheTicketRepository.findByMembreEquipeCollaborateurCodeCollaborateur(codeCollaborateur);
    }

    @Override
    public List<TacheTicket> findByTicketCode(String code) {
        return tacheTicketRepository.findByTicketCode(code);
    }

    @Override
    public List<TacheTicket> findByMembreEquipeCollaborateurCodeCollaborateurAndTicketCode(String codeCollaborateur, String codeTicket) {
        return tacheTicketRepository.findByMembreEquipeCollaborateurCodeCollaborateurAndTicketCode(codeCollaborateur, codeTicket);
    }


    @Override
    public TacheTicket update(TacheTicket tacheTicket) {
        TacheTicket tacheTicketUpdate = tacheTicketRepository.findByCode(tacheTicket.getCode());
        try {
            tacheTicketUpdate.setEtatTache(!tacheTicketUpdate.getEtatTache());
            tacheTicketRepository.save(tacheTicketUpdate);
            return tacheTicketUpdate;
        } catch (Exception e) {
            return null;
        }
    }

    public int completerTache(String codeTache) {
        TacheTicket tacheTicket  = tacheTicketRepository.findByCode(codeTache);
        try {
            tacheTicket.setEtatTache(!tacheTicket.getEtatTache());
            tacheTicketRepository.save(tacheTicket);
            return 1;
        } catch (Exception e) {
            return -3;
        }

    }
}

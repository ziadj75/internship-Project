package com.example.projetstage.service.impl;

import com.example.projetstage.domain.TacheTicket;
import com.example.projetstage.domain.User;
import com.example.projetstage.enumeration.Etat;
import com.example.projetstage.repository.TacheTicketRepository;
import com.example.projetstage.service.TacheTicketService;
import com.example.projetstage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class TacheTicketServiceImpl implements TacheTicketService {

    private final TacheTicketRepository tacheTicketRepository;
    private final UserService userService;
    @Autowired
    public TacheTicketServiceImpl(TacheTicketRepository tacheTicketRepository,UserService userService) {
        this.tacheTicketRepository = tacheTicketRepository;
        this.userService = userService;
    }

    @Override
    public List<TacheTicket> findAll() {
        return tacheTicketRepository.findAll();
    }

    @Override
    public List<TacheTicket> findByEmployeeUserId(String userId) {
        return tacheTicketRepository.findByEmployeeUserId(userId);
    }

    @Override
    public List<TacheTicket> findByEtatTache(String etat) {
        return tacheTicketRepository.findByEtatTache(etat);
    }

    @Override
    public TacheTicket findByRef(String ref) {
        return tacheTicketRepository.findByRef(ref);
    }

    @Override
    public List<TacheTicket> findByDateDebutAndDateFin(Date dateDebut, Date dateFin) {
        return tacheTicketRepository.findByDateDebutAndDateFin(dateDebut, dateFin);
    }

    @Override
    public List<TacheTicket> alerte(Date date) {
        return tacheTicketRepository.alerte(date);
    }

    @Transactional
    public int deleteByRef(String ref) {
        return tacheTicketRepository.deleteByRef(ref);
    }

    @Override
    public int save(TacheTicket tacheTicket) {
        TacheTicket tacheTicketfound = findByRef(tacheTicket.getRef());
        if(tacheTicketfound==null) {
            User user = userService.findUserByUsername(tacheTicket.getEmployee().getUsername());
            tacheTicket.setEtatTache(String.valueOf(Etat.BEGIN));
            tacheTicket.setEmployee(user);
            tacheTicketRepository.save(tacheTicket);
            return 1;
        }
        return -1;

    }



    @Override
    public int update(TacheTicket tacheTicket) {
        TacheTicket tacheTicketfound = findByRef(tacheTicket.getRef());
        if(tacheTicketfound!=null){
            tacheTicketfound.setEtatTache(tacheTicket.getEtatTache());
            tacheTicketRepository.save(tacheTicketfound);
            return 1;
        }
        return -1;
    }


}

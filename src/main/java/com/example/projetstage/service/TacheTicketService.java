package com.example.projetstage.service;

import com.example.projetstage.domain.TacheTicket;
import com.example.projetstage.domain.Ticket;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TacheTicketService {
    List<TacheTicket> findAll();
    List<TacheTicket>  findByEmployeeUserId(String userId);
    List<TacheTicket> findByEtatTache(String etat);
    TacheTicket findByRef(String ref);
    List<TacheTicket> findByDateDebutAndDateFin(Date dateDebut, Date dateFin);
    List<TacheTicket> alerte( Date date);
    int save(TacheTicket ticket);
    int update(TacheTicket ticket);
    int deleteByRef(String ref);

}

package com.example.projetstage.repository;

import com.example.projetstage.domain.TacheTicket;
import com.example.projetstage.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long> {
    List<Ticket> findAll();
    List<Ticket> findByEtatTicket(String etat);
    Ticket findByRef(String ref);
    int deleteTicketByRef(String ref);

}

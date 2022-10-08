package com.example.projetstage.repository;

import com.example.projetstage.domain.TacheTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TacheTicketRepository extends JpaRepository<TacheTicket,Long> {
    List<TacheTicket> findAll();
     List<TacheTicket>  findByEmployeeUserId(String userId);
    List<TacheTicket> findByEtatTache(String etat);
    TacheTicket findByRef(String ref);
    List<TacheTicket> findByDateDebutAndDateFin(Date dateDebut,Date dateFin);
    int deleteByRef(String ref);
    @Query("select c from TacheTicket c where :date between c.dateFin  And :date")
    List<TacheTicket> alerte(@Param("date") Date date);


}

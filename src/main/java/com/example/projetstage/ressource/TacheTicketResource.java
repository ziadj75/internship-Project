package com.example.projetstage.ressource;

import com.example.projetstage.domain.TacheTicket;
import com.example.projetstage.service.TacheTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/tacheTicket")
public class TacheTicketResource {
    @Autowired
    private TacheTicketService tacheTicketService;
    @GetMapping("/")
    public List<TacheTicket> findAll() {
        return tacheTicketService.findAll();
    }
    @GetMapping("/userid/{userId}")
    public List<TacheTicket> findByEmployeeUserId(@PathVariable String userId) {
        return tacheTicketService.findByEmployeeUserId(userId);
    }
    @GetMapping("/etat/{etat}")
    public List<TacheTicket> findByEtatTache(@PathVariable String etat) {
        return tacheTicketService.findByEtatTache(etat);
    }
    @GetMapping("/ref/{ref}")
    public TacheTicket findByRef(@PathVariable String ref) {
        return tacheTicketService.findByRef(ref);
    }
    @GetMapping("/dateDebut/{dateDebut}/dateFin/{dateFin}")
    public List<TacheTicket> findByDateDebutAndDateFin(@PathVariable Date dateDebut,@PathVariable Date dateFin) {
        return tacheTicketService.findByDateDebutAndDateFin(dateDebut, dateFin);
    }
    @GetMapping("/now/{date}")
    public List<TacheTicket> alerte(@PathVariable Date date) {
        return tacheTicketService.alerte(date);
    }
    @PostMapping("/")
    public int save(@RequestBody TacheTicket ticket) {
        return tacheTicketService.save(ticket);
    }
    @PutMapping("/")
    public int update(@RequestBody TacheTicket ticket) {
        return tacheTicketService.update(ticket);
    }
    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(String ref) {
        return tacheTicketService.deleteByRef(ref);
    }
}

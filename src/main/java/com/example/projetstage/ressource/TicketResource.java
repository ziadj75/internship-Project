package com.example.projetstage.ressource;

import com.example.projetstage.domain.Ticket;
import com.example.projetstage.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Ticket")
public class TicketResource {

    @Autowired
    private TicketService ticketService;
    @GetMapping("/")
    public List<Ticket> findAll() {
        return ticketService.findAll();
    }
    @GetMapping("/etat/{etat}")
    public List<Ticket> findByEtatTicket(@PathVariable String etat) {
        return ticketService.findByEtatTicket(etat);
    }
    @GetMapping("/ref/{ref}")
    public Ticket findByRef(@PathVariable String ref) {
        return ticketService.findByRef(ref);
    }
    @DeleteMapping("/ref/{ref}")
    public int deleteTicketByRef(@PathVariable String ref) {
        return ticketService.deleteTicketByRef(ref);
    }
    @PostMapping("/")
    public int save(@RequestBody Ticket ticket) {
        return ticketService.save(ticket);
    }
    @PutMapping("/")
    public int update(@RequestBody Ticket ticket) {
        return ticketService.update(ticket);
    }
}

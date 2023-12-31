package controller.test;

import com.projet.projetojava.ProjetojavaApplication;
import com.projet.projetojava.controller.TicketController;
import com.projet.projetojava.entity.Ticket;
import com.projet.projetojava.service.TicketService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = ProjetojavaApplication.class)
public class TicketControllerTest {

    @InjectMocks
    TicketController ticketController;

    @Mock
    TicketService ticketService;

    @Test
    public void testGetAllTickets() {
        Ticket ticket1 = new Ticket();
        ticket1.setId(1L);

        Ticket ticket2 = new Ticket();
        ticket2.setId(2L);

        List<Ticket> tickets = Arrays.asList(ticket1, ticket2);

        when(ticketService.getAllTickets()).thenReturn(tickets);

        List<Ticket> result = ticketController.getAllTickets();

        assertEquals(tickets.size(), result.size());
    }

    @Test
    public void testGetTicket() {
        Long id = 1L;
        Ticket ticket = new Ticket();
        ticket.setId(id);

        when(ticketService.getTicket(id)).thenReturn(ticket);

        Ticket result = ticketController.getTicket(id);

        assertEquals(ticket.getId(), result.getId());
    }

    @Test
    public void testCreateTicket() {
        Ticket ticket = new Ticket();
        ticket.setId(1L);

        when(ticketService.createTicket(ticket)).thenReturn(ticket);

        Ticket result = ticketController.createTicket(ticket);

        assertEquals(ticket.getId(), result.getId());
    }

    @Test
    public void testUpdateTicket() {
        Long id = 1L;
        Ticket ticket = new Ticket();
        ticket.setId(id);

        when(ticketService.updateTicket(id, ticket)).thenReturn(ticket);

        Ticket result = ticketController.updateTicket(id, ticket);

        assertEquals(ticket.getId(), result.getId());
    }

    @Test
    public void testDeleteTicket() {
        Long id = 1L;

        doNothing().when(ticketService).deleteTicket(id);

        ticketController.deleteTicket(id);

        verify(ticketService, times(1)).deleteTicket(id);
    }
}

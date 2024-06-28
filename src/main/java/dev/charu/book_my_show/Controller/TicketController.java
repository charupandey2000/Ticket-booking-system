package dev.charu.book_my_show.Controller;

import dev.charu.book_my_show.Dtos.BookTicketRequestdto;
import dev.charu.book_my_show.Model.User;
import dev.charu.book_my_show.Repository.ShowSeatRepository;
import dev.charu.book_my_show.Repository.userRepository;
import dev.charu.book_my_show.Service.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/Ticket")
public class TicketController {
   TicketService ticketService;
    public TicketController(TicketService ticketService){
        this.ticketService=ticketService;

    }

    @PostMapping("/Book")
    public void bookSeat(@RequestBody BookTicketRequestdto bookTicketRequestdto) {

        ticketService.bookSeats(bookTicketRequestdto.getShowSeatList(),bookTicketRequestdto.getUserId());

    }
    @PostMapping("/Reserve")
    public void reserveSeat(@RequestBody BookTicketRequestdto bookTicketRequestdto){
        BookTicketRequestdto bookTicketRequestdto1=bookTicketRequestdto;
        ticketService.reserveSeats(bookTicketRequestdto.getShowSeatList(),bookTicketRequestdto.getUserId());
    }


}

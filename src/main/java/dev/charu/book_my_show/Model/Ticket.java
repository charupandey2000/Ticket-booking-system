package dev.charu.book_my_show.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
@Entity
@Getter
@Setter
public class Ticket extends BaseModel{
    @OneToMany
    private List<ShowSeat>showSeatList=new ArrayList<>();

    private Integer Amount;

    @Enumerated
    private TicketStatus ticketStatus;

    @ManyToOne
    private Show show;

    @ManyToOne
    private User user;


}

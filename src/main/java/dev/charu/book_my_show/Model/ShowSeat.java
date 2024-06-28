package dev.charu.book_my_show.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Entity
@Getter
@Setter
public class ShowSeat extends BaseModel{
    @ManyToOne
    private Show show;
    @ManyToOne
    private Seat seat;

    @Enumerated
    private showSeatStatus showSeatStatus;

    private LocalDateTime ReservationTimestamp;


}

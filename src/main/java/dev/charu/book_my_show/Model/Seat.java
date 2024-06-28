package dev.charu.book_my_show.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Entity
@Getter
@Setter
public class Seat extends BaseModel {
    private long seatNo;
    @Enumerated
    private SeatType seatType;

}

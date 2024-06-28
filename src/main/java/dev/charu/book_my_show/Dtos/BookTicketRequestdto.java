package dev.charu.book_my_show.Dtos;

import dev.charu.book_my_show.Model.ShowSeat;
import dev.charu.book_my_show.Model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class BookTicketRequestdto {
    private List<Long>showSeatList=new ArrayList<>();
    private long userId;

}

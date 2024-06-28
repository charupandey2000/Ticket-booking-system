package dev.charu.book_my_show.Repository;

import dev.charu.book_my_show.Model.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat,Long> {

    public Optional<ShowSeat> findById(Long aLong);

    //List<ShowSeat>finByIdIn(List<Long>k);
}

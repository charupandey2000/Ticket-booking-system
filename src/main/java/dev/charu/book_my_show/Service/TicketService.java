package dev.charu.book_my_show.Service;

import dev.charu.book_my_show.Exception.alreadyReserveException;
import dev.charu.book_my_show.Model.ShowSeat;
import dev.charu.book_my_show.Model.User;
import dev.charu.book_my_show.Model.showSeatStatus;
import dev.charu.book_my_show.Repository.ShowSeatRepository;
import dev.charu.book_my_show.Repository.userRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class TicketService {
    private static final int RESERVATION_TIMEOUT_MINUTES = 5;
    Lock lock = new ReentrantLock();

    userRepository userRepository;
    ShowSeatRepository showSeatRepository;

    public TicketService(userRepository userRepository, ShowSeatRepository showSeatRepository) {
        this.userRepository = userRepository;
        this.showSeatRepository = showSeatRepository;
    }

    public void reserveSeats(List<Long> showSeat, Long userId) {
        lock.lock();
        User user = userRepository.findById(userId).get();

        List<ShowSeat> showSeatList = new ArrayList<>();
        for(Long seat:showSeat){
            ShowSeat showSeat1=showSeatRepository.findById(seat).get();
            showSeatList.add(showSeat1);
        }

        for (ShowSeat showSeat1 : showSeatList) {
            if (showSeat1.getShowSeatStatus() == showSeatStatus.blocked || showSeat1.getReservationTimestamp() != null && showSeat1.getReservationTimestamp().isAfter(LocalDateTime.now().minusMinutes(RESERVATION_TIMEOUT_MINUTES))) {
                throw new alreadyReserveException("these seats are reserved please select another");
            }
            showSeat1.setReservationTimestamp(LocalDateTime.now());
            showSeat1.setShowSeatStatus(showSeatStatus.blocked);
            showSeatRepository.save(showSeat1);
        }
        lock.unlock();

    }

    public void bookSeats(List<Long> showSeat, Long userId) {
        lock.lock();
        User user = userRepository.findById(userId).get();
        List<ShowSeat> showSeatList = new ArrayList<>();
        for(Long seat:showSeat){
            ShowSeat showSeat1=showSeatRepository.findById(seat).get();
            showSeatList.add(showSeat1);
        }

        for (ShowSeat showSeat1 : showSeatList) {
            if (showSeat1.getShowSeatStatus() == showSeatStatus.occupied || (showSeat1.getReservationTimestamp() == null ||
                    showSeat1.getReservationTimestamp().isBefore(LocalDateTime.now().minusMinutes(RESERVATION_TIMEOUT_MINUTES)))) {
                throw new alreadyReserveException("already");
            }
            showSeat1.setShowSeatStatus(showSeatStatus.occupied);
            showSeat1.setReservationTimestamp(null);
            showSeatRepository.save(showSeat1);

        }
        lock.unlock();

    }
}
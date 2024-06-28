package dev.charu.book_my_show.Repository;

import dev.charu.book_my_show.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface userRepository extends JpaRepository<User,Long> {

    public Optional<User> findById(Long userId);

}

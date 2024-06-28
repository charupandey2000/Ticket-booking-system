package dev.charu.book_my_show.Model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Entity
@Component
@Getter
@Setter
public class User extends BaseModel{
    private String userName;
    private String emailId;
}

package dev.charu.book_my_show.Model;

import jakarta.persistence.Entity;
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
public class City extends BaseModel{
    private String Name;

    private String Address;
    @OneToMany
    private List<Threater> theatres = new ArrayList<>();

}

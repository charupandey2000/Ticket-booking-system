package dev.charu.book_my_show.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Entity
@Getter
@Setter
public class Threater extends BaseModel {
    private String name;
    private String Address;
    @OneToMany
    private List<Hall>halls;



}

package dev.charu.book_my_show.Model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Movie extends BaseModel{

    private String name;
    private Integer duration;
    private Double rating;

    @ElementCollection
    @Enumerated
    private List<languageType> languages = new ArrayList<>();


}

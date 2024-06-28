package dev.charu.book_my_show.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
@Entity(name="shows")
@Getter
@Setter
@NoArgsConstructor
public class Show extends BaseModel {
    @ManyToOne
    private Movie movie;

    @Enumerated
    private languageType language;

    private Date startTime;

    private Date endTime;

    @ManyToOne
    private Hall hall;




}

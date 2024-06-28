package dev.charu.book_my_show.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
public class Hall extends BaseModel{

    private Integer hallNO;



}

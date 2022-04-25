package mk.ukim.finki.emt.lab2.emtlab2.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.ukim.finki.emt.lab2.emtlab2.model.Category;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

    private String name;

    private Category category;

    private Long author;

    private Integer availableCopies;

}

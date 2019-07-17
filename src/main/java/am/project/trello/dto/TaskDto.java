package am.project.trello.dto;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {

    private Integer id;

    @NotNull(message = "Tittle can't be null")
    @NotBlank(message = "Tittle can't be empty")
    @NotEmpty(message = "Tittle can't be empty")
    private String title;

    @NotNull(message = "Body can't be null")
    @NotBlank(message = "Body can't be empty")
    @NotEmpty(message = "Body can't be empty")
    private String body;

    @DateTimeFormat(pattern = "dd/MM/yyyy HH: mm: ss")
    @CreatedDate()
    private Date createdAt;

    private Integer userId;

}

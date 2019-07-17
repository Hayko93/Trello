package am.project.trello.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Integer id;

    @NotNull(message = "Name can't be null")
    @NotBlank(message = "Name can't be empty")
    @NotEmpty(message = "Name can't be empty")
    private String name;

    @NotNull(message = "Last Name can't be null")
    @NotBlank(message = "Last Name can't be empty")
    @NotEmpty(message = "Last Name can't be empty")
    private String lastName;

    @Email(message = "Invalid email")
    private String email;

    @NotNull(message = "Password can't be null")
    @NotBlank(message = "Password can't be empty")
    @NotEmpty(message = "Password can't be empty")
    private String password;
}

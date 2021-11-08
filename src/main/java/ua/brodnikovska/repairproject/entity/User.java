package ua.brodnikovska.repairproject.entity;

import lombok.Data;
import ua.brodnikovska.repairproject.annotation.ValidPassword;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@Entity
@Table(name="usersdata",
        uniqueConstraints={@UniqueConstraint(columnNames={"email", "username"})})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @NotEmpty(message = "Username should not be empty")
    @Size(min = 2, max = 30, message = "Username should be between 2 and 30 characters")
    @Column(unique = true)
    private String username;

    @NotEmpty(message = "Email should not be empty")
    @Email
    private String email;

    @NotEmpty(message = "Password should not be empty")
    @ValidPassword
    private String password;

    @Enumerated(EnumType.STRING)
    private RoleType role;

    private BigDecimal balance;
}

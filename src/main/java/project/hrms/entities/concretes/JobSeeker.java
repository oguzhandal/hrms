package project.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "CvTables"})
@PrimaryKeyJoinColumn(name = "user_id")
@Table(name = "candidates")
public class JobSeeker extends User {

    @NotEmpty(message = "First name cannot be empty")
    @NotBlank
    @Column(name = "first_name")
    private String firstName;

    @NotBlank
    @NotEmpty(message = "Last name cannot be empty")
    @Column(name = "last_name")
    private String lastName;

    @NotBlank
    @NotEmpty(message = "Identity number cannot be empty")
    @Column(name = "identity_number")
    private String identityNumber;

    @NotBlank
    @NotEmpty(message = "Date of birth cannot be empty")
    @Column(name = "birth_year")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthYear;

}

package project.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_seekers")
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
public class JobSeeker extends User {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "identity_Number")
    private String identityNumber;

    @Column(name = "birth_date")
    private String birthDate;


}

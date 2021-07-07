package project.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "education_info")
public class EducationInfo {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "university_name")
    private String universityName;

    @Column(name = "departman_name")
    private String departmanName;

    @Column(name = "starting_date")
    private Date startingDate;

    @Column(name = "completion_date")
    private Date completionDate;

    @Column(name = "is_active_student")
    private boolean is_active_student;
}

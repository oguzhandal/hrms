package project.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cv_schools")
public class SchoolForCV extends Base {

    @Column(name = "name")
    private String schoolName;

    @Column(name = "department ")
    private String department;

    @Column(name = "start_at")
    private LocalDate startAt;

    @Column(name = "ent_at", nullable = false)
    private LocalDate endAt;

    @ManyToOne()
    @JoinColumn(name = "jobSeeker_id")
    private JobSeeker jobSeeker;
}

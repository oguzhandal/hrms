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
@Table(name = "cv_experiences")
public class ExperienceForCV extends Base {

    @Column(name = "working_place")
    private String workingPlace;

    @Column(name = "position")
    private String Position;

    @Column(name = "starting_date")
    private LocalDate startingDate;

    @Column(name = "completion_date", nullable = false)
    private LocalDate completionDate;

    @ManyToOne()
    @JoinColumn(name = "jobSeeker_id")
    private JobSeeker jobSeeker;

}

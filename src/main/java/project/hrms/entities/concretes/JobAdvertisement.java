package project.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_advertisements")
public class JobAdvertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "job_description")
    private String jobDescription;

    @Column(name = "salary_min")
    private int salaryMin;

    @Column(name = "salary_max")
    private int salaryMax;

    @Column(name = "position_number")
    private int positionNumber;

    @Column(name = "last_date")
    private Date lastDate;

    @Column(name = "release_date")
    private Date releaseDate;

    @Column(name = "status")
    private boolean status;


    @ManyToOne()
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne()
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @ManyToOne()
    @JoinColumn(name = "job_title_id")
    private JobTitle job_title;
}

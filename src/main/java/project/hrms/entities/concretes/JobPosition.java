package project.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "job_positions")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobAdverts"})
public class JobPosition extends Base {

    @Column(name = "job_title")
    private String jobTitle;

    @OneToMany(mappedBy = "jobPosition")
    private List<JobAdvert> jobAdverts;

    public JobPosition(String jobTitle, List<JobAdvert> jobAdverts) {
        super();
        this.jobTitle = jobTitle;
        this.jobAdverts = jobAdverts;
    }
}

package project.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobAdverts"})
@Table(name = "cities")
public class City extends Base {

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "city")
    private List<JobAdvert> jobAdverts;

    public City(String name, List<JobAdvert> jobAdverts) {
        super();
        this.jobAdverts = jobAdverts;
        this.name = name;
    }
}
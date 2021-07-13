package project.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cv_images")
public class ImageForCV extends Base {

    @Column(name = "url")
    private String url;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "jobSeeker_id", referencedColumnName = "user_id")
    private JobSeeker jobSeeker;
}

package project.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "cv_cover_letters")
public class CoverLetterForCV extends Base {

    @Column(name = "content")
    private String content;

    public CoverLetterForCV(String content, int jobSeekerId) {
        super();
        this.content = content;
        this.jobSeeker.setId(jobSeekerId);
    }

    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "jobSeeker_id")
    private JobSeeker jobSeeker;
}

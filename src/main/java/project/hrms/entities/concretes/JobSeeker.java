package project.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id")
@Table(name = "jobSeekers")
public class JobSeeker extends User {


    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "identity_number")
    private String identityNumber;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "is_verified", columnDefinition = "boolean default false")
    private boolean isVerified = false;

    @JsonIgnore
    @OneToMany(mappedBy = "jobSeeker")
    private List<SchoolForCV> schools;

    @JsonIgnore
    @OneToMany(mappedBy = "jobSeeker")
    private List<ProgrammingSkillForCV> programingSkills;

    @JsonIgnore
    @OneToMany(mappedBy = "jobSeeker")
    private List<LinkForCV> links;

    @JsonIgnore
    @OneToMany(mappedBy = "jobSeeker")
    private List<ForeignLanguageForCV> languages;

    @JsonIgnore
    @OneToMany(mappedBy = "jobSeeker")
    private List<ExperienceForCV> experiences;

    @JsonIgnore
    @OneToMany(mappedBy = "jobSeeker")
    private List<CoverLetterForCV> coverLetters;

    @JsonIgnore
    @OneToOne(mappedBy = "jobSeeker", optional = false, fetch = FetchType.LAZY)
    private ImageForCV image;
}

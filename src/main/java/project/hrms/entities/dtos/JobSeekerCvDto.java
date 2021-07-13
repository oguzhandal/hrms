package project.hrms.entities.dtos;

import project.hrms.entities.concretes.*;

import java.util.List;

public class JobSeekerCvDto {
    public JobSeeker jobSeeker;
    public List<SchoolForCV> schools;
    public List<ProgrammingSkillForCV> programingSkills;
    public List<LinkForCV> links;
    public List<ForeignLanguageForCV> languages;
    public List<ExperienceForCV> experiences;
    public ImageForCV image;
}
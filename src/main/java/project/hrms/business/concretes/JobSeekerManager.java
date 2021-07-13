package project.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hrms.business.abstracts.*;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.JobSeekerDao;
import project.hrms.entities.concretes.JobSeeker;
import project.hrms.entities.dtos.JobSeekerCvDto;

import java.util.List;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobseekerDao;
	private ExperienceForCVService experienceForCVService;
	private ForeignLanguageForCVService foreignLanguageForCVService;
	private ImageForCVService imageForCVService;
	private LinkForCVService linkForCVService;
	private ProgrammingSkillForCVService programmingSkillForCVService;
	private SchoolForCVService schoolForCVService;

	public JobSeekerManager(JobSeekerDao jobseekerDao, ExperienceForCVService experienceForCVService,
							ForeignLanguageForCVService foreignLanguageForCVService, ImageForCVService imageForCVService,
							LinkForCVService linkForCVService, ProgrammingSkillForCVService programmingSkillForCVService,
							SchoolForCVService schoolForCVService) {
		super();
		this.jobseekerDao = jobseekerDao;
		this.experienceForCVService = experienceForCVService;
		this.foreignLanguageForCVService = foreignLanguageForCVService;
		this.imageForCVService = imageForCVService;
		this.linkForCVService = linkForCVService;
		this.programmingSkillForCVService = programmingSkillForCVService;
		this.schoolForCVService = schoolForCVService;
	}

	@Override
	public Result add(JobSeeker jobseeker) {
		this.jobseekerDao.save(jobseeker);
		return new SuccessResult("JobSeeker has been added.");
	}

	@Override
	public Result update(JobSeeker jobseeker) {
		this.jobseekerDao.save(jobseeker);
		return new SuccessResult("JobSeeker has been updated.");
	}

	@Override
	public Result delete(int id) {
		this.jobseekerDao.deleteById(id);
		return new SuccessResult("JobSeeker has been deleted.");
	}

	@Override
	public DataResult<JobSeeker> getById(int id) {
		return new SuccessDataResult<JobSeeker>(this.jobseekerDao.getById(id));
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobseekerDao.findAll());
	}

	@Override
	public DataResult<JobSeeker> findJobSeekerByIdentityNumber(String identityNumber) {
		return new SuccessDataResult<JobSeeker>(this.jobseekerDao.findJobSeekerByIdentityNumber(identityNumber));
	}

	@Override
	public DataResult<JobSeekerCvDto> getJobSeekerCvById(int id) {
		JobSeeker jobseeker = this.jobseekerDao.getById(id);
		JobSeekerCvDto cv = new JobSeekerCvDto();
		cv.experiences = jobseeker.getExperiences();
		cv.languages = jobseeker.getLanguages();
		cv.image = jobseeker.getImage();
		cv.links = jobseeker.getLinks();
		cv.programingSkills = jobseeker.getProgramingSkills();
		cv.schools = jobseeker.getSchools();
		return new SuccessDataResult<JobSeekerCvDto>(cv);
	}

}
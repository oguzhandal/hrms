package project.hrms.business.abstracts;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.JobAdvertisement;

import java.util.List;


public interface JobAdvertisementService {

    Result add(JobAdvertisement jobAdvertisement);

    Result update(int id, boolean status);

    DataResult<List<JobAdvertisement>> getAll();

    DataResult<List<JobAdvertisement>> getAllStatusTrue();

    DataResult<List<JobAdvertisement>> getAllSortedByLastDate();

    DataResult<List<JobAdvertisement>> getAllEmployerAndStatusTrue(String companyName);

}

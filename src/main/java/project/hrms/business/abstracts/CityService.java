package project.hrms.business.abstracts;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.City;

import java.util.List;

public interface CityService {
    DataResult<List<City>> getAll();

    Result add(City city);
}

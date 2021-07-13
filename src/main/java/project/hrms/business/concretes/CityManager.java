package project.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hrms.business.abstracts.CityService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.dataAccess.abstracts.CityDao;
import project.hrms.entities.concretes.City;

import java.util.List;

@Service
public class CityManager implements CityService {
    private CityDao cityDao;

    @Autowired
    public CityManager(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @Override
    public DataResult<List<City>> getAll() {
        return new SuccessDataResult<List<City>>(this.cityDao.findAll());
    }

    /*
    @Override
    public Result add(City city) {
        this.cityDao.save(city);
        return new SuccessResult("Şehir eklendi.");
    }
    	@Override
    	public Result update(City city) {
    		this.cityDao.save(city);
    	    return new SuccessResult("City has been updated.");
    	}

    	@Override
    	public Result delete(int id) {
    		this.cityDao.deleteById(id);
    	    return new SuccessResult("City has been deleted.");
    	}

    	@Override
    	public DataResult<City> getById(int id) {
    		return new SuccessDataResult<City>(this.cityDao.getById(id));
    	}
    */
}

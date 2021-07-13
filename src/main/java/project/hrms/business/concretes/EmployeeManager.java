package project.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hrms.business.abstracts.EmployeeService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.dataAccess.abstracts.EmployeeDao;
import project.hrms.entities.concretes.Employee;

import java.util.List;

@Service
public class EmployeeManager implements EmployeeService {

    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeManager(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public DataResult<List<Employee>> getAll() {
        // TODO Auto-generated method stub
        return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll());
    }

/*
	@Override
	public Result add(Employee employee) {
		this.employeeDao.save(employee);
      return new SuccessResult("Employee has been added.");
	}

	@Override
	public Result update(Employee employee) {
		this.employeeDao.save(employee);
      return new SuccessResult("Employee has been updated.");
	}

	@Override
	public Result delete(int id) {
		this.employeeDao.deleteById(id);
      return new SuccessResult("Employee has been deleted.");
	}

	@Override
	public DataResult<Employee> getById(int id) {
		return new SuccessDataResult<Employee>(this.employeeDao.getById(id));
	}
*/


}
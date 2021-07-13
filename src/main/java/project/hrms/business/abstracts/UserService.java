package project.hrms.business.abstracts;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.User;

import java.util.List;

public interface UserService {
    public DataResult<List<User>> getAll();

    DataResult<User> getUserByEmail(String email);

    Result add(User user);


}

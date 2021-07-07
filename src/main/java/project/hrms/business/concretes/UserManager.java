package project.hrms.business.concretes;

import org.springframework.stereotype.Service;
import project.hrms.business.abstracts.UserService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.dataAccess.abstracts.UserDao;
import project.hrms.entities.concretes.User;

import java.util.List;

@Service
public class UserManager implements UserService {
    private UserDao userDao;

    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<List<User>>(this.userDao.findAll(), "Tüm kullanıcılar listelendi");
    }
}

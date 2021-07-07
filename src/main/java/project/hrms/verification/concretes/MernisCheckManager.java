package project.hrms.verification.concretes;

import org.springframework.stereotype.Service;
import project.hrms.entities.concretes.User;
import project.hrms.verification.abstracts.MernisCheckService;

@Service
public class MernisCheckManager implements MernisCheckService {
    @Override
    public boolean checkIfRealPerson(User user) {
        return true;
    }
}

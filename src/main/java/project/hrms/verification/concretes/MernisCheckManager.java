package project.hrms.verification.concretes;

import project.hrms.entities.concretes.User;
import project.hrms.verification.abstracts.MernisCheckService;

public class MernisCheckManager implements MernisCheckService {
    @Override
    public boolean checkIfRealPerson(User user) {
        return true;
    }
}

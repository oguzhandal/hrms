package project.hrms.verification.abstracts;

import project.hrms.entities.concretes.User;

public interface MernisCheckService {
    boolean checkIfRealPerson(User user);

}

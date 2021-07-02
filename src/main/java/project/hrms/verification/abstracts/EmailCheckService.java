package project.hrms.verification.abstracts;

import project.hrms.entities.concretes.User;

public interface EmailCheckService {
    boolean checkIfRealEmail(User user);

}

package project.hrms.verification.concretes;

import project.hrms.entities.concretes.User;
import project.hrms.verification.abstracts.EmailCheckService;

public class EmailCheckManager  implements EmailCheckService {
    @Override
    public boolean checkIfRealEmail(User user) {
        return true;
    }
}

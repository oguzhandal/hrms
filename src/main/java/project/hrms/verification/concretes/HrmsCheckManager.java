package project.hrms.verification.concretes;

import project.hrms.entities.concretes.User;
import project.hrms.verification.abstracts.HrmsCheckService;

public class HrmsCheckManager implements HrmsCheckService {
    @Override
    public boolean checkIfConfirmHrms(User user) {
        return true;
    }
}

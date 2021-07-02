package project.hrms.verification.abstracts;

import project.hrms.entities.concretes.User;

public interface HrmsCheckService {
    boolean checkIfConfirmHrms(User user);

}

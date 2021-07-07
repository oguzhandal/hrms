package project.hrms.verification.concretes;

import org.springframework.stereotype.Service;
import project.hrms.entities.concretes.User;
import project.hrms.verification.abstracts.HrmsCheckService;

@Service
public class HrmsCheckManager implements HrmsCheckService {
    @Override
    public boolean checkIfConfirmHrms(User user) {
        return true;
    }
}

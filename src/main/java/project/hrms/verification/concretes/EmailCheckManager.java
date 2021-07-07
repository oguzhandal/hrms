package project.hrms.verification.concretes;

import org.springframework.stereotype.Service;
import project.hrms.entities.concretes.User;
import project.hrms.verification.abstracts.EmailCheckService;

@Service
public class EmailCheckManager  implements EmailCheckService {
    @Override
    public boolean checkIfRealEmail(User user) {
        return true;
    }
}

package project.hrms.core.fakeServices.concretes;

import org.springframework.stereotype.Service;
import project.hrms.core.fakeServices.abstracts.EmailService;
import project.hrms.entities.concretes.User;

@Service
public class EmailManager implements EmailService {
    @Override
    public boolean linkToVerify(User user) {
        return true;
    }
}

package project.hrms.core.fakeServices.abstracts;

import project.hrms.entities.concretes.User;

public interface EmailService {
    boolean linkToVerify(User user);
}

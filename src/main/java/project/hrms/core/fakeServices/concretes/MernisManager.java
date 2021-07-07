package project.hrms.core.fakeServices.concretes;

import project.hrms.core.fakeServices.abstracts.MernisService;
import project.hrms.entities.concretes.User;

public class MernisManager implements MernisService {
    @Override
    public boolean userVerification(User user) {
        return true;
    }
}

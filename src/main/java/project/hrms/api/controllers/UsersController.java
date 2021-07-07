package project.hrms.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.hrms.business.abstracts.UserService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.entities.concretes.User;

import java.util.List;

@RestController
@RequestMapping("/api/users/")
public class UsersController {

    private UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("add")
    public DataResult<List<User>> getAll() {
        return this.userService.getAll();
    }
}

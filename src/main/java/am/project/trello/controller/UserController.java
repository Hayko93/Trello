package am.project.trello.controller;

import am.project.trello.mapper.UserMapper;
import am.project.trello.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/api/users")
public class UserController {

    private static Logger logger =  LoggerFactory.getLogger(UserController.class);

    private UserService userService;
    UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }
}

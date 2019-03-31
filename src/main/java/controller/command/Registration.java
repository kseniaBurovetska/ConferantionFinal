package controller.command;

import model.entity.User;
import model.entity.enums.Role;
import model.service.UserService;

import javax.servlet.http.HttpServletRequest;

public class Registration implements Command {

    private UserService userService;

    public Registration(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String firstName = request.getParameter("firstName");
        String surName = request.getParameter("surName");
        String role = request.getParameter("role");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");

        if(firstName==null || surName==null || role == null || email == null){
            return "/registration.jsp";
        }

        User user = new User();
        user.setName(firstName);
        user.setSurname(surName);
        user.setRole(Role.valueOf(role));
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);

        if (userService.validateData(user)) {
            return "/registration.jsp";
        }

        return "/registration.jsp";
    }
}

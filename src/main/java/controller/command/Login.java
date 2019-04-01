package controller.command;

import model.entity.User;
import model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Login implements Command {

    private Map<String, String> pages = new HashMap<>();
    private UserService userService;

    public Login(UserService userService) {
        this.userService = userService;

        pages.put("login", "/login.jsp");
        pages.put("MODERATOR", "redirect:moderator");
        pages.put("SPEAKER", "redirect:speaker");
        pages.put("VISITOR", "redirect:visitor");
    }

    @Override
    public String execute(HttpServletRequest request) {
        String email = request.getParameter("email");
        String pass = request.getParameter("password");

        if (email == null || email.equals("") || pass == null || pass.equals("")) {
            return "/login.jsp";
        }

        Optional<User> user = userService.login(email);


        if (user.isPresent() && pass.equals(user.get().getPassword())) {

            if(CommandUtility.cannotLogUser(request, user.get().getEmail(), user.get().getRole())){
                return "/WEB-INF/error.jsp";
            }

            return pages.getOrDefault(user.get().getRole().name(), pages.get("login"));
        }

        return "/login.jsp";
    }
}

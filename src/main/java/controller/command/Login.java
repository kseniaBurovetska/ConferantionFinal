package controller.command;

import model.entity.enums.Role;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class Login implements Command {

    Map<String, String> pages = new HashMap<>();

    public Login() {
        pages.put("login", "/login.jsp");
        pages.put("moderator", "redirect:moderator");
        pages.put("speaker", "redirect:speaker");
        pages.put("visitor", "redirect:visitor");
    }

    @Override
    public String execute(HttpServletRequest request) {
        String name = request.getParameter("login");
        String pass = request.getParameter("password");

        System.out.println(name + " " + pass);
        if (name == null || name.equals("") || pass == null || pass.equals("")) {
            return "/login.jsp";
        }

        return pages.getOrDefault(name.toLowerCase(), pages.get("login"));
    }
}

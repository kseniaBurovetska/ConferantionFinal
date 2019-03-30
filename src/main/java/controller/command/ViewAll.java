package controller.command;

import javax.servlet.http.HttpServletRequest;

public class ViewAll implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        return "/views/viewAll.jsp";
    }
}

package controller.command;

import javax.servlet.http.HttpServletRequest;

public class Visitor implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "/WEB-INF/visitor/visitorBase.jsp";
    }
}

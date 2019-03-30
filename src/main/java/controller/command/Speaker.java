package controller.command;

import javax.servlet.http.HttpServletRequest;

public class Speaker implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "/WEB-INF/speaker/speakerBase.jsp";
    }
}

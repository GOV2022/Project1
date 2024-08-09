package org.example.controller;

import org.example.dto.VoteDTO;
import org.example.service.VoteService;
import org.example.service.api.IVoteService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/vote")
public class VoteServlet extends HttpServlet {

    private final static IVoteService voteService = VoteService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.write("<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                "    <title>Форма для голосования</title>\n" +
                "    <link rel=\"stylesheet\" href = \"my.css\">\n" +
                "    <style>\n" +
                "\t\t\t\t.class {\n" +
                "\t\tbackground-color: lightgreen;\n" +
                "\t\t}\n" +
                "\t\t\t\t.class1 {\n" +
                "\t\tfont-size: 30px;\n" +
                "\t\tcolor: blue;\n" +
                "\t\t}\n" +
                "\t\t\t\t.class2 {\n" +
                "\t\tfont-size: 20px;\n" +
                "\t\tcolor: red;\n" +
                "\t\t}\n" +
                "\t\t\t\t.class3 {\n" +
                "\t\tborder-radius: 10px;\n" +
                "\t\tcolor: white;\n" +
                "\t\ttransition: .2s linear;\n" +
                "\t\tbackground: #0B63F6;\n" +
                "\t\t}\n" +
                "\n" +
                "\t\t\t\t.class3:hover  {\n" +
                "\t\tbox-shadow: 0 0 0 2px white, 0 0 0 4px #3C82F8;\n" +
                "\t\t}\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "\t<form action=\""+ req.getContextPath() + "/vote\" method=\"POST\">\n" +
                "\n" +
                "\t<p class=\"class1\">Выберите исполнителя:</p>\n" +
                "\t<select class=\"class2\" name=\"artist\">\n" +
                "\t\t<option>Asti</option>\n" +
                "\t\t<option>Билан</option>\n" +
                "\t\t<option>Пугачева</option>\n" +
                "    </select>\n" +
                "\t\n" +
                "\t<p class=\"class1\">Выберите жанры:</p>\t\n" +
                "\t\t<input type=\"checkbox\" name=\"genre\" value=\"Хип-хоп\"><span>Хип-хоп</span><br>\n" +
                "\t\t<input type=\"checkbox\" name=\"genre\" value=\"Инструментал\"><span>Инструментал</span><br>\n" +
                "\t\t<input type=\"checkbox\" name=\"genre\" value=\"POP\"><span>POP</span><br>\n" +
                "\n" +
                "\t<p class=\"class1\">О себе:</p>\t\n" +
                "\t<textarea name=\"about\"></textarea>\n" +
                "\t\n" +
                "\t<br><br><br>\n" +
                "\t\n" +
                "\t<input class=\"class3\" type=\"submit\" value=\"Результат голосования\">\n" +
                "\t\n" +
                "\t</form>\n" +
                " </body> \n" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        String artist = req.getParameter("artist");
        String[] genre = req.getParameterValues("genre");
        String about = req.getParameter("about");

        PrintWriter writer = resp.getWriter();
        try {
            voteService.create(new VoteDTO(artist, genre, about));
        } catch (IllegalArgumentException e) {
            writer.write("<p>error: " + e.getMessage() + "</p>");
        }
    }
}
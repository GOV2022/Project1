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
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/vote")
public class VoteServlet extends HttpServlet {

    private final static IVoteService voteService = VoteService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        List<String> dataArtist = new ArrayList<>();
        dataArtist.add("Asti");
        dataArtist.add("Билан");
        dataArtist.add("Пугачева");


        List<String> dataGenre = new ArrayList<>();
        dataGenre.add("Хип-хоп");
        dataGenre.add("Инструментал");
        dataGenre.add("POP");

        req.setAttribute("artists", dataArtist);
        req.setAttribute("genres", dataGenre);
        req.getRequestDispatcher("/template/index.jsp").forward(req, resp);
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
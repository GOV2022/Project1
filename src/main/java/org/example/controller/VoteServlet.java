package org.example.controller;

import org.example.dto.VoteDTO;
import org.example.service.ArtistService;
import org.example.service.VoteService;
import org.example.service.api.IArtistService;
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

    private static IVoteService voteService = VoteService.getInstance();
    private static IArtistService artistService = ArtistService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {

        List<String> dataGenre = new ArrayList<>();
        dataGenre.add("Хип-хоп");
        dataGenre.add("Инструментал");
        dataGenre.add("POP");

        req.setAttribute("artists", artistService.get());
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
package org.example.controllers;

import org.example.dto.VoteDTO;
import org.example.services.VoteService;
import org.example.services.api.IVoteService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet(urlPatterns = "/vote")
public class VoteServlet extends HttpServlet {

    private final static IVoteService voteService = VoteService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {
        String body = new String(req.getInputStream().readAllBytes(),
                StandardCharsets.UTF_8);
        String[] split = body.split(";");

        String artist = split[0];
        String[] genre = split[1].split(",");
        String about = split[2];

        PrintWriter writer = resp.getWriter();
        try {
            voteService.create(new VoteDTO(artist, genre, about));
        } catch (IllegalArgumentException e) {
            writer.write("{'error': " + e.getMessage() + "}");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        String artist = req.getParameter("artist");
        String[] genre = req.getParameterValues("genre");
        String about = req.getParameter("about");

        PrintWriter writer = resp.getWriter();
        try {
            voteService.create(new VoteDTO(artist, genre, about));
        } catch (IllegalArgumentException e) {
            writer.write("<p>error': " + e.getMessage() + "</p>");
        }
    }
}
package org.example.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.service.ArtistService;
import org.example.service.api.IArtistService;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/artist")
public class ArtistServlet extends HttpServlet {
    private final static IArtistService artistService = ArtistService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {

        req.setAttribute("artists", artistService.get());
        req.getRequestDispatcher("/template/artist.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {
        String artist = req.getParameter("artistName");

        PrintWriter writer = resp.getWriter();
        try {
            artistService.create(artist);
        } catch (IllegalArgumentException e) {
            writer.write("<p>error: " + e.getMessage() + "</p>");
        }
    }
}

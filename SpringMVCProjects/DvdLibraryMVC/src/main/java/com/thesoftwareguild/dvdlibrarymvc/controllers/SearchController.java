package com.thesoftwareguild.dvdlibrarymvc.controllers;

import com.thesoftwareguild.dvdlibrarymvc.daos.DvdLibraryDao;
import com.thesoftwareguild.dvdlibrarymvc.models.Dvd;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping({"/search"})
public class SearchController {

    private DvdLibraryDao dDao;

    @Inject
    public SearchController(DvdLibraryDao dao) {
        this.dDao = dao;
    }


    @RequestMapping(value = "/title", method = RequestMethod.GET)
    public String searchTitle(Model model) {

        List<Dvd> dvds = dDao.list();

        model.addAttribute("dvds", dvds);

        return "searchTitle";

    }

    @RequestMapping(value = "/title/results", method = RequestMethod.POST)
    public String searchTitle(@RequestParam("title") String title, Model model) {

        List<Dvd> results = dDao.searchByTitle(title);

        model.addAttribute("results", results);
        model.addAttribute("path", "title");

        return "searchResult";

    }

    @RequestMapping(value = "/year", method = RequestMethod.GET)
    public String searchYear(Model model) {

        List<Dvd> dvds = dDao.list();

        model.addAttribute("dvds", dvds);

        return "searchYear";

    }

    @RequestMapping(value = "/year/results", method = RequestMethod.POST)
    public String searchYear(@RequestParam("year") Integer year, Model model) {

        List<Dvd> results = dDao.searchNewerThanYear(year);

        model.addAttribute("results", results);
        model.addAttribute("path", "year");

        return "searchResult";

    }

    @RequestMapping(value = "/rating", method = RequestMethod.GET)
    public String searchRating(Model model) {

        List<Dvd> dvds = dDao.list();

        model.addAttribute("dvds", dvds);

        return "searchRating";

    }

    @RequestMapping(value = "/rating/results", method = RequestMethod.POST)
    public String searchRating(@RequestParam("rating") String rating, Model model) {

        List<Dvd> results = dDao.searchByMpaaRating(rating);

        model.addAttribute("results", results);
        model.addAttribute("path", "rating");

        return "searchResult";

    }

    @RequestMapping(value = "/director", method = RequestMethod.GET)
    public String searchDirector(Model model) {

        List<Dvd> dvds = dDao.list();

        model.addAttribute("dvds", dvds);

        return "searchDirector";

    }

    @RequestMapping(value = "/director/results", method = RequestMethod.POST)
    public String searchDirector(@RequestParam("director") String director, Model model) {

        List<Dvd> results = dDao.searchByDirector(director);

        model.addAttribute("results", results);
        model.addAttribute("path", "director");

        return "searchResult";

    }

    @RequestMapping(value = "/studio", method = RequestMethod.GET)
    public String searchStudio(Model model) {

        List<Dvd> dvds = dDao.list();

        model.addAttribute("dvds", dvds);

        return "searchStudio";

    }

    @RequestMapping(value = "/studio/results", method = RequestMethod.POST)
    public String searchStudio(@RequestParam("studio") String studio, Model model) {

        List<Dvd> results = dDao.searchByStudio(studio);

        model.addAttribute("results", results);
        model.addAttribute("path", "studio");

        return "searchResult";

    }

}

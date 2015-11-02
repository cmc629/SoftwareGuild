package com.thesoftwareguild.dvdlibrarymvc.controllers;

import com.thesoftwareguild.dvdlibrarymvc.daos.DvdLibraryDao;
import com.thesoftwareguild.dvdlibrarymvc.daos.NoteDao;
import com.thesoftwareguild.dvdlibrarymvc.models.Dvd;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
        
    private DvdLibraryDao dDao;
    private NoteDao nDao;
    
    @Inject
    public HomeController(DvdLibraryDao dDao, NoteDao nDao) {
        this.dDao = dDao;
        this.nDao = nDao;
    }
    
    @RequestMapping(value="/")
    public String index(Model model) {
        
        List<Dvd> dvds = dDao.list();
        
        model.addAttribute("dvds", dvds);
        
        return "index";
    }
}

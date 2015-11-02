package com.thesoftwareguild.bodyshop.controllers;

import com.thesoftwareguild.bodyshop.daos.BlogEntryDao;
import com.thesoftwareguild.bodyshop.daos.EntryCategoryDao;
import com.thesoftwareguild.bodyshop.daos.HashtagDao;
import com.thesoftwareguild.bodyshop.daos.UserDao;
import com.thesoftwareguild.bodyshop.dtos.BlogEntry;
import com.thesoftwareguild.bodyshop.dtos.Hashtag;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Aaron Alahverde
 */
@Controller
@RequestMapping({"/manageBlogEntries"})
public class AdminBlogController {

    private final BlogEntryDao bDao;
    private final EntryCategoryDao eDao;
    private final HashtagDao hDao;
    private final UserDao uDao;

    @Inject
    public AdminBlogController(BlogEntryDao bDao, EntryCategoryDao eDao,
            HashtagDao hDao, UserDao uDao) {
        this.bDao = bDao;
        this.eDao = eDao;
        this.hDao = hDao;
        this.uDao = uDao;
    }

    ///////////////////////// For Blog Content(Title&Body)///////////////////////////////////
    @RequestMapping(value = "/manageBlog", method = RequestMethod.GET)
    public String index() {
        return "manageBlog";
    }

    @RequestMapping(value = "/manageBlog", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public BlogEntry createBlogEntry(@Valid @RequestBody BlogEntry blogEntry) {
        return bDao.addEntry(blogEntry);
    }

    @RequestMapping(value = "/manageBlog/{id}", method = RequestMethod.GET)
    @ResponseBody
    public BlogEntry getBlogEntry(@PathVariable("id") Integer id) {
        return bDao.getEntry(id);
    }

    @RequestMapping(value = "manageBlog/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteBlogEntry(@PathVariable("id") Integer id) {
        bDao.deleteEntry(id);
    }

    @RequestMapping(value = "managBlog/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBlogEntry(@PathVariable("id") Integer id,
            @RequestBody BlogEntry blog) {
        blog.setEntryId(id);
        bDao.updateEntry(blog);
    }

    @RequestMapping(value = "/manageBlog/allPosts", method = RequestMethod.GET)
    @ResponseBody
    public List<BlogEntry> getAllBlogEntries() {
        return bDao.list();
    }

  ///////////////////////////For Entry Dates////////////////////////////////////
    //SETTERS(CREATION) and GETTERS(EDIT) for BlogEntry Dates
    @RequestMapping(value = "/manageBlog/{id}/dateCreated", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public void setDateCreated(@PathVariable("id") Integer id, Date date) {
        bDao.getEntry(id).setDateCreated(date);
    }

    @RequestMapping(value = "/manageBlog/{id}/dateCreated", method = RequestMethod.GET)
    @ResponseBody
    public Date getDateCreated(@PathVariable("id") Integer id) {
        return bDao.getEntry(id).getDateCreated();
    }

    @RequestMapping(value = "/manageBlog/{id}/dateExpired", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public void setDateExpired(@PathVariable("id") Integer id, Date date) {
        bDao.getEntry(id).setDateExpired(date);
    }

    @RequestMapping(value = "/manageBlog/{id}/dateExpired", method = RequestMethod.GET)
    @ResponseBody
    public Date getDateExpired(@PathVariable("id") Integer id) {
        return bDao.getEntry(id).getDateExpired();
    }

    //Display BlogEntries by Date
    @RequestMapping(value = "/manageBlog/allAfter/{date}", method = RequestMethod.GET)
    @ResponseBody
    public List<BlogEntry> getAfterDate(@PathVariable("date") Date date) {
        return bDao.searchAfterDate(date);
    }

    //List sorted BlogEntries by Date
    @RequestMapping(value = "/manageBlog/ascending", method = RequestMethod.GET)
    @ResponseBody
    public List<BlogEntry> getBlogsByDateAscending() {
        return bDao.sortByNewestEntry();
    }

    @RequestMapping(value = "/manageBlog/descending", method = RequestMethod.GET)
    @ResponseBody
    public List<BlogEntry> getBlogsByDateDescending() {
        return bDao.sortByOldestEntry();
    }

    ///////////////////////////For Hashtags//////////////////////////////////////
    @RequestMapping(value = "/manageBlog/byHashtag/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<BlogEntry> getBlogsByHashtag(@PathVariable("id") Integer id) {
        return bDao.searchByHashtagId(id);
    }

    @RequestMapping(value = "manageBlog/{id}/hashtags", method = RequestMethod.GET)
    @ResponseBody
    public List<Hashtag> listHashtagsForBlogEntry(@PathVariable("id") Integer id) {
        return bDao.getEntry(id).getHashtags();
    }

    @RequestMapping(value = "manageBlog/{blogId}/hashtags/{hashId}", method = RequestMethod.DELETE)
    public void deleteHashtagFromEntry(@PathVariable("blogId") Integer blogId,
            @PathVariable("hashId") Integer hashId) {
        Hashtag hashtag = hDao.getHashtag(hashId);
        getBlogEntry(blogId).getHashtags().remove(hashtag);
    }

    //////////////////////////////For Entry Categories////////////////////////////
    @RequestMapping(value = "/manageBlog/{id}/blogEntryCategory", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void addCategoryToEntry(@PathVariable("id") Integer id) {
        bDao.getEntry(id).setCategory(eDao.getEntryCategory(id));
    }

    @RequestMapping(value = "/manageBlog/{id}/blogEntryCategory", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void removeCategoryFromEntry(@PathVariable("id") Integer id) {
        bDao.getEntry(id).setCategory(null);
    }

    @RequestMapping(value = "/manageBlog/byCategory/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<BlogEntry> getBlogByCategory(@PathVariable("id") Integer id) {
        List<BlogEntry> categorizedBlogs = new ArrayList<>();
        bDao.list().stream().filter((blog) -> (blog.getCategory()
                .getEntryCategoryId().equals(id))).forEach((blog) -> {
                    categorizedBlogs.add(blog);
                });
        return categorizedBlogs;
    }

}

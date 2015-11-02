/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.bodyshop.daos;

import com.thesoftwareguild.bodyshop.dtos.Comment;
import com.thesoftwareguild.bodyshop.dtos.Hashtag;
import java.util.List;

/**
 *
 * @author Chris Myung
 */
public interface CommentDao {
    
    public Comment addComment(Comment comment);
    public void updateComment(Comment comment);
    public Comment getComment(Integer commentId);
    public void deleteComment(Integer commentId);
    public List<Comment> listAllComments();
    public List<Comment> commentListByEntry(Integer entryId);
    public List<Comment> searchByHashTagId(Integer hashtagId);
    
}

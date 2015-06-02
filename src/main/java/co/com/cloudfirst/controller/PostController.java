/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.cloudfirst.controller;

import co.com.cloudfirst.domain.Post;
import co.com.cloudfirst.service.PostService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Carlos
 */
@RestController
public class PostController {
    
    @Autowired
    private PostService postService;

    @RequestMapping(value = "/post", method = RequestMethod.GET)
    public @ResponseBody
    List<Post> findAll() {
        return postService.findAll();
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public ResponseEntity<String> save(@RequestParam("title") String title, @RequestParam("body") String body) {
        String newPostId = postService.save(new Post(title,body));
        return new ResponseEntity<String>(newPostId, HttpStatus.CREATED);
    }
}

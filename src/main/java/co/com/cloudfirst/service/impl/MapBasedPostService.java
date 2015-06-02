/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.cloudfirst.service.impl;

import co.com.cloudfirst.domain.Post;
import co.com.cloudfirst.service.PostService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Service;

/**
 *
 * @author Carlos
 */
@Service
public class MapBasedPostService implements PostService {
    private Map<String,Post> database;

    public MapBasedPostService() {
        database = new ConcurrentHashMap<String,Post>();
    }
    
    
    
    @Override
    public String save(Post post) {
        String id = UUID.randomUUID().toString();
        post.setId(id);
        database.put(id, post);
        return id;
    }

    @Override
    public List<Post> findAll() {
        return new ArrayList<Post>(database.values());
    } 

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.cloudfirst.service;

import co.com.cloudfirst.domain.Post;
import java.util.List;

/**
 *
 * @author Carlos
 */
public interface PostService {
    String save(Post post);
    
    List<Post> findAll();
}

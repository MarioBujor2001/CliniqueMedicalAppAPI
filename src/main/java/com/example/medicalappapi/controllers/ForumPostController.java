package com.example.medicalappapi.controllers;

import com.example.medicalappapi.models.ForumPost;
import com.example.medicalappapi.models.exception.RepoSaveException;
import com.example.medicalappapi.services.ForumPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/forum-posts")
public class ForumPostController {
    @Autowired
    ForumPostService forumPostService;
    @GetMapping
    public ResponseEntity<Iterable<ForumPost>> getPosts(){
        return ResponseEntity.ok(this.forumPostService.findAll());
    }

    @PostMapping
    public ResponseEntity<ForumPost> addForumPost(@RequestBody ForumPost forumPost) throws RepoSaveException {
        ForumPost fp = this.forumPostService.save(forumPost);
        if(fp!=null){
            URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(fp.getId())
                    .toUri();
            return ResponseEntity.created(uri).body(fp);
        }
        throw new RepoSaveException();
    }
}

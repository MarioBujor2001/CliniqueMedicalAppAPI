package com.example.medicalappapi.services;

import com.example.medicalappapi.models.ForumPost;
import com.example.medicalappapi.repositories.ForumPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ForumPostService {
    @Autowired
    ForumPostRepo forumPostRepo;

    public Iterable<ForumPost> findAll(){
        return this.forumPostRepo.findAll();
    }

    public ForumPost save(ForumPost forumPost) {
        return this.forumPostRepo.save(forumPost);
    }
}

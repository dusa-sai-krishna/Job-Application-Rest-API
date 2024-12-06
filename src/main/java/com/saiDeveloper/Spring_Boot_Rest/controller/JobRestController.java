package com.saiDeveloper.Spring_Boot_Rest.controller;

import com.saiDeveloper.Spring_Boot_Rest.model.JobPost;
import com.saiDeveloper.Spring_Boot_Rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class JobRestController {

    @Autowired
    private JobService js;

    @GetMapping("jobPosts")
    public List<JobPost> getAllJobs(){
        return js.findAll();
    }

    @GetMapping(path="jobPost/{postId}",produces = {"application/json"})
    public JobPost getJob(@PathVariable("postId") int postId){
        return js.getJob(postId);
    }

    @GetMapping("/load")
    public String load(){
        js.load();
        return "Initial Jobs are loaded";
    }

    @GetMapping("/jobPosts/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword){
        return js.searchByKeyword(keyword);
    }



    @PostMapping("/jobPost")
    public JobPost addJob(@RequestBody JobPost jobPost){
        js.save(jobPost);
        return js.getJob(jobPost.getPostId());
    }

    @PutMapping(path="/jobPost",consumes = {"application/json"})
    public JobPost updateJob(@RequestBody JobPost jobPost){
        js.updateJob(jobPost);
        return js.getJob(jobPost.getPostId());
    }

    @DeleteMapping("/jobPost/{postId}")
    public String deleteJob(@PathVariable("postId") int postId){
        js.deleteJob(postId);
        return "Job Deleted";
    }





}

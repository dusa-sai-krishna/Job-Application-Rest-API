package com.saiDeveloper.Spring_Boot_Rest.repo;


import com.saiDeveloper.Spring_Boot_Rest.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobRepo extends JpaRepository<JobPost,Integer> {

    @Query("select jp from JobPost jp Where jp.postProfile Like %?1%  Or jp.postDesc Like %?1% ")
    List<JobPost> searchByKeyword(String keyword);
}

package com.saiDeveloper.Spring_Boot_Rest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;



@Component
@Scope("prototype")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class JobPost {

	@Id
    private int postId;
	private String postProfile;
	private String postDesc;
	private int reqExperience;
	private List<String> postTechStack;


}

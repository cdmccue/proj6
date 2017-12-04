package edu.usm.cos375.springboot.controller;

import edu.usm.cos375.springboot.entity.Discussion;
import org.springframework.data.repository.CrudRepository;


//public interface DiscussionRepository extends GenericRepository<Long, Discussion>
//{
//	
//}

public interface DiscussionRepository extends CrudRepository<Discussion, Long> {
	
}
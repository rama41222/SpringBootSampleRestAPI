package com.rama41222.CourseAPIApp.topics;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Topics {

	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics(){
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}")
	public Topic getTopicById(@PathVariable("id") String id){
		return topicService.getTopic(id);
	}
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public String addTopic(@RequestBody Topic topic){
		if(topicService.addTopic(topic)){
			return "Sucess";
		}else{
			return "Failed to add a new Topic";
		}
	}
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{id}")
	public String updateTopic(@PathVariable("id") String id, @RequestBody Topic topic){
		if(topicService.updateTopic(id, topic)){
			return "Update Success!";
		}
		return "Update failed";
	}
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	public String deleteTopic(@PathVariable("id") String id){
		
		if(topicService.deleteTopic(id)){
			return "Topic Deleted Success";
		}
		return "Delete Failed";
	}
}

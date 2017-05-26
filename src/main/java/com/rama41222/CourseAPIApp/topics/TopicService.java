package com.rama41222.CourseAPIApp.topics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("t1","Maths","Basic Mathematics"),
			new Topic("t2","Science","Basic Science"),
			new Topic("t3","History","Introduction to Roman Civilization"),
			new Topic("t4","Greek","Let's Speak Greek"),
			new Topic("t5","Russian","Basic Russian course for starters")
			));
	
	public List<Topic> getAllTopics(){
		return topics;
	}
	
	public Topic getTopic(String id){
		return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
	} 
	
	public boolean addTopic(Topic t){
		return topics.add(t);
	} 
	
    public boolean updateTopic(String id,Topic t){
    	System.out.println(id);
    	System.out.println(t.getName());
    	Topic t1 = getTopic(id);
    	int index = topics.indexOf(t1);
    	if(t != null && index >= 0){
    		topics.set(index, t);
    		return true;
    	}
		return false;
	} 
    
    public boolean deleteTopic(String id){
    	if(topics.removeIf(t->t.getId().equals(id))){
    		return true;
    	}
    	return false;
    }
	
	public boolean removeTopic(String id){
		return topics.remove(topics.stream().filter(t->t.getId().equals(id)).findFirst().get());
	} 
}

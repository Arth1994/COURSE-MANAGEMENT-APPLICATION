package io.arthshahcodingpractice.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;

	/*
	 * private List<Course> result = new ArrayList<>( Arrays.asList(new
	 * Course("Spring", "Java", "REST API"), new Course("Kafka", "Backend",
	 * "SDE BACKEND"), new Course("ReactJS", "Javascript",
	 * "FULL STACK DEVELOPMENT")));
	 */

	public List<Topic> getAllTopics() {
		// return result;
		List<Topic> result = new ArrayList<>();
		for (Topic topic : topicRepository.findAll())
			result.add(topic);
		return result;
	}

	public Topic getTopic(@PathVariable String id) {
		/*
		 * for (Course t : result) { if (t.getId().equals(id)) { return t; } }
		 */
		/*
		 * Lambda Shorthand result.stream().filter(t ->
		 * t.getId().equals(id)).findFirst().get();
		 */
		return topicRepository.findOne(id);
	}

	public void addTopic(Topic topic) {
		// result.add(topic);
		topicRepository.save(topic);
	}

	public void updateTopic(Topic topic, String id) {
		// TODO Auto-generated method stub
//		for (int i = 0; i < result.size(); i++) {
//			if (result.get(i).getId().equals(id)) {
//				result.set(i, topic);
//				return;
//			}
//		}
		if (topicRepository.save(topic) == null)
			return;
		topicRepository.save(topic);
	}

	public void deleteTopic(String id) {
		// TODO Auto-generated method stub
		/*
		 * for(int i = 0; i < result.size(); i++) { if(result.get(i).getId().equals(id))
		 * result.remove(i); }
		 */
		topicRepository.delete(id);
	}

}

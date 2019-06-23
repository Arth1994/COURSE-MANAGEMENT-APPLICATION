package io.arthshahcodingpractice.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

	/*
	 * private List<Course> result = new ArrayList<>( Arrays.asList(new
	 * Course("Spring", "Java", "REST API"), new Course("Kafka", "Backend",
	 * "SDE BACKEND"), new Course("ReactJS", "Javascript",
	 * "FULL STACK DEVELOPMENT")));
	 */

	public List<Course> getAllCourses(String topicId) {
		// return result;
		List<Course> result = new ArrayList<>();
		for (Course course : courseRepository.findByTopicId(topicId))
			result.add(course);
		return result;
	}

	public Course getCourse(@PathVariable String id) {
		/*
		 * for (Course t : result) { if (t.getId().equals(id)) { return t; } }
		 */
		/*
		 * Lambda Shorthand result.stream().filter(t ->
		 * t.getId().equals(id)).findFirst().get();
		 */
		return courseRepository.findOne(id);
	}

	public void addCourse(Course course) {
		// result.add(topic);
		courseRepository.save(course);
	}

	public void updateCourse(Course course) {
		// TODO Auto-generated method stub
//		for (int i = 0; i < result.size(); i++) {
//			if (result.get(i).getId().equals(id)) {
//				result.set(i, topic);
//				return;
//			}
//		}
		if (courseRepository.save(course) == null)
			return;
		courseRepository.save(course);
	}

	public void deleteCourse(String id) {
		// TODO Auto-generated method stub
		/*
		 * for(int i = 0; i < result.size(); i++) { if(result.get(i).getId().equals(id))
		 * result.remove(i); }
		 */
		courseRepository.delete(id);
	}

}

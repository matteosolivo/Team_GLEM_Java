package it.university.repository;

import it.university.model.Course;

public class CourseRepository extends AbstractRepository<Course, Integer> {

    @Override
    public Integer getItemId(Course course) {
        return course.getId();
    }
}

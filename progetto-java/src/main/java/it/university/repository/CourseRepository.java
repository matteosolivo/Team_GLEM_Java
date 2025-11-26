package it.university.repository;

import it.university.model.Course;

public class CourseRepository extends AbstractRepository<Course, Integer> {

    @Override
    protected Integer extractId(Course course) {
        return course.getId();
    }
}

package it.university.repository;

import it.university.model.Course;

public class CourseRepository extends AbstractRepository<Course> {

    @Override
    public int getItemId(Course course) {
        return course.getId();
    }
}

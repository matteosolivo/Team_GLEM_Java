package it.university.repository;

import it.university.model.Course;

public class CourseRepository extends AbstractRepository<Course, Integer> {

    // OTTIENE L'ID UNIVOCO DEL CORSO (Integer Id)
    @Override
    public Integer getItemId(Course course) {
        return course.getId();
    }
}

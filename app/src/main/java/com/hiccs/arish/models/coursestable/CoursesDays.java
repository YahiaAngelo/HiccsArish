package com.hiccs.arish.models.coursestable;

/**
 * Created by AbdullahAtta on 2/28/2019.
 */
public class CoursesDays {
    private CourseTime[] courseTimes;
    private String dayName;

    public CoursesDays(CourseTime[] courseTimes, String dayName) {
        this.courseTimes = courseTimes;
        this.dayName = dayName;
    }

    public CourseTime[] getCourseTimes() {
        return courseTimes;
    }

    public void setCourseTimes(CourseTime[] courseTimes) {
        this.courseTimes = courseTimes;
    }

    public CourseTime getCourseTime(int position) {
        return courseTimes[position];
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }
}

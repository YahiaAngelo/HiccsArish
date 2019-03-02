package com.hiccs.arish.models.coursestable;

/**
 * Created by AbdullahAtta on 2/28/2019.
 */
public class CourseTime {
    private boolean isInDay;
    private String courseName;
    private String profName;
    private String courseDuration;

    public CourseTime(boolean isInDay, String courseName, String profName, String courseDuration) {
        this.isInDay = isInDay;
        this.courseName = courseName;
        this.profName = profName;
        this.courseDuration = courseDuration;
    }

    public boolean isInDay() {
        return isInDay;
    }

    public void setInDay(boolean inDay) {
        isInDay = inDay;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getProfName() {
        return profName;
    }

    public void setProfName(String profName) {
        this.profName = profName;
    }

    public String getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(String courseDuration) {
        this.courseDuration = courseDuration;
    }
}

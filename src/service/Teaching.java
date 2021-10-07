package service;

import entity.Subject;
import entity.Teacher;

import java.util.Arrays;

public class Teaching {
    private Teacher teacher;
    private Subject[] subjects;
    private int[] totalClass;
    private int allLesson;

    public Teaching() {
    }

    public Teaching(Teacher teacher, Subject[] subjects, int[] totalClass) {
        this.teacher = teacher;
        this.subjects = subjects;
        this.totalClass = totalClass;
    }

    public int getAllLesson() {
        return allLesson;
    }

    public void setAllLesson(int allLesson) {
        this.allLesson = allLesson;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Subject[] getSubjects() {
        return subjects;
    }

    public void setSubjects(Subject[] subjects) {
        this.subjects = subjects;
    }

    public int[] getTotalClass() {
        return totalClass;
    }

    public void setTotalClass(int[] totalClass) {
        this.totalClass = totalClass;
    }

    @Override
    public String toString() {
        return "Teaching{" +
                "teacher=" + teacher +
                ", subjects=" + Arrays.toString(subjects) +
                ", totalClass=" + Arrays.toString(totalClass) +
                ", allLesson=" + allLesson +
                '}';
    }
}

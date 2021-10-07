package entity;

import java.util.Scanner;

public class Subject {
    private int id;
    private String name;
    private int lessonTotal;
    private int theoryLesson;
    private float expense;

    private static int AUTO_ID = 100;

    public Subject() {
    }

    public Subject(int id, String name, int lessonTotal, int theoryLesson, float expense) {
        this.id = id;
        this.name = name;
        this.lessonTotal = lessonTotal;
        this.theoryLesson = theoryLesson;
        this.expense = expense;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLessonTotal() {
        return lessonTotal;
    }

    public void setLessonTotal(int lessonTotal) {
        this.lessonTotal = lessonTotal;
    }

    public int getTheoryLesson() {
        return theoryLesson;
    }

    public void setTheoryLesson(int theoryLesson) {
        this.theoryLesson = theoryLesson;
    }

    public float getExpense() {
        return expense;
    }

    public void setExpense(float expense) {
        this.expense = expense;
    }

    public void informSubjectInfo() {
        this.setId(Subject.AUTO_ID);

        System.out.println("Nhập tên môn học: ");
        this.name = new Scanner(System.in).nextLine();
        boolean check = true;
        System.out.println("Nhập tổng số tiết học: ");
        do {
            this.lessonTotal = new Scanner(System.in).nextInt();
            if (this.lessonTotal <= 0) {
                System.out.print("Tổng số tiết lớn hơn 0! Nhập lại: ");
                check = false;
            }
        } while (!check);
        System.out.println("Nhập số tiết lý thuyết: ");
        do {
            this.theoryLesson = new Scanner(System.in).nextInt();
            if (this.theoryLesson <= 0) {
                System.out.print("Số tiết lý thuyết lớn hơn 0! Nhập lại: ");
                check = false;
            }
        } while (!check);
        System.out.println("Nhập mức kinh phí (lý thuyết): ");
        do {
            this.expense = new Scanner(System.in).nextInt();
            if (this.expense <= 0) {
                System.out.print("Mức kinh phí lớn hơn 0! Nhập lại: ");
                check = false;
            }
        } while (!check);
        Subject.AUTO_ID++;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lessonTotal=" + lessonTotal +
                ", theoryLesson=" + theoryLesson +
                ", expense=" + expense +
                '}';
    }
}

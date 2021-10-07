package entity;

import java.util.Scanner;

public class Teacher extends Person{
    private int id;
    private String level;
    private float salary;

    private final static String GS_TS = "Giáo sư - tiến sĩ";
    private final static String PGS_TS = "Phó giáo sư - tiến sĩ";
    private final static String Main_Lecture = "Giảng viên chính";
    private final static String TH_S = "Thạc sĩ";

    private static int AUTO_ID = 100;

    public Teacher() {
    }

    public Teacher(int id, String level) {
        this.id = id;
        this.level = level;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public static String getGsTs() {
        return GS_TS;
    }

    public static String getPgsTs() {
        return PGS_TS;
    }

    public static String getMain_Lecture() {
        return Main_Lecture;
    }

    public static String getThS() {
        return TH_S;
    }

    public static int getAutoId() {
        return AUTO_ID;
    }

    public static void setAutoId(int autoId) {
        AUTO_ID = autoId;
    }

    public void inputInfo(){
        this.setId(Teacher.AUTO_ID);
        super.inputInfo();
        System.out.println("Nhập trình độ giảng viên: ");
        System.out.println("1.Giáo sư - Tiến sĩ");
        System.out.println("2.Phó giáo sư - Tiến sĩ");
        System.out.println("3.Giảng viên chính");
        System.out.println("4.Thạc sĩ");
        System.out.println("Nhập sự lựa chọn của bạn: ");
        boolean check = true;
        do {
            int choice = new Scanner(System.in).nextInt();
            if (choice <= 0 || choice > 4) {
                System.out.print("Nhập số trong khoảng từ 1 đến 4! Nhập lại: ");
                check = false;
                continue;
            }
            switch (choice) {
                case 1:
                    this.setLevel(Teacher.GS_TS);
                    System.out.println("Giáo sư - Tiến sĩ");
                    check = true;
                    break;
                case 2:
                    this.setLevel(Teacher.PGS_TS);
                    System.out.println("Phó giáo sư - Tiến sĩ");
                    check = true;
                    break;
                case 3:
                    this.setLevel(Teacher.Main_Lecture);
                    System.out.println("Giảng viên chính");
                    check = true;
                    break;
                case 4:
                    this.setLevel(Teacher.TH_S);
                    System.out.println("Thạc sĩ");
                    check = true;
                    break;
                default:
                    System.out.println("Nhập sai! Hãy nhập từ 1 đến 4!");
                    check = false;
                    break;
            }
        } while (!check);
        Teacher.AUTO_ID++;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", level='" + level + '\'' +
                '}';
    }
}

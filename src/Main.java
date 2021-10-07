import entity.Subject;
import entity.Teacher;
import service.Teaching;

import java.util.Scanner;

public class Main {
    private static int countTeacher;
    private static Teacher[] teachers;
    private static Subject[] subjects;
    private static Teaching[] teachings;

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        do {
            int functionChoice = functionChoice();
            switch (functionChoice) {
                case 1:
                    createNewSubject();
                    displaySubjects();
                    break;
                case 2:
                    createNewTeacher();
                    displayTeacher();
                    break;
                case 3:
                    teachingDeclaration();
                    displayTeachingDeclaration();
                    break;
                case 4:
                    sortteachingDeclaration();
                    break;
                case 5:
                    teacherIncome();
                    break;
                case 6:
                    System.exit(0);
            }

        } while (true);
    }

    private static void teacherIncome() {
        if (teachings == null || teachings.length == 0) {
            System.out.println("Nhập bảng chấm công trước khi sắp xếp");
            return;
        }
        for (Teaching teaching : teachings) {
            System.out.println("Tính tiền lương cho giảng viên " + teaching.getTeacher().getName());
            System.out.println(teaching.getTeacher().getSalary());
        }
    }

    private static void sortteachingDeclaration() {
        if (teachers == null || teachers.length == 0) {
            System.out.println("Nhập bảng chấm công trước khi sắp xếp");
            return;
        }
        do {
            System.out.println("------Sắp xếp danh sách chấm công---------");
            System.out.println("1.Theo tên giảng viên");
            System.out.println("2.Theo số tiết giảng dạy mỗi môn");
            System.out.println("3.Thoát");
            System.out.println("Nhập sự lựa chọn của bạn");
            int choice = 0;
            boolean checkChoice = true;
            do {
                try {
                    choice = new Scanner(System.in).nextInt();
                    checkChoice = true;
                } catch (Exception e) {
                    System.out.println("không được phép có ký tự khác ngoài ký tự số! Nhập lại");
                    checkChoice = false;
                    continue;
                }
                if (choice <= 0 || choice > 3) {
                    System.out.print("Nhập trong khoảng từ 1 đến 3! Nhập lại: ");
                    checkChoice = false;
                }
            } while (!checkChoice);
            switch (choice) {
                case 1:
                    sortByTeacherName();
                    break;
                case 2:
                    sortBySubjectLesson();
                    break;
                case 3:
                    return;
            }
        } while (true);
    }

    private static void sortBySubjectLesson() {
        for (int i=0; i< teachings.length;i++){
            for (int j=0; j < teachings[i].getSubjects().length;j++){
                for (int k=j+1; k<teachings[i].getSubjects().length;k++){
                    if (subjects[j].getLessonTotal()<subjects[k].getLessonTotal()){
                        Subject temp = subjects[j];
                        subjects[j] = subjects[k];
                        subjects[k] = temp;
                    }
                }
            }
            for (int l=i+1; l < teachings.length; l++){
                if (teachings[i].getAllLesson()<teachings[l].getAllLesson()){
                    Teaching temp = teachings[i];
                    teachings[i] = teachings[l];
                    teachings[l] = temp;
                }
            }
        }
        for (Teaching teaching : teachings) {
            System.out.println(teaching);
        }
    }

    private static void sortByTeacherName() {
        if (teachings == null || teachings.length == 0){
            System.out.println("Nhập bảng kê khai trước khi sắp xếp!");
            return;
        }
        for (int i = 0; i < teachings.length; i++) {
            for (int j = i + 1; j < teachings.length; j++) {
                if (teachings[i].getTeacher().getName().compareTo(teachings[j].getTeacher().getName()) > 0) {
                    Teaching temp = teachings[i];
                    teachings[i] = teachings[j];
                    teachings[j] = temp;
                }
            }
        }
        for (Teaching teaching : teachings) {
            System.out.println(teaching);
        }
    }

    private static void createNewTeacher() {
        System.out.println("Nhập số lượng giảng viên: ");
        countTeacher = new Scanner(System.in).nextInt();
        teachers = new Teacher[countTeacher];
        for (int i = 0; i < teachers.length; i++) {
            Teacher teacher = new Teacher();
            teacher.inputInfo();
            teachers[i] = teacher;
        }
    }

    private static void displayTeacher() {
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
    }

    private static void createNewSubject() {
        System.out.println("Nhập số lượng môn học: ");
        int countSubject = new Scanner(System.in).nextInt();
        subjects = new Subject[countSubject];
        for (int i = 0; i < subjects.length; i++) {
            Subject subject = new Subject();
            subject.informSubjectInfo();
            subjects[i] = subject;
        }
    }

    private static void displaySubjects() {
        for (Subject subject : subjects) {
            System.out.println(subject);
        }
    }

    public static boolean isValidSubjectAndTeacher() {
        return subjects != null && teachers != null && subjects.length != 0 && teachers.length != 0;
    }

    private static void teachingDeclaration() {
        if (!isValidSubjectAndTeacher()) {
            System.out.println("Bạn cần nhập giảng viên và môn học trước khi thống kê! ");
            return;
        }
        boolean check = true;
        teachings = new Teaching[countTeacher];
        int allSum;
        for (int i = 0; i < teachers.length; i++) {
            allSum = 0;
            System.out.println("Kê khai cho giảng viên " + teachers[i].getName());
            System.out.println("Nhập số môn học mà giảng viên " + teachers[i].getName() + " : ");
            int subjectNumber;
            do {
                subjectNumber = new Scanner(System.in).nextInt();
                if (subjectNumber <= 0 || subjectNumber > subjects.length) {
                    System.out.print("Số môn giảng viên dạy phải lớn hơn 0 và nhỏ hơn tổng số môn! Nhập lại: ");
                    check = false;
                }
            } while (!check);
            Subject[] subjectList = new Subject[subjectNumber];
            int[] totalClassArray = new int[subjectNumber];
            do {
                for (int j = 0; j < subjectNumber; j++) {
                    int sum = 0;
                    System.out.print("Nhập id môn thứ " + (j + 1) + " mà giảng viên " + teachers[i].getName() + " dạy: ");
                    int subjectId;
                    int totalClass = 0;
                    do {
                        subjectId = new Scanner(System.in).nextInt();
                        Subject subject = searchSubjectId(subjectId);
                        if (subject != null) {
                            System.out.println("Nhập số lớp của môn thứ " + (j + 1) + " mà giảng viên " + teachers[i].getName() + " dạy:");
                            do {
                                totalClass = new Scanner(System.in).nextInt();
                                if (totalClass <= 0 || totalClass > 3) {
                                    System.out.print("Số lớp dạy phải lớn hơn 0 và không lớn hơn 3! Nhập lại: ");
                                    check = false;
                                }
                            } while (!check);
                            sum += subjects[j].getLessonTotal() * totalClass;
                            if (sum > 200) {
                                System.out.println("Tổng số tiết học vượt quá 200! Nhập lại từ đầu cho giảng viên này nhé: ");
                                check = false;
                                break;
                            } else check = true;
                            int practice = subject.getLessonTotal() - subject.getTheoryLesson();
                            float salary = subject.getExpense()*subject.getTheoryLesson()+practice*subject.getExpense()*70/100;
                            teachers[j].setSalary(salary);
                            allSum += sum;
                            subjectList[j] = subject;
                            totalClassArray[j] = totalClass;
                            break;
                        } else System.out.print("Không có id môn học vừa nhập! Nhập lại: ");
                    } while (true);
                }
            } while (!check);
            Teaching teaching = new Teaching(teachers[i],subjectList, totalClassArray);
            teachings[i] = teaching;
            teachings[i].setAllLesson(allSum);
        }
    }


    private static void displayTeachingDeclaration() {
        for (Teaching teaching : teachings) {
            System.out.println(teaching);
        }
    }

    private static Subject searchSubjectId(int subjectId) {
        for (Subject subject : subjects) {
            if (subject.getId() == subjectId) {
                return subject;
            }
        }
        return null;
    }

    private static int functionChoice() {
        System.out.println("--------Quản lý trả lương cho giảng viên thỉnh giảng--------");
        System.out.println("1.Nhập danh sách môn học");
        System.out.println("2.Nhập danh sách giảng viên");
        System.out.println("3.Bảng kê khai giảng dạy");
        System.out.println("4.Sắp xếp bảng kê khai giảng dạy");
        System.out.println("5.Tính toán và lập bảng tính tiền công cho từng giảng viên");
        System.out.println("6.Thoát");
        int functionChoice;
        do {
            functionChoice = new Scanner(System.in).nextInt();
            if (functionChoice >= 1 && functionChoice <= 6) {
                break;
            }
            System.out.print("Chức năng chọn không hợp lệ, vui lòng chọn lại: ");
        } while (true);
        return functionChoice;
    }
}

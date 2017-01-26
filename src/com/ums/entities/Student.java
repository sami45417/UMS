package com.ums.entities;

import com.ums.buildings.AdminBlock;
import com.ums.buildings.IBA;
import com.ums.buildings.Pharmacy;
import com.ums.buildings.UBIT;
import com.ums.lists.CourseList;

import java.io.IOException;

public class Student extends AccountHolder {

    public CourseList courseList;
    String field;
    /**
     * Instance variables
     */
    private String department;
    private int semester, fee, attendance;
    private double cgpa;
    private int[] marks = new int[6];

    public Student() {
        super(null, null, null, Position.STUDENT, 0);

        this.department = null;
        this.field = null;
        this.semester = 0;
        this.fee = 0;
        this.attendance = 0;
        this.cgpa = 0;

        this.courseList = new CourseList();
    }

    /**
     * Parametrized constructor
     */
    public Student(String id, String name, String password, String department, String field,
                   int semester, int fee, int attendance,
                   double cgpa, int port) {
        super(id, name, password, Position.STUDENT, port);

        this.department = department;
        this.field = field;
        this.semester = semester;
        this.fee = fee;
        this.attendance = attendance;
        this.cgpa = cgpa;

        this.courseList = new CourseList();
    }

    /**
     * toString() method
     */
    public String toString() {
        return "\nID: " + this.id + "\nName: " + this.name + "\nDepartment: " + this.department + "\nField: " + this.field
                + "\nSemester Number: " + this.semester + "\nFee: " + this.fee + "\nAttendance: " + this.attendance + "%"
                + "\nGPA: " + this.cgpa;
    }

    public void setMarks(int n1, int n2, int n3, int n4, int n5, int n6) {
        this.marks[0] = n1;
        this.marks[1] = n2;
        this.marks[2] = n3;
        this.marks[3] = n4;
        this.marks[4] = n5;
        this.marks[5] = n5;
    }

    /**
     * Getters
     */
    public String getDepartment() {
        return department;
    }


    /**
     * Setters
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getPassword() {
        return password;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public double getCGPA() {
        return cgpa;
    }

    public void setCGPA(double cgpa) {
        this.cgpa = cgpa;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public int[] getMarks() {
        return marks;
    }

    public void setMarks(int[] marks) {
        this.marks = marks;
    }

    public CourseList getCourseList() {
        return courseList;
    }

    public void setCourseList(CourseList courseList) {
        this.courseList = courseList;
    }

    @Override
    public boolean login(String id, String password) {
        for (int i = 0; i < AdminBlock.studentList.students.size(); i++) {
            if ((AdminBlock.studentList.students.get(i).getID().equalsIgnoreCase(id))
                    && ((AdminBlock.studentList.students.get(i).getPassword().equals(password))))
                return true;
        }
        return false;
    }

    @Override
    public void changePassword(String pass) throws IOException {
        for (int i = 0; i < AdminBlock.studentList.students.size(); i++) {
            if (AdminBlock.studentList.students.get(i).getID().equalsIgnoreCase(this.getID())) {
                AdminBlock.studentList.students.get(i).setPassword(pass);
                AdminBlock.writeToAllFiles();
            }
        }
    }

    public String viewCourseList() {
        String info = "";
        if (this.getDepartment().equalsIgnoreCase("UBIT")) {
            for (int i = 0; i < UBIT.courseList.courses.size(); i++) {
                info += ("\n" + "ID: " + UBIT.courseList.courses.get(i).getID()
                        + "\t" + "Name: " + UBIT.courseList.courses.get(i).getName()
                        + "\t" + "Credit hours: " + UBIT.courseList.courses.get(i).getCreditHours()
                        + "\t" + "Field: " + UBIT.courseList.courses.get(i).getField());
            }

        } else if (this.getDepartment().equalsIgnoreCase("IBA")) {
            for (int i = 0; i < IBA.courseList.courses.size(); i++) {
                if ((IBA.courseList.courses.get(i).getField().equals("BBA"))
                        && (this.getField().equals("BBA")))
                    info += ("\n" + "ID: " + IBA.courseList.courses.get(i).getID()
                            + "\t" + "Name: " + IBA.courseList.courses.get(i).getName()
                            + "\t" + "Credit hours: " + IBA.courseList.courses.get(i).getCreditHours()
                            + "\t" + "Field: " + IBA.courseList.courses.get(i).getCreditHours());
            }
        } else {
            for (int i = 0; i < Pharmacy.courseList.courses.size(); i++)
                info += ("\n" + "ID: " + Pharmacy.courseList.courses.get(i).getID()
                        + "\t" + "Name: " + Pharmacy.courseList.courses.get(i).getName()
                        + "\t" + "Credit hours: " + Pharmacy.courseList.courses.get(i).getCreditHours()
                        + "\t" + "Field: " + Pharmacy.courseList.courses.get(i).getField());
        }

        return info;
    }

    public String generateMarksSheet() {
        String info = "";
        if (this.getDepartment().equals("UBIT")) {
            info += "\n\n\t\t\tMarks sheet for 1st semester.\n";
            info += "\nIntroduction to Computer Science: " + this.marks[0] + "\nIntroduction to Software Engineering: " + this.marks[1]
                    + "\nComputer Digital Organization and Logic Design: " + this.marks[2] + "\nEnglish: " + this.marks[3]
                    + "\nIslamiat: " + this.marks[4] + "\nCalculus: " + this.marks[5]
                    + "\n\nGPA: " + this.getCGPA();

            return info;
        } else if (this.getDepartment().equals("IBA") && this.getField().equals("BS (Computer Science)")) {
            info += "\n\n\t\t\tMarks sheet for 1st semester.\n";
            info += "\nCalculus and Analytical Geometry: " + this.marks[0] + "\nObject Oriented Programming: " + this.marks[1]
                    + "\nPhysics-I: " + this.marks[2] + "\nTechnical and Business Writing: " + this.marks[3]
                    + "\nEnglish Composition and Comprehension: " + this.marks[4] + "\nStatistics and Probability: " + this.marks[5]
                    + "\n\nGPA: " + this.getCGPA();

            return info;
        } else if (this.getDepartment().equals("IBA") && this.getField().equals("BBA")) {
            info += "\n\n\t\t\tMarks sheet for 1st semester.\n";
            info += "\nIntroduction to Accounting: " + this.marks[0] + "\nEnglish Writing Skills: " + this.marks[1]
                    + "\nMicroeconomics: " + this.marks[2] + "\nIT in Business: " + this.marks[3]
                    + "\nIslamiat and Pakistan Studies/Humanities: " + this.marks[4] + "\nFinancial Accounting\n: " + this.marks[5]
                    + "\n\nGPA: " + this.getCGPA();

            return info;
        } else {
            info += "\n\n\t\t\tMarks sheet for 1st semester.\n";
            info += "\nIslamic Idealogy-Pakistan Studies: " + this.marks[0] + "\nPharmaceutical Biochemistry I: " + this.marks[1]
                    + "\nPhysiology & Histology I: " + this.marks[2] + "\nPharmaceutical Biochemistry II: " + this.marks[3]
                    + "\nPhysiology & Histology II: " + this.marks[4] + "\nPharmacology - Anatomy: " + this.marks[5]
                    + "\n\nGPA: " + this.getCGPA();

            return info;
        }
    }

    public String viewSelectedCourses() {
        String info = "";
        for (int i = 0; i < this.courseList.courses.size(); i++)
            info += ("Name: " + this.courseList.courses.get(i).getName()
                    + ", Credit hours: " + this.courseList.courses.get(i).getCreditHours() + "\n");
        return info;
    }

    public void selectCourses(String c1, String c2, String c3,
                              String c4, String c5, String c6) throws IOException {

        AdminBlock.writeSelectedCoursesToFile(this.id, c1, c2, c3, c4, c5, c6);

        this.courseList.addCourse(c1);
        this.courseList.addCourse(c2);
        this.courseList.addCourse(c3);
        this.courseList.addCourse(c4);
        this.courseList.addCourse(c5);
        this.courseList.addCourse(c6);
    }

    public void dropOut() throws IOException {
        AdminBlock.deleteStudentFromFile(this.getID());
    }
}
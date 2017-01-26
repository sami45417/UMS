/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2013 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License"). You
 * may not use this file except in compliance with the License. You can
 * obtain a copy of the License at
 * https://glassfish.dev.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */
package com.ums.driver;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.ums.buildings.IBA;
import com.ums.buildings.Pharmacy;
import com.ums.buildings.UBIT;
import com.ums.entities.AccountHolder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DeanStageController implements Initializable, ControlledScreen {

    ScreensController controller;

    @FXML
    JFXButton exit;
    @FXML
    JFXButton logout;

    @FXML
    JFXButton but1;
    @FXML
    JFXButton but2;
    @FXML
    JFXButton but3;
    @FXML
    JFXButton but4;
    @FXML
    JFXButton but5;
    @FXML
    JFXButton but6;
    @FXML
    JFXButton but7;
    @FXML
    JFXButton but8;
    @FXML
    JFXButton but9;
    @FXML
    JFXButton but10;
    @FXML
    JFXButton but11;
    @FXML
    JFXButton but12;
    @FXML
    JFXButton but13;
    @FXML
    JFXButton but14;

    @FXML
    JFXButton sort1;
    @FXML
    JFXButton sort2;
    @FXML
    JFXButton sort3;

    @FXML
    JFXTextArea area;

    @FXML
    Text text;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        area.setEditable(false);
        text.setText("Welcome to your dashboard, " + Driver.university.dn.getName()
                + " of " + Driver.university.dn.getDepartment());
        sort1.setDisable(true);
        sort2.setDisable(true);
        sort3.setDisable(true);
    }

    public void setScreenParent(ScreensController screenParent) {
        controller = screenParent;
    }

    @FXML
    private void logout(ActionEvent event) {
        controller.setScreen(Driver.screen2ID);
    }

    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void viewPersonalInfo() {
        area.setText(Driver.university.dn.toString());
        sort1.setDisable(true);
        sort2.setDisable(true);
        sort3.setDisable(true);
    }

    @FXML
    private void generateResultReport() {
        area.setText(Driver.university.dn.generateResultReport());
        sort1.setDisable(true);
        sort2.setDisable(true);
        sort3.setDisable(true);
    }

    @FXML
    private void generateAttandanceReport() {
        area.setText(Driver.university.dn.generateAttendanceReport());
        sort1.setDisable(true);
        sort2.setDisable(true);
        sort3.setDisable(true);
    }

    @FXML
    private void generateSalaryReport() {
        area.setText(Driver.university.dn.generateSalaryReport());
        sort1.setDisable(true);
        sort2.setDisable(true);
        sort3.setDisable(true);
    }

    @FXML
    private void viewTeachers() {
        area.setText(Driver.university.dn.viewTeachers());
        sort1.setDisable(false);
        sort2.setDisable(true);
        sort3.setDisable(true);
    }

    @FXML
    private void viewStudents() {
        area.setText(Driver.university.dn.viewStudents());
        sort2.setDisable(false);
        sort1.setDisable(true);
        sort3.setDisable(true);
    }

    @FXML
    private void viewCourses() {
        area.setText(Driver.university.dn.viewCourses());
        sort3.setDisable(false);
        sort1.setDisable(true);
        sort2.setDisable(true);
    }

    @FXML
    private void sortTeachers() {
        if (Driver.university.dn.getDepartment().equals("UBIT")) {
            UBIT.teacherSort();
            viewTeachers();
        } else if (Driver.university.dn.getDepartment().equals("IBA")) {
            IBA.teacherSort();
            viewTeachers();
        } else {
            Pharmacy.teacherSort();
            viewTeachers();
        }
    }

    @FXML
    private void sortStudents() {
        if (Driver.university.dn.getDepartment().equals("UBIT")) {
            UBIT.studentList.sort();
            viewStudents();
        } else if (Driver.university.dn.getDepartment().equals("IBA")) {
            IBA.studentList.sort();
            viewStudents();
        } else {
            Pharmacy.studentList.sort();
            viewStudents();
        }
    }

    @FXML
    private void sortCourses() {
        if (Driver.university.dn.getDepartment().equals("UBIT")) {
            UBIT.courseList.sort();
            viewCourses();
        } else if (Driver.university.dn.getDepartment().equals("IBA")) {
            IBA.courseList.sort();
            viewCourses();
        } else {
            Pharmacy.courseList.sort();
            viewCourses();
        }
    }

    @FXML
    private void registerTeacher() {
        Paint green = Paint.valueOf("#016F61");
        Paint white = Paint.valueOf("#ffffff");

        Stage stage = new Stage();
        stage.setTitle("UMS - Register New Teacher");
        VBox layout = new VBox(10);
        layout.setStyle("-fx-background: #FFFFFF;");
        Button butt1 = new Button("Confirm");
        butt1.setStyle("-fx-background-color: #016F61");
        butt1.setTextFill(white);
        Label label = new Label();

        JFXTextField textField1 = new JFXTextField();
        JFXTextField textField2 = new JFXTextField();
        JFXTextField textField3 = new JFXTextField();

        textField1.setPromptText("Enter Name");
        textField2.setPromptText("Enter Qualification");
        textField3.setPromptText("Enter Salary");

        textField1.setFocusColor(green);
        textField2.setFocusColor(green);
        textField3.setFocusColor(green);

        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().addAll(textField1, textField2, textField3, butt1, label);
        Scene scene = new Scene(layout, 400, 200);
        stage.setScene(scene);
        stage.show();
        butt1.setOnAction(event -> registerTeacherOK(textField1.getText(), textField2.getText()
                , textField3.getText(), Driver.university.dn.getDepartment(), stage, label));
    }

    private void registerTeacherOK(String name, String qualification, String salary, String department, Stage stage, Label label) {
        if ((name.equals("Enter Name") || department.equals("Enter Department") || qualification.equals("Enter Qualification")
                || salary.equals("Enter Salary") || name.equals("") || department.equals("")
                || qualification.equals("")) || salary.equals(""))
            label.setText("Please fill all the fields");

        else {
            try {
                Driver.university.dn.hireNewEmployee(name, qualification, department, Integer.valueOf(salary), AccountHolder.Position.TEACHER);
                stage.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @FXML
    private void fireTeacher() {
        Paint green = Paint.valueOf("#016F61");
        Paint white = Paint.valueOf("#ffffff");

        Stage stage = new Stage();
        stage.setTitle("UMS - Fire Teacher");
        Label label = new Label();
        VBox layout = new VBox(10);
        JFXButton butt1 = new JFXButton("OK");
        butt1.setStyle("-fx-background-color: #016F61");
        butt1.setTextFill(white);
        JFXTextField textField = new JFXTextField();
        textField.setPromptText("Enter ID to Fire");
        textField.setFocusColor(green);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().addAll(textField, butt1, label);
        layout.setStyle("-fx-background: #FFFFFF;");
        Scene scene = new Scene(layout, 400, 120);
        stage.setScene(scene);
        stage.show();

        butt1.setOnAction(event -> fireTeacherOk(textField.getText(), stage, label));
    }

    private void fireTeacherOk(String id, Stage stage, Label label) {
        if (id.equals("Enter ID to Fire") || (id.equals(""))) {
            label.setText("Please enter ID");
        } else {
            try {
                Driver.university.dn.fireEmployee(id);
                stage.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void registerStudent() {
        Paint green = Paint.valueOf("#016F61");
        Paint white = Paint.valueOf("#ffffff");

        Stage stage = new Stage();
        stage.setTitle("UMS - Register Student");
        VBox layout = new VBox(10);
        JFXButton butt = new JFXButton("Confirm");
        butt.setStyle("-fx-background-color: #016F61");
        butt.setTextFill(white);

        Label label = new Label();

        JFXTextField textField1 = new JFXTextField();
        JFXTextField textField2 = new JFXTextField();

        textField1.setPromptText("Enter Name");
        textField2.setPromptText("Enter Field");

        textField1.setFocusColor(green);
        textField2.setFocusColor(green);

        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().addAll(textField1, textField2, butt, label);

        layout.setStyle("-fx-background: #FFFFFF;");

        Scene scene = new Scene(layout, 400, 160);
        stage.setScene(scene);
        stage.show();
        butt.setOnAction(event -> registerStudentOK(textField1.getText(), Driver.university.dn.getDepartment(),
                textField2.getText(), stage, label));
    }

    private void registerStudentOK(String name, String department, String field, Stage stage, Label label) {
        if (name.equals("Enter Name") || department.equals("Enter Department") || field.equals("Enter Field")
                || name.equals("") || department.equals("") || field.equals("")) {
            label.setText("Please fill all the fields");
        } else {
            try {
                Driver.university.dn.registerStudent(name, department, field);
                stage.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @FXML
    private void suspendStudent() {
        Paint green = Paint.valueOf("#016F61");
        Paint white = Paint.valueOf("#ffffff");

        Stage stage = new Stage();
        stage.setTitle("UMS - Suspend Student");
        VBox layout = new VBox(10);
        JFXButton butt = new JFXButton("Confirm");
        butt.setStyle("-fx-background-color: #016F61");
        butt.setTextFill(white);

        Label lab = new Label();
        JFXTextField textField = new JFXTextField();
        textField.setPromptText("Enter ID");
        textField.setFocusColor(green);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().addAll(textField, butt, lab);
        layout.setStyle("-fx-background: #FFFFFF;");
        Scene scene = new Scene(layout, 400, 120);
        stage.setScene(scene);
        stage.show();

        butt.setOnAction(event -> suspendStudentOk(textField.getText(), stage, lab));
    }

    private void suspendStudentOk(String id, Stage stage, Label lab) {
        if (id.equals("Enter ID to Suspend") || id.equals("")) {
            lab.setText("Please enter ID");
        } else {
            try {
                Driver.university.dn.suspendStudent(id);
                stage.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void modifyCourse() {
        Paint green = Paint.valueOf("#016F61");
        Paint white = Paint.valueOf("#ffffff");

        Stage stage = new Stage();
        stage.setTitle("UMS - Modify Course");
        VBox layout = new VBox(10);
        layout.setStyle("-fx-background: #FFFFFF;");
        layout.setPadding(new Insets(10, 10, 10, 10));
        JFXTextArea textArea = new JFXTextArea();
        textArea.setEditable(false);
        textArea.setFocusColor(green);
        JFXTextField tField1 = new JFXTextField();
        tField1.setPromptText("Enter ID");
        tField1.setFocusColor(green);
        JFXTextField tField2 = new JFXTextField();
        tField2.setFocusColor(green);
        tField2.setPromptText("Enter new Name");
        Button butt = new Button("Confirm");
        butt.setStyle("-fx-background-color: #016F61");
        butt.setTextFill(white);
        Label lab = new Label();
        textArea.setMaxSize(1000, 500);
        textArea.setMinSize(1000, 500);
        textArea.setText(Driver.university.dn.viewCourses());
        tField1.setMaxSize(150, 50);
        tField2.setMaxSize(150, 50);
        layout.getChildren().addAll(textArea, tField1, tField2, butt, lab);
        Scene scene = new Scene(layout, 1020, 660);
        stage.setScene(scene);
        stage.show();
        butt.setOnAction(event -> modifyCourseOK(tField1.getText(), tField2.getText(), stage, lab));
    }

    private void modifyCourseOK(String id, String name, Stage stage, Label lab) {
        if (id.equals("Enter ID") || id.equals("") || name.equals("Enter New Name") || name.equals(""))
            lab.setText("Please fill all the fields");

        else {
            try {
                Driver.university.dn.modifyCourse(id, name);
                stage.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void increaseInSalary() {
        Paint green = Paint.valueOf("#016F61");
        Paint white = Paint.valueOf("#ffffff");

        Stage stage = new Stage();
        stage.setTitle("UMS - Increase In Salary");
        VBox layout = new VBox(10);
        layout.setStyle("-fx-background: #FFFFFF;");
        Button butt = new Button("OK");
        butt.setStyle("-fx-background-color: #016F61");
        butt.setTextFill(white);
        Label lab = new Label("Request Sent");
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().addAll(lab, butt);
        Scene scene = new Scene(layout, 400, 100);
        stage.setScene(scene);
        stage.show();
        butt.setOnAction(event -> increaseSalaryWindowClose(stage));
    }

    private void increaseSalaryWindowClose(Stage trStage) {
        trStage.close();
    }

    @FXML
    private void resign() {
        Paint green = Paint.valueOf("#016F61");
        Paint white = Paint.valueOf("#ffffff");

        Button butt1 = new Button("NO");
        Button butt2 = new Button("YES");
        butt1.setStyle("-fx-background-color: #016F61");
        butt1.setTextFill(white);
        butt2.setStyle("-fx-background-color: #016F61");
        butt2.setTextFill(white);
        Label label = new Label("You are resigning from your position as Dean. Are you sure?");

        Stage stage = new Stage();
        stage.setTitle("UMS - Resign");
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.setStyle("-fx-background: #FFFFFF;");

        layout.getChildren().addAll(label, butt1, butt2);
        Scene scene = new Scene(layout, 400, 140);
        stage.setScene(scene);
        stage.show();
        butt1.setOnAction(event -> resignNo(stage));
        butt2.setOnAction(event -> resignYes());
    }

    private void resignYes() {
        try {
            Driver.university.dn.resign();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    private void resignNo(Stage stage) {
        stage.close();
    }

    @FXML
    private void changePassword() {
        Paint green = Paint.valueOf("#016F61");
        Paint white = Paint.valueOf("#ffffff");

        Stage stage = new Stage();
        stage.setTitle("UMS - Change Password");
        VBox layout = new VBox(10);
        JFXButton butt = new JFXButton("Confirm");
        butt.setStyle("-fx-background-color: #016F61");
        butt.setTextFill(white);

        Label lab = new Label();
        JFXTextField textField = new JFXTextField();
        textField.setPromptText("Enter new Password");
        textField.setFocusColor(green);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().addAll(textField, butt, lab);
        layout.setStyle("-fx-background: #FFFFFF;");
        Scene scene = new Scene(layout, 400, 120);
        stage.setScene(scene);
        stage.show();

        butt.setOnAction(event -> changePasswordOk(textField.getText(), stage, lab));
    }

    private void changePasswordOk(String pass, Stage stage, Label lab) {
        if (pass.equals("Enter new Password") || pass.equals(""))
            lab.setText("Please enter Password");
        else {
            try {
                Driver.university.dn.changePassword(pass);
                stage.close();
                Driver.mainContainer.loadScreen(Driver.screen2ID, Driver.screen2File);
                Driver.mainContainer.loadScreen(Driver.screen5ID, Driver.screen5File);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

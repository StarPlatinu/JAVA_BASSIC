package com.training.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import com.traning.entities.Employee;
import com.traning.uitils.Validation;

public class Manager {
	private ArrayList<Employee> list = new ArrayList<>();
    Validation v = new Validation();

    public void Menu() {
        System.out.println("---------------Menu---------------");
        System.out.println("1.Add Employees");
        System.out.println("2.Update Employees");
        System.out.println("3.Remove Employees");
        System.out.println("4.Search Employees");
        System.out.println("5.Sort Employees by salarys");
        System.out.println("6 .Exit");
    }

    public String inputID() {
        String id = "";
        while (true) {
            id = v.inputString("Enter ID : ");
            int check = 0;
            for (Employee employee : list) {
                if (employee.getId().equalsIgnoreCase(id)) {
                    check = 1;
                    break;
                }
            }
            if (check == 0) {
                return id;
            } else {
                System.out.println("Id is exist .Enter again  : ");;
            }
        }
    }

    public String checkIDExist() {
        String id = "";
        while (true) {
            id = v.inputString("Enter ID : ");
            int check = 0;
            for (Employee employee : list) {
                if (employee.getId().equalsIgnoreCase(id)) {
                    check = 1;
                    break;
                }
            }
            if (check == 1) {
                return id;
            } else {
                System.out.println("Id is not exist .Please enter again  ");
            }
        }
    }

    public void addEmployee() {
        System.out.println("----------------------AddEmployee--------------------");
        String id = inputID();
        String firstName = v.inputString("Enter FirstName : ");
        String lastName = v.inputString("Enter LastName : ");
        String phone = v.inputPhoneNumber("Enter Phone Number : ");
        String email = v.inputMail("Enter Email Address : ");
        String address = v.inputString("Enter address : ");
        Date dob = v.inputDate("Enter Date Of Birth : ");
        String gender = v.inputGender("Enter Sex Of Employee : ");
        double salary = v.inputSalary("Enter Salary : ");
        String egency = v.inputString("Enter Egency : "); //chuc vu
        Employee e = new Employee(id, firstName, lastName, phone, email, address, dob, gender, salary, egency);
        list.add(e);
        
    }
    //Ko nhap j ko update
    //nhap trhong tin hp le thi update

    public void updateEmployee() {
        System.out.println("----------------------UpdateEmployee----------------------------");
        System.out.println("Id in the list :");
        for (Employee e : list) {
            System.out.println(e.getId());
        }   
        String id = checkIDExist();
        for (Employee employee : list) {
            if (employee.getId().equalsIgnoreCase(id)) {
                Employee current = new Employee(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getPhone(), employee.getEmail(), employee.getAddress(),
                        employee.getDob(), employee.getGender(), employee.getSalary(), employee.getEgency());
                String choice = "";
                choice = v.getYN("Are you want to update FirstName (Y/N): ");

                if (choice.equalsIgnoreCase("Y")) {
                    String firstName = v.inputString("Enter FirstName : ");
                    employee.setFirstName(firstName);

                } else {

                    employee.setFirstName(current.getFirstName());
                }

                choice = v.getYN("Are you want to update LastName (Y/N): ");
                if (choice.equalsIgnoreCase("Y")) {
                    String lastName = v.inputString("Enter LastName : ");
                    employee.setLastName(lastName);

                } else {
                    employee.setLastName(current.getLastName());
                }

                choice = v.getYN("Are you want to update Phone Number (Y/N): ");
                if (choice.equalsIgnoreCase("Y")) {
                    String phone = v.inputPhoneNumber("Enter Phone Number : ");
                    employee.setPhone(phone);

                } else {
                    employee.setPhone(current.getPhone());
                }

                choice = v.getYN("Are you want to update Email (Y/N): ");
                if (choice.equalsIgnoreCase("Y")) {
                    String email = v.inputMail("Enter Email Address : ");
                    employee.setEmail(email);

                } else {
                    employee.setEmail(current.getEmail());
                }

                choice = v.getYN("Are you want to update Address (Y/N): ");
                if (choice.equalsIgnoreCase("Y")) {
                    String address = v.inputString("Enter address : ");
                    employee.setAddress(address);

                } else {
                    employee.setAddress(current.getAddress());
                }

                choice = v.getYN("Are you want to update Dob (Y/N): ");
                if (choice.equalsIgnoreCase("Y")) {
                    Date dob = v.inputDate("Enter Date Of Birth : ");
                    employee.setDob(dob);

                } else {
                    employee.setDob(current.getDob());
                }

                choice = v.getYN("Are you want to update Gender (Y/N): ");
                if (choice.equalsIgnoreCase("Y")) {
                    String gender = v.inputGender("Enter Sex Of Employee : ");
                    employee.setGender(gender);

                } else {
                    employee.setGender(current.getGender());
                }

                choice = v.getYN("Are you want to update Salary (Y/N): ");
                if (choice.equalsIgnoreCase("Y")) {
                    double salary = v.inputSalary("Enter Salary : ");
                    employee.setSalary(salary);

                } else {
                    employee.setSalary(current.getSalary());
                }

                choice = v.getYN("Are you want to update Egency (Y/N): ");
                if (choice.equalsIgnoreCase("Y")) {
                    String egency = v.inputString("Enter Egency : "); //chuc vu
                    employee.setEgency(egency);

                } else {
                    employee.setEgency(current.getEgency());
                }

            }
        }
    }

    public void removeEmployee() {
        System.out.println("----------------------RemoveByID----------------------");
        System.out.println("ID in the list :"); 
        for (Employee e : list) {
            System.out.println(e.getId());
        }
        String id = v.inputString("Enter ID To Remove : ");

        int count = 0;
         
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                list.remove(i);
                System.out.println("Remove Succesfull");
                count++;
                break;
            }
        }
        if (count == 0) {
            System.out.println("Invalid ID");
        }

    }

    public void serachEmployee() {
        System.out.println("-----------------------SearchByName-----------------------");
        String fname = v.inputString("Search By Name : ").toLowerCase();
        int count = 0;
        String fl = "";
        String f2 = "";
        for (Employee e : list) {
            fl = e.getFirstName().toLowerCase() + " " + e.getLastName().toLowerCase();
            //không có dấu cách nguyena
            f2 = e.getFirstName().toLowerCase().concat(e.getLastName().toLowerCase());

            if (e.getFirstName().toLowerCase().contains(fname) || e.getLastName().toLowerCase().contains(fname)
                    || fl.trim().toLowerCase().contains(fname) || f2.toLowerCase().contains(fname)) {
                System.out.println(e.toString());
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Not Found");
        }
    }

    public void sortEmploiyee() {
        Collections.sort(list, new Comparator<Employee>() {
            @Override
            public int compare(Employee object1, Employee object2) {
                if (object1.getSalary() > object2.getSalary()) {//doi cho
                    return 1;//doi vi tri
                } else if (object1.getSalary() < object2.getSalary()) {
                    return -1;//ko doi
                } else {
                    return 0;//ko doi
                }
            }
        });
        System.out.println("Sort Succesfull");
    }

//    public void sortByBubbleSort(){
//        for (int i = 0; i < list.size(); i++) {
//            for (int j = 0; j < list.size()-1; j++) {
//                if(list.get(j).getSalary()>list.get(j+1).getSalary()){
//                    Collections.swap(list, j, j+1);
//                }
//            }
//        }
//    }
    public void showData() {
        System.out.println("=================================");
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }
    public void addData(){
         SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
          try {
            list.add(new Employee("A101", "Tran", "Duc Long", "0833160082", "longtd@gmail.com", "Nam Dinh", df.parse("20/02/2020"), "Male", 2500, "Number 1"));
            list.add(new Employee("B102", "Le", "Thi Quynh", "0942614892", "quynhtl@gmail.com", "Hai Phong", df.parse("20/05/2001"), "Female", 3000, "Number 2"));
            list.add(new Employee("C103", "Le", "Quang Anh Kiet", "0833160082", "Kietlqa@gmail.com", "Ha Noi", df.parse("20/02/2001"), "Male", 5000, "Number 3"));
            list.add(new Employee("D104", "Trinh", "Hai Long", "098134562", "Longth@gmail.com", "Da Nang", df.parse("20/02/2001"), "Male", 10000, "Number 4"));
        } catch (Exception ex) {
        }
    }

    public void display() {
        Manager m = new Manager();
        m.addData();
        while (true) {
               m.Menu();
            int choice = v.getChoice("Enter your choice : ", 1, 7);
            switch (choice) {
                case 1:
                    m.addEmployee();
                    m.showData();
                    break;
                case 2:
                    m.updateEmployee();
                    m.showData();
                    break;
                case 3:
                    m.removeEmployee();
                    m.showData();
                    break;
                case 4:
                    m.serachEmployee();
                    break;
                case 5:
                    m.sortEmploiyee();
                    m.showData();
                    break;

                case 6:
                    System.exit(0);
//                default:
//                    System.exit(0);
            }
        }
    }
}

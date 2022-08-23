package lab;

import datastr.LinkedCollection;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        File file_std = new File("src/lab/student.csv");
        File file_withdraw = new File("src/lab/withdraw.csv");
        Scanner std_fileReader = new Scanner(file_std);
        Scanner wd_fileReader = new Scanner(file_withdraw);

//        check if all files exist
        boolean exists = file_std.exists() && file_withdraw.exists();
        if(!exists){
            System.out.println("File not found.");
        }

        else{
            LinkedCollection students = new LinkedCollection();
//            LinkedCollection register = new LinkedCollection();
            LinkedCollection withdraw = new LinkedCollection();

            while(std_fileReader.hasNext()){
                String thisline = std_fileReader.next();
                String[] data = thisline.split(",",4);
                Student std = new Student(data[0] ,data[1] ,data[2] ,Float.parseFloat(data[3]));

                students.add(std);
            }

            while(wd_fileReader.hasNext()){
                String thisline = wd_fileReader.next();
                String[] data = thisline.split(",",4);
                Student wd_std = new Student(data[0] ,data[1] ,data[2] ,Float.parseFloat(data[3]));

                withdraw.add(wd_std);
            }

//            System.out.println("----------------------");
//            students.printAll();
//            System.out.println("----------------------");
//            withdraw.printAll();
//            System.out.println("----------------------");

//            check duplicate student
            if (students.containsDup()){
                System.out.print("Duplicate students in file.");
                students.removeDup();
                if (!students.containsDup()){
                    System.out.println(" Removed.");
                }
            }
            else {
                System.out.println("No duplicate student.");
            }

//            check duplicate withdraw
            if (withdraw.containsDup()){
                System.out.print("Duplicate withdraws in file.");
                withdraw.removeDup();
                if (!withdraw.containsDup()){
                    System.out.println(" Removed.");
                }
            }
            else {
                System.out.println("No duplicate withdraw.");
            }

//            check if withdraw equals to student
            if (withdraw.equals(students)){
                System.out.println("\nAll withdrew ("+withdraw.size()+")");
                withdraw.printAll();
            }
            else {
                students.removeAll(withdraw);
                System.out.println("\nAll register ("+students.size()+")");
                students.printAll();
                System.out.println("\nAll withdrew ("+withdraw.size()+")");
                withdraw.printAll();
            }


//            System.out.println("----------------------");
//            students.printAll();
//            System.out.println("----------------------");
//            withdraw.printAll();
//            System.out.println("----------------------");

        }
    }
}
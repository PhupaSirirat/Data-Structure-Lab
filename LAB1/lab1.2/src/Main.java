import datastr.ArraySet;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {


        Scanner scan = new Scanner(System.in);
        File file = new File("src/student.csv");
        Scanner reader = new Scanner(file);
        boolean exists = file.exists();
        if(!exists){
            System.out.println("File not found.");
        }

        else{

//          // change from lab1.1
            ArraySet collection = new ArraySet(10);

            while(reader.hasNext()){
                String thisline = reader.next();
//                System.out.println(thisline);
                String[] data = thisline.split(",",4);
                Student std = new Student(data[0] ,data[1] ,data[2] ,Float.parseFloat(data[3]));
                collection.add(std);
            }
            Object[] std = collection.toArray();


            System.out.println("add or delete or stop?");
            String input = scan.nextLine();
            while(!input.equals("stop")){
                if (input.equals("add")){
                    String[] Data = scan.nextLine().split(" ",4);
                    Student newstd = new Student(Data[0] ,Data[1] ,Data[2] ,Float.parseFloat(Data[3]));

                    if (collection.contains(newstd)){
                        System.out.println("Add new record");
//                    collection.remove(newstd);
                        collection.add(newstd);
                        System.out.println("add or delete or stop?");
                    }
                    else {
                        System.out.println("Add new record");
                        collection.add(newstd);
                        System.out.println("add or delete or stop?");
                    }
                } else if (input.equals("delete")) {
                    String toRemove = scan.nextLine();
                    Student newstd = new Student(toRemove);
                    if (collection.contains(newstd)){
                        collection.remove(newstd);
                        System.out.println("Remove a record");
                        System.out.println("add or delete or stop?");
                    }
                    else {
                        System.out.println("No object to remove");
                    }
                }
                else {
                    System.out.println("Invalid command");
                }
                input = scan.nextLine();
            }

            System.out.println("\nstudent.csv");
            System.out.println("----------------------------------");
            for (Object e: std){
                System.out.println(e);
            }

            System.out.println("\nstudentNEW.csv");
            System.out.println("----------------------------------");
            Object[] newstd = collection.toArray();
            for (Object e: newstd){
                System.out.println(e);
            }

        }




    }
}
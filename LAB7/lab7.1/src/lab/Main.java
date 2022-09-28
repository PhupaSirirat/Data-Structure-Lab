package lab;

import datastr.CourseGrade;
import datastr.SeparateChainingHashMap;
import datastr.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        HashMap<Student, ArrayList<CourseGrade>> map = new HashMap<>();
        SeparateChainingHashMap map = new SeparateChainingHashMap(12);
        Scanner scan = new Scanner(System.in);

        try {
            File file = new File("src/lab/register.csv");
            Scanner fileReader = new Scanner(file);

            while (fileReader.hasNext()) {
                String data = fileReader.nextLine();
                String[] arr = data.split(",");

                Student std = new Student(arr[0], arr[1], arr[2]);
                CourseGrade c = new CourseGrade(arr[3], arr[4], arr[5], arr[6], arr[7], arr[8]);

                map.put(std, c);
            }
            fileReader.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

        System.out.println(map);


    }
}
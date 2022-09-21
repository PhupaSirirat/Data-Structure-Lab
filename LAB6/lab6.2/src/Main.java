import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        HashMap<Student , ArrayList<CourseGrade>> map = new HashMap<>();
        Scanner scan = new Scanner(System.in);

        try {
            File file = new File("src/register.csv");
            Scanner fileReader = new Scanner(file);

            while (fileReader.hasNext()) {
                String data = fileReader.nextLine();
                String[] arr = data.split(",");

                Student std = new Student(arr[0], arr[1], arr[2]);
                CourseGrade c = new CourseGrade(arr[3], arr[4], arr[5], arr[6], arr[7], arr[8]);

//                System.out.println(map.containsKey(std));
                if (!map.containsKey(std)) {
                    ArrayList<CourseGrade> arr_c = new ArrayList<>();
                    arr_c.add(c);
                    map.put(std, arr_c);
                }
                else {
                    ArrayList<CourseGrade> arr_c = map.get(std);
                    arr_c.add(c);
                }

            }
            fileReader.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

//        System.out.println(map);

        System.out.println("Enter student ID");
        String id_input = scan.nextLine();

        for (Student std : map.keySet()) {
            if (std.getID().equals(id_input)) {
                for (CourseGrade c : map.get(std)) {
                    System.out.println(c);
                }
                break;
            }
        }
    }
}

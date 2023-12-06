package Collections;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hashtable<Integer,Student> ht = new Hashtable<>();
        Student stu = new Student();
        Scanner scan = new Scanner(System.in);
        int size=0,option;
        do {
            System.out.print(
                    """
                    1. Add Student
                    2. Detail Student
                    3. Search Student
                    4. Update Student
                    5. Remove Student
                    6. Exit
                    """
            );
            System.out.print("Please choose option : ");option = scan.nextInt();
            switch (option){
                case 1->{
                    System.out.print("Enter number of student to add : "); size = scan.nextInt();
                    for (int i = 0; i < size; i++) {
                        stu = new Student();
                        stu.addStudent();
                        ht.put(i,stu);
                    }
                }
                case 2->{
                    stu.header();
                    ht.forEach((key,value)->{
                        value.showStudent();
                    });
                }
                case 3->{
                    int data;
                    System.out.print("Enter id for search : ");data = scan.nextInt();
                    stu.header();
                    ht.forEach((key,value)->{
                        if (data == value.getId()){
                            value.showStudent();
                        }
                    });
                }
                case 4->{
                    int data;
                    System.out.print("Enter id for update : ");data = scan.nextInt();
                    ht.forEach((key,value)->{
                        if (value.getId() == data){
                            value.addStudent();
                        }
                    });
                }
                case 5->{
                    int data;
                    System.out.print("Enter id for remove : ");data = scan.nextInt();

                    ht.entrySet().removeIf(map -> map.getValue().getId() == data);


            /*        for(Iterator<Map.Entry<Integer,Student>> itr = ht.entrySet().iterator(); itr.hasNext();){
                        Map.Entry<Integer,Student> map = itr.next();
                        if (map.getValue().getId() == data){
                            itr.remove();
                        }
                    }*/
                }
            }
        }while (option!=6);
    }
}

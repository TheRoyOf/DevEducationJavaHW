package Person;

import java.util.ArrayList;

public class StudentList {
    static ArrayList<Student> students = new ArrayList<Student>();

    public static void AddStudent(Student student)
    {
        students.add(student);
    }

    public static void RemoveStudent(Student student)
    {
        students.remove(student);
    }

    public static void RemoveIndex(int index)
    {
        students.remove(index);
    }

    public static ArrayList<Student> GetByFaculty(String faculty)
    {
        ArrayList<Student> rezult = new ArrayList<Student>();

        for (Student student:students)
        {
            if (student.faculty.equals(faculty))
            {
                rezult.add(student);
            }
        }

        return rezult;
    }

    public static ArrayList<Student> GetByCourse(int course)
    {
        ArrayList<Student> rezult = new ArrayList<Student>();

        for (Student student:students)
        {
            if (student.course == course)
            {
                rezult.add(student);
            }
        }

        return rezult;
    }

    public static ArrayList<Student> GetByGroup(String group)
    {
        ArrayList<Student> rezult = new ArrayList<Student>();

        for (Student student:students)
        {
            if (student.group.equals(group))
            {
                rezult.add(student);
            }
        }

        return rezult;
    }

    public static ArrayList<Student> GetByYear(int year)
    {
        ArrayList<Student> rezult = new ArrayList<Student>();

        for (Student student:students)
        {
            if (Integer.parseInt(student.birthday.split("\\.")[2]) >= year)
            {
                rezult.add(student);
            }
        }

        return rezult;
    }


}

import java.util.Collection;
import java.util.HashMap;

public class Students {
    private static final HashMap<Integer, Student> students = new HashMap<>();

    public static boolean addStudent(Student student) {
        if (isExistedStudent(student.getID())) {
            System.out.println("学号重复");
            return false;
        }
        students.put(student.getID(), student);
        return true;
    }

    public static Collection<Student> getStudents() {
        return students.values();
    }

    public static boolean isExistedStudent(int ID) {
        return students.containsKey(ID);
    }

    public static Student getStudent(int ID) {
        return isExistedStudent(ID) ? students.get(ID) : null;
    }

    public static void clear() {
        students.clear();
    }

    public static boolean isEmpty() {
        return students.isEmpty();
    }

    private Students() {
    }
}

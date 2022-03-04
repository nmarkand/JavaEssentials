package Collection.STREAM.object;

public class Student implements Comparable<Student>{
    private Integer id;
    private String name;
    private int age;
    private int marks;

    public Student(Integer id, String name, int age, int marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public int compareTo(Student student) {
        return this.id - student.getId();
    }
}

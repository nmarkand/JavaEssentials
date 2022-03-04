package Collection.STREAM.object;

import java.util.List;

public class Employee {
    private Integer id;
    private String name;
    private List<Integer> departmentIds;

    public Employee(Integer id, String name, List<Integer> departmentIds) {
        this.id = id;
        this.name = name;
        this.departmentIds = departmentIds;
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

    public List<Integer> getDepartmentIds() {
        return departmentIds;
    }

    public void setDepartmentIds(List<Integer> departmentIds) {
        this.departmentIds = departmentIds;
    }
}

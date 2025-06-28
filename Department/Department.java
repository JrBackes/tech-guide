package Department;

public class Department {
    
    private String name;
    private int id;
    private String code;

    public Department(String name, int id, String code) {
        this.name = name;
        this.id = id;
        this.code = code;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
}


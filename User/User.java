package User;

import Department.Department;

public class User {
    private String name;
    private String email;
    private String password;
    private Department departmentId;
    private int roleId;

    public User(String name, String email, String password, Department departmentId, int roleId) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.departmentId = departmentId;
        this.roleId = roleId;
    }

    public User(String name, String email, String password, Department departmentId) {
            this.name = name;
            this.email = email;
            this.password = password;
            this.departmentId = departmentId;
        }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.departmentId = null; // Default value
        this.roleId = 0; // Default value
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean passwordReset(String oldPassword, String newPassword) {
        if (this.password.equals(oldPassword)) {
            this.password = newPassword;
            return true;
        }
        return false;
    }

    public Department getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Department departmentId) {
        this.departmentId = departmentId;
    }

    public int getRoleId() {
    return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId; 
    }






}

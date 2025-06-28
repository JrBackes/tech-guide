import Department.Department;
import Ticket.Ticket;
import User.User;

public class Main {
    public static void main(String[] args) {

        Department department = new Department("Tecnologia", 1, "TEC");
        
        User junior = new User("Junior Backes", "junior.backes@hotmail.com", "password123", department);
    
        Ticket ticket = new Ticket(1, "Problema de Login", "Não consigo acessar minha conta", junior, "Aberto");

        System.out.println(ticket.getCompId());
    }
}

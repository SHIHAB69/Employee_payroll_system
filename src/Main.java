import java.util.ArrayList;
import java.util.List;

abstract class Employee{

    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }

    public abstract double calculateSalary();

    @Override
    public String toString(){
        return "Employee[ name= " + name + ", id = " + id + ", Salary = " + calculateSalary()+" ]";
    }
}


class FullTimeEmployee extends Employee{

    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }
    @Override
    public double calculateSalary(){

        return monthlySalary;

    }

}

class PartTimeEmployee extends Employee{
    private int hoursWork;
    private double hourlyRate;
    public PartTimeEmployee(String name, int id, int hoursWork,double hourlyRate){
        super(name, id);
        this.hoursWork = hoursWork;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary(){
        return hoursWork * hourlyRate;
    }

}

class PayrollSystem{
    private ArrayList<Employee> employeeList;

    public PayrollSystem(){
        employeeList  = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }

    public void removeEmployee(int id){
        Employee employeeToRemove = null;
        for(Employee employee : employeeList){
            if (employee.getId() == id){
                employeeToRemove = employee;
                break;
            }
        }
        if (employeeToRemove != null){
            employeeList.remove(employeeToRemove);
        }
    }
    public void displayEmployees(){
        for(Employee employee : employeeList){
            System.out.println(employee);
        }
    }
}


public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();
        FullTimeEmployee emp1 = new FullTimeEmployee("Vikas", 1, 1000);
        PartTimeEmployee emp2 = new PartTimeEmployee("Sihab", 2, 40,100);
        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);
        System.out.println("Init employee details");
        payrollSystem.displayEmployees();
        System.out.println("Remove Employee details");
        payrollSystem.removeEmployee(2);
        System.out.println("Remaining Employee details");
        payrollSystem.displayEmployees();

    }
}



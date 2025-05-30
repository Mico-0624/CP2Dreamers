import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String employeeName;
    private int employeeNumber;
    private String birthDate; // As specified, but LocalDate would be better in a real app
    private String position;
    private double hourlyRate;

    // Relationship: Employee has Attendance (Aggregation)
    // Represents multiple attendance records for an employee
    private List<Attendance> attendanceRecords;

    // Constructor
    public Employee(String employeeName, int employeeNumber, String birthDate, String position, double hourlyRate) {
        this.employeeName = employeeName;
        this.employeeNumber = employeeNumber;
        this.birthDate = birthDate;
        this.position = position;
        this.hourlyRate = hourlyRate;
        this.attendanceRecords = new ArrayList<>(); // Initialize the list
    }

    // Method from the diagram
    // '-' indicates private, but printing info is a common internal method
    private void getEmployeeInfo() {
        System.out.println("Employee Number: " + employeeNumber);
        System.out.println("Name: " + employeeName);
        System.out.println("Birth Date: " + birthDate);
        System.out.println("Position: " + position);
        System.out.println("Hourly Rate: " + hourlyRate);
    }

    // Method from the diagram
    // '-' indicates private in diagram, but needed publicly for SalaryCalculator
    public double getHourlyRate() {
        return hourlyRate;
    }

    // Method to add attendance records (related to aggregation)
    public void addAttendance(Attendance attendance) {
        this.attendanceRecords.add(attendance);
    }

    // Method to get attendance records (useful for calculating total hours)
    public List<Attendance> getAttendanceRecords() {
        return attendanceRecords;
    }

    // Optional: Getters for other attributes if needed publicly
    public String getEmployeeName() {
        return employeeName;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getPosition() {
        return position;
    }
}


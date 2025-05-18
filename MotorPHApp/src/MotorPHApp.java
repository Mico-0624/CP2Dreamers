/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */import java.util.List;

/**
 *
 * @author Mico
 */
public class MotorPHApp {public static void main(String[] args) {
        // --- Demonstrate User Login ---
        System.out.println("--- User Login ---");
        User adminUser = new User("admin", "password123");

        boolean isLoggedIn = adminUser.verifyLogin("admin", "password123");
        System.out.println("Login successful: " + isLoggedIn); // Should be true

        boolean isLoggedInWrong = adminUser.verifyLogin("admin", "wrongpassword");
        System.out.println("Login successful: " + isLoggedInWrong); // Should be false
        System.out.println();

        // --- Create Employee and Attendance ---
        System.out.println("--- Employee & Attendance ---");
        Employee emp1 = new Employee("Juan Dela Cruz", 1001, "1990-05-15", "Software Engineer", 500.0);

        // Add some attendance records for a pay period
        Attendance att1_day1 = new Attendance("2023-10-26", 8.0, 17.0); // 9 hours
        Attendance att1_day2 = new Attendance("2023-10-27", 8.0, 17.5); // 9.5 hours
        Attendance att1_day3 = new Attendance("2023-10-28", 9.0, 18.0); // 9 hours

        emp1.addAttendance(att1_day1);
        emp1.addAttendance(att1_day2);
        emp1.addAttendance(att1_day3);

        System.out.println("Employee: " + emp1.getEmployeeName() + " (ID: " + emp1.getEmployeeNumber() + ")");
        System.out.println("Hourly Rate: " + emp1.getHourlyRate());

        // Calculate total hours worked from attendance records
        List<Attendance> employeeAttendance = emp1.getAttendanceRecords();
        double totalHours = 0;
        System.out.println("Attendance Records:");
        for (Attendance attendance : employeeAttendance) {
            double hours = attendance.calculateHoursWorked();
            System.out.println(" - Date: " + attendance.getDate() + ", Hours Worked: " + hours);
            totalHours += hours;
        }
        System.out.println("Total hours worked for pay period: " + totalHours);
        System.out.println();

        // --- Create Deductions ---
        System.out.println("--- Deductions ---");
        Deduction emp1Deductions = new Deduction(1000.0, 500.0, 300.0, 1200.0);

        double totalDeductions = emp1Deductions.calculateTotalDeductions();
        System.out.println("SSS: " + emp1Deductions.getSss());
        System.out.println("Pag-IBIG: " + emp1Deductions.getPagibig());
        System.out.println("PhilHealth: " + emp1Deductions.getPhilhealth());
        System.out.println("Withholding Tax: " + emp1Deductions.getWithholdingTax());
        System.out.println("Total Deductions: " + totalDeductions);
        System.out.println();


        // --- Calculate Salary ---
        System.out.println("--- Salary Calculation ---");
        SalaryCalculator calculator = new SalaryCalculator();

        // Using the alternative method that takes objects
        calculator.calculateSalary(emp1.getAttendanceRecords(), emp1.getHourlyRate(), emp1Deductions);

        // Or using the step-by-step methods:
        // double gross = calculator.calculateGrossSalary(totalHours, emp1.getHourlyRate());
        // double net = calculator.calculateNetSalary(gross, totalDeductions);

        System.out.println("Calculated Gross Salary: " + calculator.getGrossSalary());
        System.out.println("Calculated Net Salary: " + calculator.getNetSalary());
    }
}
    

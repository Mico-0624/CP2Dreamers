import java.util.List;

public class SalaryCalculator {
    // Attributes to hold results after calculation (as suggested by diagram)
    private double totalHoursWorked; // Might be better as a parameter to methods
    private double hourlyRate;       // Might be better as a parameter to methods
    private double grossSalary;
    private double netSalary;

    // Constructor (simple, calculation methods take parameters)
    public SalaryCalculator() {
        // Initialize results
        this.totalHoursWorked = 0.0;
        this.hourlyRate = 0.0; // Could get this from Employee object later
        this.grossSalary = 0.0;
        this.netSalary = 0.0;
    }

    // Method from the diagram
    // '-' indicates private in diagram, but needed publicly to perform calculation
    // Takes necessary inputs from Attendance (hours) and Employee (rate)
    public double calculateGrossSalary(double totalHoursWorked, double hourlyRate) {
        this.totalHoursWorked = totalHoursWorked; // Store input/intermediate value
        this.hourlyRate = hourlyRate;             // Store input/intermediate value
        this.grossSalary = totalHoursWorked * hourlyRate;
        return this.grossSalary;
    }

    // Method from the diagram
    // '-' indicates private in diagram, but needed publicly to perform calculation
    // Takes necessary inputs from the previous calculation (gross) and Deduction (total)
    public double calculateNetSalary(double grossSalary, double totalDeductions) {
        this.grossSalary = grossSalary; // Use potentially updated gross if calculated elsewhere
        this.netSalary = grossSalary - totalDeductions;
        return this.netSalary;
    }

    // Alternative calculation method that takes Attendance and Deduction objects directly
    // This better reflects the 'uses' aggregation
    public double calculateSalary(List<Attendance> attendanceRecords, double hourlyRate, Deduction deduction) {
        double totalHours = 0;
        for (Attendance attendance : attendanceRecords) {
            totalHours += attendance.calculateHoursWorked();
        }

        double gross = calculateGrossSalary(totalHours, hourlyRate); // Use the gross salary method
        double totalDeductions = deduction.calculateTotalDeductions(); // Use the deduction method
        double net = calculateNetSalary(gross, totalDeductions); // Use the net salary method

        // Store final calculated values (optional, depending on desired object state)
        this.totalHoursWorked = totalHours;
        this.hourlyRate = hourlyRate;
        this.grossSalary = gross;
        this.netSalary = net;

        return this.netSalary; // Return the final net salary
    }


    // Getters for the calculated results
    public double getTotalHoursWorked() {
        return totalHoursWorked;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public double getNetSalary() {
        return netSalary;
    }
}
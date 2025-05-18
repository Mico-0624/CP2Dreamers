public class Deduction {
    private double sss;
    private double pagibig;
    private double philhealth;
    private double withholdingTax;

    // Constructor
    public Deduction(double sss, double pagibig, double philhealth, double withholdingTax) {
        this.sss = sss;
        this.pagibig = pagibig;
        this.philhealth = philhealth;
        this.withholdingTax = withholdingTax;
    }

    // Method from the diagram
    // '-' indicates private in diagram, but needed publicly for SalaryCalculator
    public double calculateTotalDeductions() {
        return sss + pagibig + philhealth + withholdingTax;
    }

    // Optional: Getters if needed
    public double getSss() {
        return sss;
    }

    public double getPagibig() {
        return pagibig;
    }

    public double getPhilhealth() {
        return philhealth;
    }

    public double getWithholdingTax() {
        return withholdingTax;
    }
}
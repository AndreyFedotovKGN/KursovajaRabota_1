import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class Main {
    static Employee[] employee = new Employee[10];

    public static void main(String[] args) {
        employee[0] = new Employee("Иванов", "Иван", "Иванович", 1, 25000);
        employee[1] = new Employee("Петров", "Сергей", "Валентинович", 1, 27000);
        employee[2] = new Employee("Сидоров", "Алексей", "Николаевич", 1, 23500);
        employee[3] = new Employee("Глазков", "Николай", "Андреевич", 2, 55000);
        employee[4] = new Employee("Шабалин", "Андрей", "Владимирович", 2, 58000);
        employee[5] = new Employee("Никитин", "Владимир", "Сергеевич", 3, 18500);
        printingListOfEmployees(employee);
        calculationAndPrintingOfPayrollExpenses();
        sealOfTheEmployeeWithTheLowestSalary();
        sealOfTheEmployeeWithTheHighestSalary();
        printingTheAverageValueOfSalaries();
        printingEmployeeNames();
    }

    public static void printingListOfEmployees(Employee[] employee) {
        for (int i = 0; i < employee.length; i++) {
            if (i == employee.length - 1) {
                System.out.println(employee[i]);
                break;
            } else if (employee[i] == null) {
                break;
            }
            System.out.println(employee[i] + " ");
        }
    }

    public static double calculationAndPrintingOfPayrollExpenses() {
        double sumSalary = 0;
        for (Employee value : employee) {
            if (value != null) {
                sumSalary += value.getSalary();
            } else break;
        }
        System.out.printf("Сумма затрат на зарплаты в месяц = %s \n", sumSalary);
        return sumSalary;
    }

    public static void sealOfTheEmployeeWithTheLowestSalary() {
        double min = Double.MAX_VALUE;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null) {
                min = Math.min(min, employee[i].getSalary());
            } else break;
        }
        for (int i = 0; i < employee.length; i++) {
            if (min == employee[i].getSalary()) {
                System.out.printf("Сотрудник с минимальной зарплатой: %s \n", employee[i]);
                break;
            } else if (employee[i] == null) {
                break;
            }
        }
    }

    public static void sealOfTheEmployeeWithTheHighestSalary() {
        double max = Double.MIN_VALUE;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null) {
                max = Math.max(max, employee[i].getSalary());
            } else break;
        }
        for (int i = 0; i < employee.length; i++) {
            if (max == employee[i].getSalary()) {
                System.out.printf("Сотрудник с максимальной зарплатой: %s \n", employee[i]);
                break;
            } else if (employee[i] == null) {
                break;
            }
        }
    }

    public static void printingTheAverageValueOfSalaries() {
        double averageSalary = 0;
        double sum = calculationAndPrintingOfPayrollExpenses();
        int numberOfEmployees = 0;
        for (int i = 0; i < employee.length; i++) {
            int count = 1;
            if (employee[i] != null) {
                numberOfEmployees = count + i;
            } else break;
        }
        averageSalary = sum/numberOfEmployees;
        System.out.printf("Cредняя зарплата составляет: %s \n",averageSalary);
    }

    public static void printingEmployeeNames() {
        String fullName = null;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null) {
                fullName = (employee[i].getFamily() + " "+ employee[i].getName() + " " + employee[i].getPatronymic());
                System.out.printf("Ф.И.О.: %s \n", fullName);
            } else break;
        }
    }
}
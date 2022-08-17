import java.util.Objects;

public class Employee {
    private static int counter = 1;
    private final String family;
    private final String name;
    private final String patronymic;
    private int office;
    private double salary;
    private final int id;

    public Employee (String family, String name,String patronymic,int office,double salary) {
        this.family = family;
        this.name = name;
        this.patronymic = patronymic;
        this.office = office;
        this.salary = salary;
        this.id = counter++;
    }

    public static int getCounter() {
        return counter;
    }

    public String getFamily() {
        return family;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public int getOffice() {
        return office;
    }
    public double getSalary() {
        return salary;
    }

    public void setOffice(int office) {
        this.office = office;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return office == employee.office && Double.compare(employee.salary, salary) == 0 && id == employee.id && Objects.equals(family, employee.family) && Objects.equals(name, employee.name) && Objects.equals(patronymic, employee.patronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(family, name, patronymic, office, salary, id);
    }


    @Override
    public String toString() {
        return id + " ФИО: " + family + " " + name + " " + patronymic + " Отдел: " + office + " Зарплата = " + salary + " руб.";
    }
}


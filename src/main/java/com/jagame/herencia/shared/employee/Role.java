package com.jagame.herencia.shared.employee;

import com.jagame.herencia.shared.Printable;
import com.jagame.herencia.shared.Printer;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public abstract class Role implements Printable {

    private BigDecimal salary;

    protected Role(BigDecimal baseSalary) {
        this.salary = baseSalary;
    }

    protected abstract String roleName();

    protected BigDecimal salary() {
        return salary;
    }

    protected void incrementSalary() {
        var increment = getSalaryIncrement();
        this.salary = salary.add(increment);
    }

    protected abstract BigDecimal getSalaryIncrement();

    @Override
    public void print(Printer printer) {
        String formattedSalary = salary.setScale(2, RoundingMode.HALF_UP).toPlainString();
        printer.print("""
                --- Role info ---
                Role: %s
                Salary: %s €
                """,
                roleName(),
                formattedSalary
        );
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Role role = (Role) o;
        return Objects.equals(salary, role.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(salary);
    }
}

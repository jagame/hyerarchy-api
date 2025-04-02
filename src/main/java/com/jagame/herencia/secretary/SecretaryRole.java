package com.jagame.herencia.secretary;

import com.jagame.herencia.shared.Printer;
import com.jagame.herencia.shared.employee.Role;

import java.math.BigDecimal;
import java.util.Objects;

public class SecretaryRole extends Role {

    private static final BigDecimal SALARY_INCREMENT_PERCENTAGE = BigDecimal.valueOf(0.05);
    private final int officeNumber;
    private final String faxNumber;

    public SecretaryRole(BigDecimal baseSalary, int officeNumber, String faxNumber) {
        super(baseSalary);
        this.officeNumber = officeNumber;
        this.faxNumber = faxNumber;
    }

    @Override
    protected String roleName() {
        return "Secretary";
    }

    int officeNumber() {
        return officeNumber;
    }

    String faxNumber() {
        return faxNumber;
    }

    @Override
    protected BigDecimal getSalaryIncrement() {
        return SALARY_INCREMENT_PERCENTAGE.multiply(salary());
    }

    @Override
    public void print(Printer printer) {
        super.print(printer);
        printer.print("""
                Office number: %d
                Fax number: %s
                """, officeNumber, faxNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        SecretaryRole that = (SecretaryRole) o;
        return officeNumber == that.officeNumber && Objects.equals(faxNumber, that.faxNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), officeNumber, faxNumber);
    }
}

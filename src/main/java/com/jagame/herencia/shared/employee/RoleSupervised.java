package com.jagame.herencia.shared.employee;

import com.jagame.herencia.shared.Printer;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public abstract class RoleSupervised<T extends Role> extends Role {

    private Employee<T> supervisor;

    protected RoleSupervised(BigDecimal baseSalary, LocalDate seniority) {
        super(baseSalary, seniority);
    }

    public Employee<T> supervisor() {
        return supervisor;
    }

    public void setSupervisor(Employee<T> supervisor) {
        this.supervisor = supervisor;
    }

    @Override
    public void print(Printer printer) {
        printer.print("""
                        --- Supervisor Info ---
                        Name: %s
                        """,
                supervisor.fullName()
        );
        super.print(printer);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RoleSupervised<?> that = (RoleSupervised<?>) o;
        return Objects.equals(supervisor, that.supervisor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), supervisor);
    }
}

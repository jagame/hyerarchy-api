package com.jagame.herencia.shared.employee;

import com.jagame.herencia.shared.Printer;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @param <T> The supervisor role
 */
public abstract class SupervisedRole<T extends Role> extends Role {

    private Employee<T> supervisor;

    protected SupervisedRole(BigDecimal baseSalary) {
        super(baseSalary);
    }

    protected Employee<T> supervisor() {
        return supervisor;
    }

    protected void setSupervisor(Employee<T> supervisor) {
        this.supervisor = supervisor;
    }

    @Override
    public void print(Printer printer) {
        super.print(printer);
        printer.print("""
                Supervisor: %s
                """,
                supervisor == null ? "None" : supervisor.fullName()
        );
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        SupervisedRole<?> that = (SupervisedRole<?>) o;
        return Objects.equals(supervisor, that.supervisor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), supervisor);
    }
}

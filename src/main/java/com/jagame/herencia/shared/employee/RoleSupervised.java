package com.jagame.herencia.shared.employee;

import com.jagame.herencia.boss.ZoneBossRole;
import com.jagame.herencia.shared.Printer;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public abstract class RoleSupervised extends Role {

    private Employee<ZoneBossRole> supervisor;

    protected RoleSupervised(BigDecimal baseSalary, LocalDate seniority) {
        super(baseSalary, seniority);
    }

    public Employee<ZoneBossRole> supervisor() {
        return supervisor;
    }

    public void setSupervisor(Employee<ZoneBossRole> supervisor) {
        this.supervisor = supervisor;
    }

    @Override
    public void print(Printer printer) {
        printer.print("""
                --- Supervisor Info ---
                Name: %s
                OfficeNumber: %s
                """,
                supervisor.fullName(),
                supervisor.roleInfo().officeNumber()
        );
        super.print(printer);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RoleSupervised that = (RoleSupervised) o;
        return Objects.equals(supervisor, that.supervisor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), supervisor);
    }
}

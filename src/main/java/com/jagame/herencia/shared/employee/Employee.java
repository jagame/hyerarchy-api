package com.jagame.herencia.shared.employee;

import com.jagame.herencia.shared.ContactInfo;
import com.jagame.herencia.shared.PersonalInfo;
import com.jagame.herencia.shared.Printable;
import com.jagame.herencia.shared.Printer;

import java.util.Objects;

public abstract class Employee<T extends Role> implements Printable {

    private final PersonalInfo personalInfo;
    private final ContactInfo contactInfo;
    private final T roleInfo;

    protected Employee(PersonalInfo personalInfo, ContactInfo contactInfo, T roleInfo) {
        this.personalInfo = personalInfo;
        this.contactInfo = contactInfo;
        this.roleInfo = roleInfo;
    }

    protected T roleInfo() {
        return roleInfo;
    }

    public String fullName() {
        return personalInfo.name() + ' ' + personalInfo.surname();
    }

    @Override
    public void print(Printer printer) {
        printer.print("===============\n");
        personalInfo.print(printer);
        contactInfo.print(printer);
        roleInfo.print(printer);
        printer.print("===============\n");
    }

    public void incrementSalary() {
        roleInfo.incrementSalary();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee<?> employee = (Employee<?>) o;
        return Objects.equals(personalInfo, employee.personalInfo) &&
                Objects.equals(contactInfo, employee.contactInfo) &&
                Objects.equals(roleInfo, employee.roleInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personalInfo, contactInfo, roleInfo);
    }
}

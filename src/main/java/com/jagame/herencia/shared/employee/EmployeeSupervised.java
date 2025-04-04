package com.jagame.herencia.shared.employee;

import com.jagame.herencia.shared.ContactInfo;
import com.jagame.herencia.shared.PersonalInfo;

public class EmployeeSupervised<S extends Role, T extends RoleSupervised<S>> extends Employee<T> {

    protected EmployeeSupervised(PersonalInfo personalInfo, ContactInfo contactInfo, T roleInfo) {
        super(personalInfo, contactInfo, roleInfo);
    }

    public Employee<S> supervisor() {
        return roleInfo().supervisor();
    }

    public void setSupervisor(Employee<S> supervisor) {
        roleInfo().setSupervisor(supervisor);
    }
}


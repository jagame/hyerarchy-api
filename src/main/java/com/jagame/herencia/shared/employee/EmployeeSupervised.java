package com.jagame.herencia.shared.employee;

import com.jagame.herencia.boss.ZoneBossRole;
import com.jagame.herencia.shared.ContactInfo;
import com.jagame.herencia.shared.PersonalInfo;

public class EmployeeSupervised<T extends RoleSupervised> extends Employee<T> {

    protected EmployeeSupervised(PersonalInfo personalInfo, ContactInfo contactInfo, T roleInfo) {
        super(personalInfo, contactInfo, roleInfo);
    }

    public Employee<ZoneBossRole> supervisor() {
        return roleInfo().supervisor();
    }

    public void setSupervisor(Employee<ZoneBossRole> supervisor) {
        roleInfo().setSupervisor(supervisor);
    }
}


package com.jagame.herencia.secretary;

import com.jagame.herencia.boss.ZoneBossRole;
import com.jagame.herencia.shared.ContactInfo;
import com.jagame.herencia.shared.PersonalInfo;
import com.jagame.herencia.shared.employee.EmployeeSupervised;

public class Secretary extends EmployeeSupervised<ZoneBossRole, SecretaryRole> {

    public Secretary(
            PersonalInfo personalInfo,
            ContactInfo contactInfo,
            SecretaryRole roleInfo
    ) {
        super(personalInfo, contactInfo, roleInfo);
    }
}

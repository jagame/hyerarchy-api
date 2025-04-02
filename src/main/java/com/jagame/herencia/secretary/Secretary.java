package com.jagame.herencia.secretary;

import com.jagame.herencia.shared.ContactInfo;
import com.jagame.herencia.shared.PersonalInfo;
import com.jagame.herencia.shared.employee.Employee;

public class Secretary extends Employee<SecretaryRole> {

    public Secretary(
            PersonalInfo personalInfo,
            ContactInfo contactInfo,
            SecretaryRole roleInfo
    ) {
        super(personalInfo, contactInfo, roleInfo);
    }

}

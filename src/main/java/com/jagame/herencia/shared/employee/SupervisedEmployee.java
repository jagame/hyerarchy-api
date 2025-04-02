package com.jagame.herencia.shared.employee;

import com.jagame.herencia.shared.ContactInfo;
import com.jagame.herencia.shared.PersonalInfo;

/**
 *
 * @param <T> This employee role
 * @param <S> The supervisor role
 */
public class SupervisedEmployee<T extends SupervisedRole<S>, S extends Role> extends Employee<T> {
    protected SupervisedEmployee(PersonalInfo personalInfo, ContactInfo contactInfo, T roleInfo) {
        super(personalInfo, contactInfo, roleInfo);
    }

    public void setSupervisor(Employee<S> supervisor) {
        roleInfo().setSupervisor(supervisor);
    }
}

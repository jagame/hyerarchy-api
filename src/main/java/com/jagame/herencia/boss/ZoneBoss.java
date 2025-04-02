package com.jagame.herencia.boss;

import com.jagame.herencia.secretary.Secretary;
import com.jagame.herencia.seller.Seller;
import com.jagame.herencia.shared.Car;
import com.jagame.herencia.shared.ContactInfo;
import com.jagame.herencia.shared.PersonalInfo;
import com.jagame.herencia.shared.employee.Employee;

public class ZoneBoss extends Employee<ZoneBossRole> {

    public ZoneBoss(
            PersonalInfo personalInfo,
            ContactInfo contactInfo,
            ZoneBossRole roleInfo
    ) {
        super(personalInfo, contactInfo, roleInfo);
    }

    public void addSeller(Seller seller) {
        if(roleInfo().addSeller(seller)) {
            seller.setSupervisor(this);
        }
    }

    public void removeSeller(Seller seller) {
        if(roleInfo().removeSeller(seller)) {
            seller.setSupervisor(null);
        }
    }

    public void setSecretary(Secretary secretary) {
        if(roleInfo().secretary() != null) {
            roleInfo().secretary().setSupervisor(null);
        }
        secretary.setSupervisor(this);
        roleInfo().setSecretary(secretary);
    }

    public void setCar(Car car) {
        roleInfo().setCar(car);
    }

}

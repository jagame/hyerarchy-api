package com.jagame.herencia.seller;

import com.jagame.herencia.shared.employee.SupervisedEmployee;
import com.jagame.herencia.shared.Car;
import com.jagame.herencia.shared.Client;
import com.jagame.herencia.boss.ZoneBossRole;
import com.jagame.herencia.shared.ContactInfo;
import com.jagame.herencia.shared.PersonalInfo;

public class Seller extends SupervisedEmployee<SellerRole, ZoneBossRole> {
    public Seller(
            PersonalInfo personalInfo,
            ContactInfo contactInfo,
            SellerRole roleInfo
    ) {
        super(personalInfo, contactInfo, roleInfo);
    }

    public void addClient(Client client) {
        roleInfo().addClient(client);
    }

    public void removeClient(Client client) {
        roleInfo().removeClient(client);
    }

    public void setCar(Car car) {
        roleInfo().setCar(car);
    }

}

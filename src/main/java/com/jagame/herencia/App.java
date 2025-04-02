package com.jagame.herencia;

import com.jagame.herencia.boss.ZoneBoss;
import com.jagame.herencia.boss.ZoneBossRole;
import com.jagame.herencia.secretary.Secretary;
import com.jagame.herencia.secretary.SecretaryRole;
import com.jagame.herencia.seller.Seller;
import com.jagame.herencia.seller.SellerRole;
import com.jagame.herencia.shared.ContactInfo;
import com.jagame.herencia.shared.PersonalInfo;
import com.jagame.herencia.shared.Printer;

import java.math.BigDecimal;

public class App {

    public static void main(String[] args) {
        var javiBoss = new ZoneBoss(
                new PersonalInfo("Javier", "Gavilán", "78978978V"),
                new ContactInfo("655801955", "Su casa"),
                new ZoneBossRole(BigDecimal.valueOf(5000), 1)
        );
        var saraSecretary = new Secretary(
                new PersonalInfo("Sara", "Clon One", "78978978V"),
                new ContactInfo("655801955", "Su casa"),
                new SecretaryRole(BigDecimal.valueOf(2000), 5, "123456789")
        );
        var saraSeller1 = new Seller(
                new PersonalInfo("Sara", "Clon Two", "78978978V"),
                new ContactInfo("655801955", "Su casa"),
                new SellerRole(BigDecimal.valueOf(1500), "666000666", "Casa de Javi", 0.01)
        );
        var saraSeller2 = new Seller(
                new PersonalInfo("Sara", "Clon Three", "78978978V"),
                new ContactInfo("655801955", "Su casa"),
                new SellerRole(BigDecimal.valueOf(1500), "666000666", "Casa de Javi", 0.01)
        );
        javiBoss.setSecretary(saraSecretary);
        javiBoss.addSeller(saraSeller1);
        javiBoss.addSeller(saraSeller2);

        Printer printer = System.out::printf;
        javiBoss.print(printer);
        saraSecretary.print(printer);
        saraSeller1.print(printer);
        saraSeller2.print(printer);
    }

}

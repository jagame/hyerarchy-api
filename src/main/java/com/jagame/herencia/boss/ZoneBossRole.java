package com.jagame.herencia.boss;

import com.jagame.herencia.shared.Car;
import com.jagame.herencia.shared.Printer;
import com.jagame.herencia.shared.employee.Role;
import com.jagame.herencia.secretary.Secretary;
import com.jagame.herencia.seller.Seller;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class ZoneBossRole extends Role {

    private static final BigDecimal SALARY_INCREMENT_PERCENTAGE = BigDecimal.valueOf(0.2);
    private final int officeNumber;
    private final Set<Seller> sellers;
    private Secretary secretary;
    private Car car;

    public ZoneBossRole(BigDecimal baseSalary, int officeNumber) {
        super(baseSalary);
        this.officeNumber = officeNumber;
        this.sellers = new HashSet<>();
    }

    @Override
    protected String roleName() {
        return "Zone boss";
    }

    int officeNumber() {
        return officeNumber;
    }

    boolean addSeller(Seller seller) {
        return sellers.add(seller);
    }

    boolean removeSeller(Seller seller) {
        return sellers.remove(seller);
    }

    Secretary secretary() {
        return secretary;
    }

    void setSecretary(Secretary secretary) {
        this.secretary = secretary;
    }

    Car car() {
        return this.car;
    }

    void setCar(Car car) {
        this.car = car;
    }

    @Override
    protected BigDecimal getSalaryIncrement() {
        return SALARY_INCREMENT_PERCENTAGE.multiply(salary());
    }

    @Override
    public void print(Printer printer) {
        super.print(printer);
        printer.print("""
                Office number: %d
                Secretary: %s
                Sellers: %s
                Car: %s
                """,
                officeNumber,
                secretary == null ? "None" : secretary.fullName(),
                sellersDescription(),
                Objects.requireNonNullElse(car, "None")
        );
    }

    private String sellersDescription() {
        if(sellers.isEmpty()) {
            return "None";
        }
        return sellers.stream()
                .map(Seller::fullName)
                .collect(Collectors.joining(", "));
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        ZoneBossRole that = (ZoneBossRole) o;
        return officeNumber == that.officeNumber && Objects.equals(sellers, that.sellers) &&
                Objects.equals(secretary, that.secretary) && Objects.equals(car, that.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), officeNumber, sellers, secretary, car);
    }
}

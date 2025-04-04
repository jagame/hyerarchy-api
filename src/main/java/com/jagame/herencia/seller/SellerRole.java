package com.jagame.herencia.seller;

import com.jagame.herencia.shared.Car;
import com.jagame.herencia.shared.Client;
import com.jagame.herencia.shared.Printer;
import com.jagame.herencia.shared.employee.RoleSupervised;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class SellerRole extends RoleSupervised {

    private static final BigDecimal SALARY_INCREMENT_PERCENTAGE = BigDecimal.valueOf(0.1);

    private final String mobilePhone;
    private final String sellArea;
    private final Set<Client> clients;
    private final double commissionPercentage;
    private Car car;

    public SellerRole(
            BigDecimal baseSalary,
            LocalDate seniority,
            String mobilePhone,
            String sellArea,
            double commissionPercentage
    ) {
        super(baseSalary, seniority);
        this.mobilePhone = mobilePhone;
        this.sellArea = sellArea;
        this.clients = new HashSet<>();
        this.commissionPercentage = commissionPercentage;
    }

    @Override
    protected String roleName() {
        return "Seller";
    }

    String mobilePhone() {
        return mobilePhone;
    }

    String sellArea() {
        return sellArea;
    }

    void addClient(Client client) {
        clients.add(client);
    }

    void removeClient(Client client) {
        clients.remove(client);
    }

    double commissionPercentage() {
        return commissionPercentage;
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
                Mobile phone: %s
                Sell area: %s
                Clients: %s
                Car: %s
                Commission: %.2f %%
                """,
                mobilePhone,
                sellArea,
                clientsDescription(),
                car,
                commissionPercentage * 100
        );
    }

    private String clientsDescription() {
        String clientsDescriptions = clients.stream()
                .map(Client::name)
                .collect(Collectors.joining(", "));
        return clientsDescriptions.isEmpty() ? null : clientsDescriptions;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        SellerRole that = (SellerRole) o;
        return Double.compare(commissionPercentage, that.commissionPercentage) == 0 &&
                Objects.equals(mobilePhone, that.mobilePhone) &&
                Objects.equals(sellArea, that.sellArea) && Objects.equals(clients, that.clients) &&
                Objects.equals(car, that.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), mobilePhone, sellArea, clients, commissionPercentage, car);
    }
}

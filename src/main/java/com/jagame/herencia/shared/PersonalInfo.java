package com.jagame.herencia.shared;

public record PersonalInfo(String name, String surname, String dni) implements Printable {
    @Override
    public void print(Printer printer) {
        printer.print("""
                --- Personal info ---
                Name: %s
                Surname: %s
                DNI: %s
                """, name, surname, dni);
    }
}

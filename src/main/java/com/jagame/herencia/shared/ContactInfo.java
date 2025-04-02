package com.jagame.herencia.shared;

public record ContactInfo(String phoneNumber, String address) implements Printable {

    @Override
    public void print(Printer printer) {
        printer.print("""
                --- Contact info ---
                Address: %s
                Phone: %s
                """, address, phoneNumber);
    }
}

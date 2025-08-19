package org.jdbccrud.util;

public record Student(int sId, String sName, String sPhone, String sCity) {
    public Student {
        if(sName == null || sName.isEmpty())
            throw new IllegalArgumentException("Student Name cannot be null or empty!");
    }

    public Student(String sName, String sPhone, String sCity) {
        this(0, sName, sPhone, sCity);
    }

    public Student() {this(0, "", "", "");}

    @Override
    public String toString() { return
            String.format(
                    "ID: %d%n" + "Name: %s%n" + "Phone: %s%n" + "City: %s%n",
                    sId, sName, sPhone, sCity
            );
    }
}

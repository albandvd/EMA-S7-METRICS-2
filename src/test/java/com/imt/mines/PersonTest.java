package com.imt.mines;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    @DisplayName("Should initialize with default constructor")
    void testDefaultConstructor() {
        Person p = new Person();
        assertEquals("", p.getName());
        assertEquals('M', p.getGender());
        assertEquals(0, p.getAge());
    }

    @Test
    @DisplayName("Should initialize with basic constructor")
    void testBasicConstructor() {
        Person p = new Person("Alice", 'F', 30, 1.65f);
        assertEquals("Alice", p.getName());
        assertEquals('F', p.getGender());
        assertEquals(30, p.getAge());
    }

    @Test
    @DisplayName("Should initialize with full constructor and valid data")
    void testFullConstructor() throws Exception {
        Person p = new Person("Bob", 'M', 25, 75.0f, 1.80f, "Brown", "Green", "bob@example.com");
        assertEquals("bob@example.com", p.getEmail());
    }

    @Test
    @DisplayName("Should throw exception for invalid gender in constructor")
    void testInvalidGenderConstructor() {
        assertThrows(Exception.class, () -> {
            new Person("Bob", 'X', 25, 75.0f, 1.80f, "Brown", "Green", "bob@example.com");
        });
    }

    @Test
    @DisplayName("Should accept valid gender characters")
    void testValidGenders() throws Exception {
        Person p = new Person();
        char[] validGenders = {'M', 'F', 'm', 'f'};
        for (char g : validGenders) {
            p.setGender(g);
            assertEquals(g, p.getGender());
        }
    }

    @Test
    @DisplayName("Should update age only if positive")
    void testSetAge() {
        Person p = new Person();
        p.setAge(25);
        assertEquals(25, p.getAge());
        
        p.setAge(-5); 
        assertEquals(25, p.getAge()); 
    }

    @Test
    @DisplayName("Should filter hair color updates")
    void testSetHairColor() {
        Person p = new Person();
        p.setHairColor("Blond");
        assertEquals("Blond", p.getHairColor());

        p.setHairColor("Purple"); 
        assertEquals("Blond", p.getHairColor()); 
    }

    @Test
    @DisplayName("Should parse person from String")
    void testStringScannerConstructor() throws Exception {
        String data = "John" + Person.DELIM + "M" + Person.DELIM + "40" + Person.DELIM + 
                      "1.75" + Person.DELIM + "70.0" + Person.DELIM + "Black" + Person.DELIM + 
                      "Blue" + Person.DELIM + "john@test.com";
        
        Person p = new Person(data);
        assertEquals("John", p.getName());
        assertEquals("john@test.com", p.getEmail());
    }
}
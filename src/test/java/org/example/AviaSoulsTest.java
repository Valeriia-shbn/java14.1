package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AviaSoulsTest {

    Ticket ticket1 = new Ticket("DME", "IST", 210, 12, 17);
    Ticket ticket2 = new Ticket("DME", "IST", 250, 12, 13);
    Ticket ticket3 = new Ticket("SVX", "KZN", 175, 12, 14);
    Ticket ticket4 = new Ticket("DME", "IST", 200, 12, 18);
    Ticket ticket5 = new Ticket("DME", "IST", 300, 12, 15);
    Ticket ticket6 = new Ticket("DME", "IST", 150, 12, 16);
    AviaSouls aviaSouls = new AviaSouls();
    TicketTimeComparator comparator = new TicketTimeComparator();

    @BeforeEach
    void setup() {
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);


    }

    @Test
    void searchShouldFindSeveral() {
        Ticket[] expected = {ticket6, ticket4, ticket1, ticket2, ticket5};
        Ticket[] actual = aviaSouls.search("DME", "IST");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    void searchShouldFindOne() {
        Ticket[] expected = {ticket3};
        Ticket[] actual = aviaSouls.search("SVX", "KZN");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    void searchShouldFindNothing() {
        Ticket[] expected = {};
        Ticket[] actual = aviaSouls.search("SVO", "IST");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    void searchAndSortByShouldFindSeveral() {
        Ticket[] expected = {ticket2, ticket5, ticket6, ticket1, ticket4};
        Ticket[] actual = aviaSouls.searchAndSortBy("DME", "IST", comparator);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void searchAndSortByShouldFindOne() {
        Ticket[] expected = {ticket3};
        Ticket[] actual = aviaSouls.searchAndSortBy("SVX", "KZN", comparator);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void searchAndSortByShouldFindNothing() {
        Ticket[] expected = {};
        Ticket[] actual = aviaSouls.searchAndSortBy("IST", "DME", comparator);
        Assertions.assertArrayEquals(expected, actual);
    }
}
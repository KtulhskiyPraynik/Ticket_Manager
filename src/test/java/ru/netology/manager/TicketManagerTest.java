package ru.netology.manager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.manager.TicketManager;
import ru.netology.repository.Repository;

public class TicketManagerTest {

    Ticket ticket1 = new Ticket(1, 7500, "KJA", "TJM", 400);
    Ticket ticket2 = new Ticket(2, 4700, "OVB", "KJA", 300);
    Ticket ticket3 = new Ticket(3, 9500, "OMS", "OVB", 230);
    Ticket ticket4 = new Ticket(4, 2300, "KHV", "UUS", 40);
    Ticket ticket5 = new Ticket(5, 8800, "SVX", "KJA", 550);

    @Test
    public void tes1() {

        Repository repo = new Repository();
        TicketManager manager = new TicketManager(repo);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.findBySort("J", "J");
        Ticket[] expected = {ticket2, ticket1, ticket5};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test2() {

        Repository repo = new Repository();
        TicketManager manager = new TicketManager(repo);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.findBySort("J", "C");
        Ticket[] expected = {ticket1};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test3() {

        Repository repo = new Repository();
        TicketManager manager = new TicketManager(repo);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.findBySort("T", "N");
        Ticket[] expected = {};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test4() {

        Repository repo = new Repository();
        TicketManager manager = new TicketManager(repo);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.findBySort("", "");
        Ticket[] expected = {ticket4, ticket2, ticket1, ticket5, ticket3};
        assertArrayEquals(expected, actual);
    }
}

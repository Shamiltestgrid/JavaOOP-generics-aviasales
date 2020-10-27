package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.OfferComparator;
import ru.netology.domain.Offer;
import ru.netology.repository.OfferRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class OfferManagerTest {
    private OfferRepository repository = new OfferRepository();
    private OfferManager manager = new OfferManager(repository);

    private Offer testOffer1 = new Offer(1, 1300, "MOW", "LED", 100);
    private Offer testOffer2 = new Offer(2, 1200, "MOW", "LED", 120);
    private Offer testOffer3 = new Offer(3, 1100, "MOW", "LED", 130);
    private Offer testOffer4 = new Offer(4, 1400, "LED", "MOW", 140);
    private Offer testOffer5 = new Offer(5, 1600, "MOW", "UFA", 150);
    private Offer testOffer6 = new Offer(6, 1500, "MOW", "UFA", 160);
    private Offer testOffer7 = new Offer(7, 1800, "LED", "UFA", 170);
    private Offer testOffer8 = new Offer(8, 1700, "LED", "UFA", 180);
    private Offer testOffer9 = new Offer(9, 1900, "MOW", "TOF", 190);
    private Offer testOffer10 = new Offer(20, 2000, "MOW", "TOF", 200);

    private Offer offerToAdd = new Offer(999, 999, "XXX", "YYY", 999);

    @BeforeEach
    void SetUp() {
        repository.save(testOffer1);
        repository.save(testOffer2);
        repository.save(testOffer3);
        repository.save(testOffer4);
        repository.save(testOffer5);
        repository.save(testOffer6);
        repository.save(testOffer7);
        repository.save(testOffer8);
        repository.save(testOffer9);
        repository.save(testOffer10);
    }

    @Test
    void shouldAddOffer() {
        manager.add(offerToAdd);
        Offer[] expected = {
                testOffer1,
                testOffer2,
                testOffer3,
                testOffer4,
                testOffer5,
                testOffer6,
                testOffer7,
                testOffer8,
                testOffer9,
                testOffer10,
                offerToAdd
        };

        assertArrayEquals(expected, repository.getAll());
    }

    @Test
    void shouldFindAllFromTo() {
        Offer[] actual = manager.findAllFromTo("MOW","UFA");
        Offer[] expected = {
                testOffer6,
                testOffer5
        };

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAllFromToNegative() {
        Offer[] actual = manager.findAllFromTo("NY","UFA");
        Offer[] expected = {};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAllSorted() {
        Offer[] actual = manager.findAllFromToSortedBy("LED","UFA", new OfferComparator());
        Offer[] expected = {
                testOffer7,
                testOffer8
        };

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindNothing() {
        Offer[] actual = manager.findAllFromToSortedBy("LED","LED", new OfferComparator());
        Offer[] expected = {};

        assertArrayEquals(expected, actual);
    }
}
@Test
    void shouldAddOffer() {
        manager.add(offerToAdd);
        Offer[] expected = null
              
        };
}


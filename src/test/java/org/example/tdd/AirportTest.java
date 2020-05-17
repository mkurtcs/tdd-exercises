package org.example.tdd;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AirportTest {

    @DisplayName("Given there is an economy flight")
    @Nested
    class EconomyFlightTest {

        private Flight economyFlight;
        private Passenger mike;
        private Passenger john;

        @BeforeEach
        void setUp() {
            economyFlight = new EconomyFlight("1");
            mike = new Passenger("Mike", false);
            john = new Passenger("John", true);
        }

        @Nested
        @DisplayName("When we have a usual passenger")
        class UsualPassenger {
            @Test
            @DisplayName("Then you can add and remove him from an economy flight")
            public void testEconomyFlightUsualPassenger() {
                assertAll("Verify all conditions for a usual passenger and an economy flight",
                        () -> assertEquals("1", economyFlight.getId()),
                        () -> assertEquals(true, economyFlight.addPassenger(mike)),
                        () -> assertEquals(1, economyFlight.getPassengerList().size()),
                        () -> assertEquals("Mike", economyFlight.getPassengerList().get(0).getName()),
                        () -> assertEquals(true, economyFlight.removePassenger(mike)),
                        () -> assertEquals(0, economyFlight.getPassengerList().size())
                );
            }
        }

        @Nested
        @DisplayName("When we have a vip passenger")
        class VipPassenger {
            @Test
            @DisplayName("Then you can add him but cannot remove him from an economy flight")
            public void testEconomyFlightVipPassenger() {
                assertAll("Verify all conditions for a VIP passenger and an economy flight",
                        () -> assertEquals("1", economyFlight.getId()),
                        () -> assertEquals(true, economyFlight.addPassenger(john)),
                        () -> assertEquals(1, economyFlight.getPassengerList().size()),
                        () -> assertEquals("John", economyFlight.getPassengerList().get(0).getName()),
                        () -> assertEquals(false, economyFlight.removePassenger(john)),
                        () -> assertEquals(1, economyFlight.getPassengerList().size())
                );
            }
        }

    }


    @DisplayName("Given there is a business flight")
    @Nested
    class BusinessFlightTest {

        private Flight premiumFlight;
        private Passenger mike;
        private Passenger john;

        @BeforeEach
        void setUp() {
            premiumFlight = new BusinessFlight("2");
            mike = new Passenger("Mike", false);
            john = new Passenger("John", true);
        }

        @Nested
        @DisplayName("When we have a usual passenger")
        class UsualPassenger {
            @Test
            @DisplayName("Then you can not add or remove him from a business flight")
            public void testBusinessFlightUsualPassenger() {
                assertAll("Verify all conditions for a usual passenger and a business flight",
                        () -> assertEquals(false, premiumFlight.addPassenger(mike)),
                        () -> assertEquals(0, premiumFlight.getPassengerList().size()),
                        () -> assertEquals(false, premiumFlight.removePassenger(mike)),
                        () -> assertEquals(0, premiumFlight.getPassengerList().size())
                );
            }
        }
        @Nested
        @DisplayName("When we have a VIP passenger")
        class VipPassenger {
            @Test
            @DisplayName("Then you can add him but cannot remove him from a business flight")
            public void testBusinessFlightVipPassenger() {
                assertAll("Verify all conditions for a VIP passenger and a business flight",
                        () -> assertEquals(true, premiumFlight.addPassenger(john)),
                        () -> assertEquals(1, premiumFlight.getPassengerList().size()),
                        () -> assertEquals(false, premiumFlight.removePassenger(john)),
                        () -> assertEquals(1, premiumFlight.getPassengerList().size())
                );
            }
        }
    }

    @DisplayName("Given there is a premium flight")
    @Nested
    class PremiumFlightTest {

        private Flight premiumFlight;
        private Passenger mike;
        private Passenger john;

        @BeforeEach
        void setUp() {
            premiumFlight = new PremiumFlight("3");
            mike = new Passenger("Mike", false);
            john = new Passenger("John", true);
        }

        @Nested
        @DisplayName("When we have a usual passenger")
        class UsualPassenger {
            @Test
            @DisplayName("Then you can not add or remove him from a premium flight")
            public void testPremiumFlightUsualPassenger() {
                assertAll("Verify all conditions for a usual passenger and a premium flight",
                        () -> assertEquals(false, premiumFlight.addPassenger(mike)),
                        () -> assertEquals(0, premiumFlight.getPassengerList().size()),
                        () -> assertEquals(false, premiumFlight.removePassenger(mike)),
                        () -> assertEquals(0, premiumFlight.getPassengerList().size())
                );
            }
        }
        @Nested
        @DisplayName("When we have a VIP passenger")
        class VipPassenger {
            @Test
            @DisplayName("Then you can add him but cannot remove him from a premium flight")
            public void testPremiumFlightVipPassenger() {
                assertAll("Verify all conditions for a VIP passenger and a premium flight",
                        () -> assertEquals(true, premiumFlight.addPassenger(john)),
                        () -> assertEquals(1, premiumFlight.getPassengerList().size()),
                        () -> assertEquals(true, premiumFlight.removePassenger(john)),
                        () -> assertEquals(0, premiumFlight.getPassengerList().size())
                );
            }
        }
    }


}

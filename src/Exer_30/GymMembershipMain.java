package Exer_30;

import java.time.LocalDate;

// Main class to test the gym membership system
public class GymMembershipMain {
        public static void main(String[] args) {
                System.out.println("=== GYM MEMBERSHIP MANAGEMENT SYSTEM ===\n");

                // Create basic memberships
                System.out.println("--- Creating Basic Memberships ---");
                GymMembership basicMember = new GymMembership("John Smith", "Basic", 3,
                                LocalDate.now().minusMonths(1));
                GymMembership standardMember = new GymMembership("Sarah Johnson", "Standard", 6,
                                LocalDate.now().minusMonths(2));
                GymMembership annualBasic = new GymMembership("Mike Wilson", "Basic", 12,
                                LocalDate.now().minusMonths(8));

                // Create premium memberships
                System.out.println("\n--- Creating Premium Memberships ---");
                PremiumMembership premiumBasic = new PremiumMembership("Emily Davis", 3,
                                LocalDate.now().minusMonths(1),
                                true, 4, false, false, true);
                PremiumMembership premiumFull = new PremiumMembership("David Brown", 12,
                                LocalDate.now().minusMonths(3),
                                true, 8, true, true, true);
                PremiumMembership premiumLite = new PremiumMembership("Lisa Garcia", 6,
                                LocalDate.now().plusDays(7),
                                false, 0, true, false, true);

                // Display basic membership details
                System.out.println("\n--- Basic Membership Details ---");
                basicMember.displayMembershipDetails();
                basicMember.checkSpecialOffers();
                System.out.println("\n" + "=".repeat(70));

                standardMember.displayMembershipDetails();
                standardMember.checkSpecialOffers();
                System.out.println("\n" + "=".repeat(70));

                annualBasic.displayMembershipDetails();
                annualBasic.checkSpecialOffers();

                // Display premium membership details
                System.out.println("\n--- Premium Membership Details ---");
                premiumBasic.displayMembershipDetails();
                premiumBasic.checkSpecialOffers();
                System.out.println("\n" + "=".repeat(70));

                premiumFull.displayMembershipDetails();
                premiumFull.checkSpecialOffers();
                System.out.println("\n" + "=".repeat(70));

                premiumLite.displayMembershipDetails();
                premiumLite.checkSpecialOffers();

                // Test membership modifications
                System.out.println("\n--- Testing Membership Modifications ---");
                premiumBasic.addTrainerSessions(2);
                premiumBasic.addSpaAccess();
                premiumLite.addNutritionConsultation();

                // Display updated premium memberships
                System.out.println("\n--- Updated Premium Memberships ---");
                premiumBasic.displayMembershipDetails();
                System.out.println("\n" + "=".repeat(70));
                premiumLite.displayMembershipDetails();

                // Test premium-specific features
                System.out.println("\n=== PREMIUM-SPECIFIC FEATURES ===");
                System.out.println("Emily's Fitness Score: " + premiumBasic.calculateFitnessScore() + "/100");
                System.out.println("David's Fitness Score: " + premiumFull.calculateFitnessScore() + "/100");
                System.out.println("David's Elite Package: " + premiumFull.isElitePackage());
                System.out.println("David's Benefits Value: $" +
                                String.format("%.2f", premiumFull.calculateBenefitsValue()));

                // Test membership management
                System.out.println("\n--- Testing Membership Management ---");
                basicMember.extendMembership(3);
                premiumLite.cancelMembership();
                premiumLite.reactivateMembership();

                // Test error handling
                System.out.println("\n=== TESTING ERROR HANDLING ===");
                basicMember.extendMembership(-2); // Invalid extension
                premiumLite.addTrainerSessions(0); // Invalid sessions

                // Demonstrate polymorphism
                System.out.println("\n=== ALL MEMBERSHIPS SUMMARY (POLYMORPHISM) ===");
                GymMembership[] allMemberships = {
                                new GymMembership("Tom White", "Standard", 3, LocalDate.now().minusMonths(1)),
                                new PremiumMembership("Anna Black", 6, LocalDate.now().minusMonths(2),
                                                true, 6, true, false, true),
                                new GymMembership("Chris Lee", "Basic", 1, LocalDate.now()),
                                new PremiumMembership("Maria Rodriguez", 12, LocalDate.now().minusMonths(6),
                                                true, 12, true, true, true)
                };

                // Display all memberships and their features
                for (GymMembership membership : allMemberships) {
                        membership.displayMembershipDetails();

                        // Access premium-specific methods
                        if (membership instanceof PremiumMembership) {
                                PremiumMembership premium = (PremiumMembership) membership;
                                System.out.println("Fitness Score: " + premium.calculateFitnessScore() + "/100");
                                System.out.println("Elite Package: " + premium.isElitePackage());
                        }

                        membership.checkSpecialOffers();
                        System.out.println("\n" + "=".repeat(70));
                }

                // Final statistics
                System.out.println("=== GYM MEMBERSHIP STATISTICS ===");
                System.out.println("Basic Memberships: John Smith, Mike Wilson, Chris Lee");
                System.out.println("Standard Memberships: Sarah Johnson, Tom White");
                System.out.println(
                                "Premium Memberships: Emily Davis, David Brown, Lisa Garcia, Anna Black, Maria Rodriguez");
                System.out.println(
                                "Features: Fee calculation, Special offers, Membership management, Premium benefits");
        }
}
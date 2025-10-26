package Exer_30;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class GymMembership {
    private String memberName;
    private String membershipType; // Basic, Standard, Premium
    private int durationMonths;
    private LocalDate startDate;
    private LocalDate endDate;
    private double baseMonthlyFee;
    private boolean isActive;

    // Constructor
    public GymMembership(String memberName, String membershipType, int durationMonths, LocalDate startDate) {
        this.memberName = memberName;
        this.membershipType = membershipType;
        this.durationMonths = durationMonths;
        this.startDate = startDate;
        this.endDate = startDate.plusMonths(durationMonths);
        this.baseMonthlyFee = calculateBaseMonthlyFee();
        this.isActive = true;
        System.out.println("Gym membership created for " + memberName + " - " + membershipType + " (" + durationMonths
                + " months)");
    }

    // Calculate base monthly fee based on membership type
    private double calculateBaseMonthlyFee() {
        switch (membershipType.toLowerCase()) {
            case "basic":
                return 50.00;
            case "standard":
                return 75.00;
            case "premium":
                return 100.00;
            default:
                return 60.00;
        }
    }

    // Calculate total membership fee
    public double calculateMembershipFee() {
        double totalFee = baseMonthlyFee * durationMonths;

        // Apply discounts based on duration
        if (durationMonths >= 12) {
            totalFee *= 0.85; // 15% discount for annual membership
        } else if (durationMonths >= 6) {
            totalFee *= 0.90; // 10% discount for 6-month membership
        } else if (durationMonths >= 3) {
            totalFee *= 0.95; // 5% discount for 3-month membership
        }

        return totalFee;
    }

    // Check for special offers
    public void checkSpecialOffers() {
        System.out.println("\n--- SPECIAL OFFERS FOR " + memberName.toUpperCase() + " ---");

        // Seasonal offers
        if (isSummerPromotion()) {
            System.out.println("🎯 SUMMER SPECIAL: Get 2 extra months free with annual membership!");
        }

        if (isNewYearPromotion()) {
            System.out.println("🎉 NEW YEAR OFFER: 20% discount on all 6-month memberships!");
        }

        // Duration-based offers
        if (durationMonths < 3) {
            System.out.println("💡 Upgrade to 3-month membership and save 5%!");
        } else if (durationMonths < 6) {
            System.out.println("💡 Upgrade to 6-month membership and save 10%!");
        } else if (durationMonths < 12) {
            System.out.println("💡 Upgrade to annual membership and save 15%!");
        }

        // Membership type upgrade offers
        if (!membershipType.equalsIgnoreCase("premium")) {
            System.out.println("⭐ Upgrade to Premium for personal trainer and spa access!");
        }
    }

    // Check seasonal promotions
    private boolean isSummerPromotion() {
        int month = LocalDate.now().getMonthValue();
        return (month >= 6 && month <= 8); // June to August
    }

    private boolean isNewYearPromotion() {
        int month = LocalDate.now().getMonthValue();
        return (month == 12 || month == 1); // December or January
    }

    // Calculate days remaining in membership
    public long getDaysRemaining() {
        if (!isActive) {
            return 0;
        }
        return ChronoUnit.DAYS.between(LocalDate.now(), endDate);
    }

    // Check if membership is about to expire (within 30 days)
    public boolean isAboutToExpire() {
        return isActive && getDaysRemaining() <= 30;
    }

    // Extend membership
    public void extendMembership(int additionalMonths) {
        if (additionalMonths > 0) {
            durationMonths += additionalMonths;
            endDate = endDate.plusMonths(additionalMonths);
            System.out.println("✓ Membership extended by " + additionalMonths + " months");
            System.out.println("  New end date: " + endDate);
        } else {
            System.out.println("✗ Additional months must be positive!");
        }
    }

    // Cancel membership
    public void cancelMembership() {
        if (isActive) {
            isActive = false;
            System.out.println("✓ Membership cancelled for " + memberName);
        } else {
            System.out.println("Membership is already cancelled.");
        }
    }

    // Reactivate membership
    public void reactivateMembership() {
        if (!isActive) {
            isActive = true;
            // Extend end date from today
            long monthsElapsed = ChronoUnit.MONTHS.between(startDate, LocalDate.now());
            endDate = LocalDate.now().plusMonths(durationMonths - (int) monthsElapsed);
            System.out.println("✓ Membership reactivated for " + memberName);
        } else {
            System.out.println("Membership is already active.");
        }
    }

    // Display membership details
    public void displayMembershipDetails() {
        System.out.println("\n=== GYM MEMBERSHIP DETAILS ===");
        System.out.println("Member Name: " + memberName);
        System.out.println("Membership Type: " + membershipType);
        System.out.println("Duration: " + durationMonths + " months");
        System.out.println("Start Date: " + startDate);
        System.out.println("End Date: " + endDate);
        System.out.println("Base Monthly Fee: $" + String.format("%.2f", baseMonthlyFee));
        System.out.println("Total Fee: $" + String.format("%.2f", calculateMembershipFee()));
        System.out.println("Status: " + (isActive ? "Active" : "Inactive"));
        System.out.println("Days Remaining: " + getDaysRemaining());
        System.out.println("About to Expire: " + (isAboutToExpire() ? "Yes" : "No"));
    }

    // Getters
    public String getMemberName() {
        return memberName;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public int getDurationMonths() {
        return durationMonths;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public double getBaseMonthlyFee() {
        return baseMonthlyFee;
    }

    public boolean isActive() {
        return isActive;
    }
}

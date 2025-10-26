package Exer_30;
import java.time.LocalDate;

class PremiumMembership extends GymMembership {
    private boolean personalTrainerAvailable;
    private int personalTrainerSessions; // per month
    private boolean spaAccess;
    private boolean nutritionConsultation;
    private boolean lockerAccess;

    // Constructor
    public PremiumMembership(String memberName, int durationMonths, LocalDate startDate,
            boolean personalTrainerAvailable, int personalTrainerSessions,
            boolean spaAccess, boolean nutritionConsultation, boolean lockerAccess) {
        super(memberName, "Premium", durationMonths, startDate);
        this.personalTrainerAvailable = personalTrainerAvailable;
        this.personalTrainerSessions = personalTrainerSessions;
        this.spaAccess = spaAccess;
        this.nutritionConsultation = nutritionConsultation;
        this.lockerAccess = lockerAccess;
        System.out.println("Premium membership with " + personalTrainerSessions + " trainer sessions/month");
    }

    // Override membership fee calculation for premium features
    @Override
    public double calculateMembershipFee() {
        double baseFee = super.calculateMembershipFee();
        double premiumFee = baseFee;

        // Add charges for premium features
        if (personalTrainerAvailable) {
            premiumFee += personalTrainerSessions * 25.00 * getDurationMonths(); // $25 per session
        }

        if (spaAccess) {
            premiumFee += 30.00 * getDurationMonths(); // $30 per month for spa
        }

        if (nutritionConsultation) {
            premiumFee += 50.00 * getDurationMonths(); // $50 per month for nutrition
        }

        if (lockerAccess) {
            premiumFee += 10.00 * getDurationMonths(); // $10 per month for locker
        }

        return premiumFee;
    }

    // Override special offers check for premium members
    @Override
    public void checkSpecialOffers() {
        super.checkSpecialOffers(); // Call parent's offers

        System.out.println("\n--- PREMIUM EXCLUSIVE OFFERS ---");

        // Premium-specific offers
        if (personalTrainerAvailable && personalTrainerSessions < 8) {
            System.out.println("💪 UPGRADE OFFER: Get 4 extra trainer sessions for just $50/month!");
        }

        if (!spaAccess) {
            System.out.println("🧖 SPA PACKAGE: Add spa access for only $20/month (regular $30)!");
        }

        if (!nutritionConsultation) {
            System.out.println("🥗 NUTRITION DEAL: Add nutrition consultation for $35/month (regular $50)!");
        }

        // Loyalty rewards for long-term premium members
        if (getDurationMonths() >= 12) {
            System.out.println("⭐ LOYALTY REWARD: Free locker access for annual premium membership!");
        }
    }

    // Add personal trainer sessions
    public void addTrainerSessions(int additionalSessions) {
        if (isActive() && additionalSessions > 0) {
            personalTrainerSessions += additionalSessions;
            System.out.println("✓ Added " + additionalSessions + " trainer sessions");
            System.out.println("  Total sessions per month: " + personalTrainerSessions);
            System.out.println("  Additional monthly cost: $" + (additionalSessions * 25.00));
        } else {
            System.out.println("✗ Cannot add sessions to inactive membership!");
        }
    }

    // Add spa access
    public void addSpaAccess() {
        if (isActive() && !spaAccess) {
            spaAccess = true;
            System.out.println("✓ Spa access added to membership");
            System.out.println("  Additional monthly cost: $30.00");
        } else if (spaAccess) {
            System.out.println("Spa access is already included");
        } else {
            System.out.println("✗ Cannot modify inactive membership!");
        }
    }

    // Add nutrition consultation
    public void addNutritionConsultation() {
        if (isActive() && !nutritionConsultation) {
            nutritionConsultation = true;
            System.out.println("✓ Nutrition consultation added to membership");
            System.out.println("  Additional monthly cost: $50.00");
        } else if (nutritionConsultation) {
            System.out.println("Nutrition consultation is already included");
        } else {
            System.out.println("✗ Cannot modify inactive membership!");
        }
    }

    // Calculate total value of premium benefits
    public double calculateBenefitsValue() {
        double value = 0;

        if (personalTrainerAvailable) {
            value += personalTrainerSessions * 25.00 * getDurationMonths();
        }

        if (spaAccess) {
            value += 30.00 * getDurationMonths();
        }

        if (nutritionConsultation) {
            value += 50.00 * getDurationMonths();
        }

        if (lockerAccess) {
            value += 10.00 * getDurationMonths();
        }

        return value;
    }

    // Override displayMembershipDetails to show premium specific information
    @Override
    public void displayMembershipDetails() {
        System.out.println("\n=== PREMIUM MEMBERSHIP DETAILS ===");
        super.displayMembershipDetails();
        System.out.println("Personal Trainer: " + (personalTrainerAvailable ? "Yes" : "No"));
        System.out.println("Trainer Sessions/Month: " + personalTrainerSessions);
        System.out.println("Spa Access: " + (spaAccess ? "Yes" : "No"));
        System.out.println("Nutrition Consultation: " + (nutritionConsultation ? "Yes" : "No"));
        System.out.println("Locker Access: " + (lockerAccess ? "Yes" : "No"));
        System.out.println("Benefits Value: $" + String.format("%.2f", calculateBenefitsValue()));
        System.out.println("Savings: $" + String.format("%.2f",
                (calculateBenefitsValue() - (calculateMembershipFee() - super.calculateMembershipFee()))));

        // Premium-specific insights
        if (isAboutToExpire()) {
            System.out.println("🔔 Premium membership expiring soon! Renew to keep your benefits.");
        }

        if (personalTrainerSessions == 0 && personalTrainerAvailable) {
            System.out.println("💡 Consider adding trainer sessions to maximize your premium membership!");
        }
    }

    // Premium-specific method: calculate fitness score based on usage
    public int calculateFitnessScore() {
        int score = 0;

        if (personalTrainerAvailable && personalTrainerSessions > 0) {
            score += personalTrainerSessions * 10;
        }

        if (spaAccess) {
            score += 20; // Recovery benefits
        }

        if (nutritionConsultation) {
            score += 30; // Nutrition benefits
        }

        // Bonus for long-term commitment
        if (getDurationMonths() >= 6) {
            score += 25;
        }

        return Math.min(score, 100); // Cap at 100
    }

    // Premium-specific method: check if elite package (all features)
    public boolean isElitePackage() {
        return personalTrainerAvailable && spaAccess && nutritionConsultation && lockerAccess;
    }

    // Getters
    public boolean isPersonalTrainerAvailable() {
        return personalTrainerAvailable;
    }

    public int getPersonalTrainerSessions() {
        return personalTrainerSessions;
    }

    public boolean hasSpaAccess() {
        return spaAccess;
    }

    public boolean hasNutritionConsultation() {
        return nutritionConsultation;
    }

    public boolean hasLockerAccess() {
        return lockerAccess;
    }
}
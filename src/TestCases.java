package smartuniversityportal;

/**
 * TestCases.java
 * Unit Testing for Smart University Portal
 * Tests core business logic methods without requiring database connection.
 *
 * Author: Tanisha Jain
 * Reg No: 2314513802
 *
 * NOTE: These are standalone unit tests.
 * To run: Right-click file in NetBeans → Run File
 * No JUnit library needed — uses simple assertion pattern.
 */
public class TestCases {

    static int passed = 0;
    static int failed = 0;

    // =========================================================================
    // HELPER: Simple assert method
    // =========================================================================
    static void assertEqual(String testName, String expected, String actual) {
        if (expected.equals(actual)) {
            System.out.println("✅ PASS: " + testName);
            passed++;
        } else {
            System.out.println("❌ FAIL: " + testName);
            System.out.println("   Expected : " + expected);
            System.out.println("   Got      : " + actual);
            failed++;
        }
    }

    static void assertTrue(String testName, boolean condition) {
        if (condition) {
            System.out.println("✅ PASS: " + testName);
            passed++;
        } else {
            System.out.println("❌ FAIL: " + testName);
            failed++;
        }
    }

    // =========================================================================
    // TEST GROUP 1: Grade Calculation
    // =========================================================================
    static void testGradeCalculation() {
        System.out.println("\n--- Test Group 1: Grade Calculation ---");

        assertEqual("Grade for 95 marks should be A+",
                "Predicted Grade: A+ (Distinction)",
                AIRecommendation.predictGrade(95, 100));

        assertEqual("Grade for 82 marks should be A",
                "Predicted Grade: A (Very Good)",
                AIRecommendation.predictGrade(82, 100));

        assertEqual("Grade for 73 marks should be B+",
                "Predicted Grade: B+ (Good)",
                AIRecommendation.predictGrade(73, 100));

        assertEqual("Grade for 65 marks should be B",
                "Predicted Grade: B (Above Average)",
                AIRecommendation.predictGrade(65, 100));

        assertEqual("Grade for 28 marks should be F",
                "Predicted Grade: F (Fail — Immediate Action Required)",
                AIRecommendation.predictGrade(28, 100));
    }

    // =========================================================================
    // TEST GROUP 2: Attendance Recommendation
    // =========================================================================
    static void testAttendanceRecommendation() {
        System.out.println("\n--- Test Group 2: Attendance Recommendation ---");

        assertEqual("90% attendance should be Excellent",
                "✅ Excellent Attendance! Keep maintaining this consistency.",
                AIRecommendation.getAttendanceRecommendation(90));

        assertEqual("78% attendance should be Good",
                "🟡 Good Attendance. Try to attend a few more classes to stay above 85%.",
                AIRecommendation.getAttendanceRecommendation(78));

        assertEqual("62% attendance should be Average",
                "⚠️ Average Attendance. You are close to the minimum threshold. Improvement needed.",
                AIRecommendation.getAttendanceRecommendation(62));

        assertEqual("45% attendance should be Critical",
                "🔴 Critical: Attendance below 60%. Immediate improvement required. Risk of exam debarment.",
                AIRecommendation.getAttendanceRecommendation(45));
    }

    // =========================================================================
    // TEST GROUP 3: Risk Level Assessment
    // =========================================================================
    static void testRiskAssessment() {
        System.out.println("\n--- Test Group 3: Risk Assessment ---");

        assertEqual("High attendance + High marks = Low Risk",
                "🟢 Low Risk — Student is performing well in both attendance and academics.",
                AIRecommendation.getRiskLevel(90, 85));

        assertEqual("Medium attendance + Medium marks = Medium Risk",
                "🟡 Medium Risk — Student needs improvement in attendance or academics.",
                AIRecommendation.getRiskLevel(65, 50));

        assertEqual("Low attendance + Low marks = High Risk",
                "🔴 High Risk — Student requires immediate intervention in attendance and/or academics.",
                AIRecommendation.getRiskLevel(40, 30));
    }

    // =========================================================================
    // TEST GROUP 4: Fee Status Recommendation
    // =========================================================================
    static void testFeeRecommendation() {
        System.out.println("\n--- Test Group 4: Fee Status Recommendation ---");

        assertEqual("Paid fee should show cleared message",
                "✅ Fee Cleared. No action required.",
                AIRecommendation.getFeeRecommendation("Paid"));

        assertEqual("Pending fee should show warning",
                "🟡 Fee Payment Pending. Please pay before the due date to avoid penalty.",
                AIRecommendation.getFeeRecommendation("Pending"));

        assertEqual("Overdue fee should show urgent message",
                "🔴 Fee Overdue! Immediate payment required. Contact administration.",
                AIRecommendation.getFeeRecommendation("Overdue"));
    }

    // =========================================================================
    // TEST GROUP 5: Performance Recommendation
    // =========================================================================
    static void testPerformanceRecommendation() {
        System.out.println("\n--- Test Group 5: Performance Recommendation ---");

        assertEqual("85 marks should be Excellent",
                "✅ Excellent Performance! You are among the top performers.",
                AIRecommendation.getPerformanceRecommendation(85, 100));

        assertEqual("65 marks should be Good",
                "🟡 Good Performance. Focus on weak topics to reach the next grade level.",
                AIRecommendation.getPerformanceRecommendation(65, 100));

        assertEqual("35 marks should be At Risk",
                "🔴 At Risk: Marks below passing threshold. Immediate academic support required.",
                AIRecommendation.getPerformanceRecommendation(35, 100));
    }

    // =========================================================================
    // TEST GROUP 6: Boundary / Edge Cases
    // =========================================================================
    static void testEdgeCases() {
        System.out.println("\n--- Test Group 6: Edge Cases ---");

        // Exact boundary values
        assertEqual("Exactly 85% attendance = Excellent",
                "✅ Excellent Attendance! Keep maintaining this consistency.",
                AIRecommendation.getAttendanceRecommendation(85.0));

        assertEqual("Exactly 75% attendance = Good",
                "🟡 Good Attendance. Try to attend a few more classes to stay above 85%.",
                AIRecommendation.getAttendanceRecommendation(75.0));

        assertEqual("0 marks = F grade",
                "Predicted Grade: F (Fail — Immediate Action Required)",
                AIRecommendation.predictGrade(0, 100));

        assertEqual("100 marks = A+ grade",
                "Predicted Grade: A+ (Distinction)",
                AIRecommendation.predictGrade(100, 100));

        assertEqual("Unknown fee status",
                "ℹ️ Fee status unknown. Please contact administration.",
                AIRecommendation.getFeeRecommendation("Unknown"));
    }

    // =========================================================================
    // MAIN - Run all tests
    // =========================================================================
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║   Smart University Portal — Unit Test Suite  ║");
        System.out.println("║   Student: Tanisha Jain | Reg: 2314513802    ║");
        System.out.println("╚══════════════════════════════════════════════╝");

        testGradeCalculation();
        testAttendanceRecommendation();
        testRiskAssessment();
        testFeeRecommendation();
        testPerformanceRecommendation();
        testEdgeCases();

        System.out.println("\n══════════════════════════════════════════════");
        System.out.println("TEST RESULTS:");
        System.out.println("  Total Tests : " + (passed + failed));
        System.out.println("  ✅ Passed   : " + passed);
        System.out.println("  ❌ Failed   : " + failed);
        System.out.println("  Pass Rate   : " + String.format("%.0f", (passed * 100.0 / (passed + failed))) + "%");
        System.out.println("══════════════════════════════════════════════");
    }
}

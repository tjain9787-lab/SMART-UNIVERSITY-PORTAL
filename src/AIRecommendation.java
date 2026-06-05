package smartuniversityportal;

/**
 * AIRecommendation.java
 * Rule-based AI module for Smart University Portal
 * Provides intelligent recommendations based on student attendance and academic performance.
 *
 * Author: Tanisha Jain
 * Reg No: 2314513802
 */
public class AIRecommendation {

    // ─── Attendance Thresholds ───────────────────────────────────────────────
    private static final double ATTENDANCE_EXCELLENT  = 85.0;
    private static final double ATTENDANCE_GOOD       = 75.0;
    private static final double ATTENDANCE_AVERAGE    = 60.0;
    // Below 60 = At Risk

    // ─── Marks Thresholds ────────────────────────────────────────────────────
    private static final int MARKS_EXCELLENT  = 80;
    private static final int MARKS_GOOD       = 60;
    private static final int MARKS_AVERAGE    = 40;
    // Below 40 = Fail Risk

    // =========================================================================
    // 1. ATTENDANCE RECOMMENDATION
    // =========================================================================

    /**
     * Returns AI recommendation based on attendance percentage.
     * @param attendancePercent - student's attendance percentage (0-100)
     * @return String recommendation message
     */
    public static String getAttendanceRecommendation(double attendancePercent) {
        if (attendancePercent >= ATTENDANCE_EXCELLENT) {
            return "✅ Excellent Attendance! Keep maintaining this consistency.";
        } else if (attendancePercent >= ATTENDANCE_GOOD) {
            return "🟡 Good Attendance. Try to attend a few more classes to stay above 85%.";
        } else if (attendancePercent >= ATTENDANCE_AVERAGE) {
            return "⚠️ Average Attendance. You are close to the minimum threshold. Improvement needed.";
        } else {
            return "🔴 Critical: Attendance below 60%. Immediate improvement required. Risk of exam debarment.";
        }
    }

    // =========================================================================
    // 2. ACADEMIC PERFORMANCE RECOMMENDATION
    // =========================================================================

    /**
     * Returns AI recommendation based on marks obtained.
     * @param marks     - marks obtained by student
     * @param totalMarks - maximum marks
     * @return String recommendation message
     */
    public static String getPerformanceRecommendation(int marks, int totalMarks) {
        double percentage = (marks * 100.0) / totalMarks;

        if (percentage >= MARKS_EXCELLENT) {
            return "✅ Excellent Performance! You are among the top performers.";
        } else if (percentage >= MARKS_GOOD) {
            return "🟡 Good Performance. Focus on weak topics to reach the next grade level.";
        } else if (percentage >= MARKS_AVERAGE) {
            return "⚠️ Average Performance. Dedicated study and revision sessions are recommended.";
        } else {
            return "🔴 At Risk: Marks below passing threshold. Immediate academic support required.";
        }
    }

    // =========================================================================
    // 3. OVERALL STUDENT RISK ASSESSMENT
    // =========================================================================

    /**
     * Combines attendance and marks to give an overall student risk level.
     * @param attendancePercent - student's attendance percentage
     * @param averageMarks      - student's average marks percentage
     * @return String risk level: "Low Risk", "Medium Risk", "High Risk"
     */
    public static String getRiskLevel(double attendancePercent, double averageMarks) {
        if (attendancePercent >= ATTENDANCE_GOOD && averageMarks >= MARKS_GOOD) {
            return "🟢 Low Risk — Student is performing well in both attendance and academics.";
        } else if (attendancePercent >= ATTENDANCE_AVERAGE && averageMarks >= MARKS_AVERAGE) {
            return "🟡 Medium Risk — Student needs improvement in attendance or academics.";
        } else {
            return "🔴 High Risk — Student requires immediate intervention in attendance and/or academics.";
        }
    }

    // =========================================================================
    // 4. FEE STATUS RECOMMENDATION
    // =========================================================================

    /**
     * Returns reminder message based on fee payment status.
     * @param status - "Paid", "Pending", or "Overdue"
     * @return String recommendation message
     */
    public static String getFeeRecommendation(String status) {
        switch (status) {
            case "Paid":
                return "✅ Fee Cleared. No action required.";
            case "Pending":
                return "🟡 Fee Payment Pending. Please pay before the due date to avoid penalty.";
            case "Overdue":
                return "🔴 Fee Overdue! Immediate payment required. Contact administration.";
            default:
                return "ℹ️ Fee status unknown. Please contact administration.";
        }
    }

    // =========================================================================
    // 5. GRADE PREDICTION (Simple Rule-Based)
    // =========================================================================

    /**
     * Predicts expected grade based on current marks trend.
     * @param currentMarks - marks obtained so far
     * @param totalMarks   - maximum marks
     * @return String predicted grade
     */
    public static String predictGrade(int currentMarks, int totalMarks) {
        double pct = (currentMarks * 100.0) / totalMarks;

        if (pct >= 90) return "Predicted Grade: A+ (Distinction)";
        else if (pct >= 80) return "Predicted Grade: A (Very Good)";
        else if (pct >= 70) return "Predicted Grade: B+ (Good)";
        else if (pct >= 60) return "Predicted Grade: B (Above Average)";
        else if (pct >= 50) return "Predicted Grade: C+ (Average)";
        else if (pct >= 40) return "Predicted Grade: C (Pass)";
        else if (pct >= 33) return "Predicted Grade: D (Borderline Pass)";
        else return "Predicted Grade: F (Fail — Immediate Action Required)";
    }

    // =========================================================================
    // MAIN - For quick testing
    // =========================================================================
    public static void main(String[] args) {
        System.out.println("=== AI Recommendation Engine Test ===\n");

        // Test 1: Attendance
        System.out.println("--- Attendance Recommendations ---");
        System.out.println("90%: " + getAttendanceRecommendation(90));
        System.out.println("78%: " + getAttendanceRecommendation(78));
        System.out.println("62%: " + getAttendanceRecommendation(62));
        System.out.println("45%: " + getAttendanceRecommendation(45));

        System.out.println("\n--- Performance Recommendations ---");
        System.out.println("85/100: " + getPerformanceRecommendation(85, 100));
        System.out.println("65/100: " + getPerformanceRecommendation(65, 100));
        System.out.println("38/100: " + getPerformanceRecommendation(38, 100));

        System.out.println("\n--- Risk Assessment ---");
        System.out.println("Att:90, Marks:85: " + getRiskLevel(90, 85));
        System.out.println("Att:65, Marks:50: " + getRiskLevel(65, 50));
        System.out.println("Att:40, Marks:30: " + getRiskLevel(40, 30));

        System.out.println("\n--- Fee Recommendations ---");
        System.out.println("Paid:    " + getFeeRecommendation("Paid"));
        System.out.println("Pending: " + getFeeRecommendation("Pending"));
        System.out.println("Overdue: " + getFeeRecommendation("Overdue"));

        System.out.println("\n--- Grade Predictions ---");
        System.out.println("82/100: " + predictGrade(82, 100));
        System.out.println("55/100: " + predictGrade(55, 100));
        System.out.println("29/100: " + predictGrade(29, 100));
    }
}

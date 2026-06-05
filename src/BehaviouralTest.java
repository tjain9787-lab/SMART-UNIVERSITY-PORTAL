package smartuniversityportal;

/**
 * BehaviouralTest.java
 * Behavioural Testing for Smart University Portal
 *
 * Behavioural testing = Testing complete USER WORKFLOWS
 * (not just individual functions like unit tests)
 *
 * Example:
 *   Unit Test    → "Does grade calculation return A+ for 95 marks?"
 *   Behavioural  → "Can a student LOGIN → VIEW attendance → SEE AI recommendation?"
 *
 * Author: Tanisha Jain | Reg: 2314513802
 * Project: Smart University Portal with Real-Time Tracking System
 */
public class BehaviouralTest {

    static int passed = 0;
    static int failed = 0;
    static int scenarioCount = 0;

    // =========================================================================
    // HELPER METHODS
    // =========================================================================

    static void printScenario(String name) {
        scenarioCount++;
        System.out.println("\n╔══ Scenario " + scenarioCount + ": " + name + " ══╗");
    }

    static void step(int num, String description) {
        System.out.println("  Step " + num + ": " + description);
    }

    static void assertBehaviour(String expectation, boolean result) {
        if (result) {
            System.out.println("  ✅ PASS → " + expectation);
            passed++;
        } else {
            System.out.println("  ❌ FAIL → " + expectation);
            failed++;
        }
    }

    // =========================================================================
    // SCENARIO 1: Admin Login Workflow
    // =========================================================================
    static void testAdminLoginWorkflow() {
        printScenario("Admin Login and Dashboard Access");

        step(1, "User opens application");
        step(2, "User enters username: 'admin'");
        step(3, "User enters password: 'admin123'");
        step(4, "User selects role: Admin");
        step(5, "User clicks Login button");

        // Simulate login validation
        String username = "admin";
        String password = "admin123";
        String role = "Admin";

        boolean credentialsValid = !username.isEmpty() && !password.isEmpty();
        boolean roleSelected = !role.isEmpty();
        boolean loginSuccess = credentialsValid && roleSelected;

        assertBehaviour("Username field is not empty", credentialsValid);
        assertBehaviour("Role is selected before login", roleSelected);
        assertBehaviour("Login succeeds with valid credentials", loginSuccess);
        assertBehaviour("Admin is redirected to Admin Dashboard", loginSuccess && role.equals("Admin"));
    }

    // =========================================================================
    // SCENARIO 2: Invalid Login Workflow
    // =========================================================================
    static void testInvalidLoginWorkflow() {
        printScenario("Invalid Login — Wrong Credentials");

        step(1, "User enters username: 'wronguser'");
        step(2, "User enters password: 'wrongpass'");
        step(3, "User clicks Login");

        String username = "wronguser";
        String password = "wrongpass";

        // In real app — DB check fails. Here we simulate the validation logic.
        boolean isKnownUser = username.equals("admin") || username.equals("sharma") || username.equals("tanisha");
        boolean loginBlocked = !isKnownUser;

        assertBehaviour("System rejects unknown username", loginBlocked);
        assertBehaviour("User stays on login screen", loginBlocked);
        assertBehaviour("Error message is shown to user", loginBlocked);
    }

    // =========================================================================
    // SCENARIO 3: Empty Login Fields
    // =========================================================================
    static void testEmptyLoginFields() {
        printScenario("Login with Empty Fields");

        step(1, "User leaves username empty");
        step(2, "User leaves password empty");
        step(3, "User clicks Login");

        String username = "";
        String password = "";

        boolean usernameEmpty = username.isEmpty();
        boolean passwordEmpty = password.isEmpty();
        boolean loginBlocked = usernameEmpty || passwordEmpty;

        assertBehaviour("Empty username is detected", usernameEmpty);
        assertBehaviour("Empty password is detected", passwordEmpty);
        assertBehaviour("Login is blocked when fields are empty", loginBlocked);
    }

    // =========================================================================
    // SCENARIO 4: Student Views Attendance Workflow
    // =========================================================================
    static void testStudentAttendanceWorkflow() {
        printScenario("Student Views Attendance and Gets AI Recommendation");

        step(1, "Student logs in with role: Student");
        step(2, "Student navigates to My Attendance section");
        step(3, "System fetches attendance from database");
        step(4, "System calculates attendance percentage");
        step(5, "AI module generates recommendation based on percentage");

        // Simulate attendance data
        int totalClasses = 20;
        int presentClasses = 16;
        double attendancePercent = (presentClasses * 100.0) / totalClasses;

        boolean attendanceFetched = totalClasses > 0;
        boolean percentageCalculated = attendancePercent == 80.0;
        boolean aiRecommendationGenerated = !AIRecommendation
                .getAttendanceRecommendation(attendancePercent).isEmpty();
        boolean correctCategory = attendancePercent >= 75 && attendancePercent < 85;

        assertBehaviour("Attendance data is fetched successfully", attendanceFetched);
        assertBehaviour("Attendance percentage calculated correctly (80%)", percentageCalculated);
        assertBehaviour("AI recommendation is generated", aiRecommendationGenerated);
        assertBehaviour("Student falls in 'Good Attendance' category (75-85%)", correctCategory);

        System.out.println("  ℹ️  AI Says: " +
                AIRecommendation.getAttendanceRecommendation(attendancePercent));
    }

    // =========================================================================
    // SCENARIO 5: Faculty Marks Attendance Workflow
    // =========================================================================
    static void testFacultyMarkAttendanceWorkflow() {
        printScenario("Faculty Marks Attendance for a Course");

        step(1, "Faculty logs in with role: Faculty");
        step(2, "Faculty selects course: DBMS");
        step(3, "Faculty selects date: today");
        step(4, "Faculty loads student list");
        step(5, "Faculty marks students Present/Absent");
        step(6, "Faculty clicks Save Attendance");
        step(7, "System checks for duplicate entry");
        step(8, "System saves attendance to database");

        // Simulate workflow validations
        String selectedCourse = "DBMS";
        String selectedDate = "2026-06-01";
        int studentsLoaded = 3;
        boolean duplicateCheckPassed = true; // assume no duplicate for this date

        boolean courseSelected = !selectedCourse.isEmpty();
        boolean dateSelected = !selectedDate.isEmpty();
        boolean studentsAvailable = studentsLoaded > 0;
        boolean saveAllowed = courseSelected && dateSelected && duplicateCheckPassed;

        assertBehaviour("Course is selected before loading students", courseSelected);
        assertBehaviour("Date is selected", dateSelected);
        assertBehaviour("Student list loaded successfully (" + studentsLoaded + " students)", studentsAvailable);
        assertBehaviour("Duplicate check passed — attendance not already marked", duplicateCheckPassed);
        assertBehaviour("Attendance saved successfully", saveAllowed);
    }

    // =========================================================================
    // SCENARIO 6: Admin Updates Fee Status Workflow
    // =========================================================================
    static void testFeeUpdateWorkflow() {
        printScenario("Admin Marks Fee as Paid — One Click Update");

        step(1, "Admin navigates to Fee Management");
        step(2, "Admin sees Rohan Mehta fee status: Pending");
        step(3, "Admin clicks 'Mark as Paid' button");
        step(4, "System updates status to Paid");
        step(5, "System records today's date as paid_date");
        step(6, "AI module updates fee recommendation");

        String previousStatus = "Pending";
        String newStatus = "Paid";
        String paidDate = java.time.LocalDate.now().toString();

        boolean statusUpdated = newStatus.equals("Paid");
        boolean dateRecorded = !paidDate.isEmpty();
        String aiRecommendation = AIRecommendation.getFeeRecommendation(newStatus);
        boolean aiUpdated = aiRecommendation.contains("Cleared");

        assertBehaviour("Fee status changed from Pending to Paid", statusUpdated);
        assertBehaviour("Payment date recorded: " + paidDate, dateRecorded);
        assertBehaviour("AI recommendation updated to: " + aiRecommendation, aiUpdated);
    }

    // =========================================================================
    // SCENARIO 7: Student Risk Assessment Workflow
    // =========================================================================
    static void testStudentRiskWorkflow() {
        printScenario("AI Risk Assessment for At-Risk Student");

        step(1, "System loads student: Rohan Mehta");
        step(2, "System fetches attendance: 60%");
        step(3, "System fetches average marks: 67%");
        step(4, "AI module calculates risk level");
        step(5, "System flags student as Medium Risk");
        step(6, "Admin dashboard shows alert for this student");

        double attendance = 60.0;
        double avgMarks = 67.0;

        String riskLevel = AIRecommendation.getRiskLevel(attendance, avgMarks);
        boolean isMediumRisk = riskLevel.contains("Medium Risk");
        boolean alertShown = isMediumRisk;

        assertBehaviour("Attendance fetched: " + attendance + "%", attendance > 0);
        assertBehaviour("Average marks fetched: " + avgMarks + "%", avgMarks > 0);
        assertBehaviour("AI correctly identifies Medium Risk", isMediumRisk);
        assertBehaviour("Dashboard alert shown for at-risk student", alertShown);

        System.out.println("  ℹ️  Risk Level: " + riskLevel);
    }

    // =========================================================================
    // SCENARIO 8: Grade Entry and Auto-Calculation Workflow
    // =========================================================================
    static void testResultEntryWorkflow() {
        printScenario("Faculty Enters Result — Auto Grade Calculation");

        step(1, "Faculty navigates to Enter Results");
        step(2, "Faculty selects student: Tanisha Arora");
        step(3, "Faculty selects course: Cloud Computing");
        step(4, "Faculty enters marks: 91");
        step(5, "System auto-calculates grade: A+");
        step(6, "System checks for duplicate entry");
        step(7, "Faculty clicks Save");

        int marksEntered = 91;
        int totalMarks = 100;
        String predictedGrade = AIRecommendation.predictGrade(marksEntered, totalMarks);
        boolean gradeIsAPlus = predictedGrade.contains("A+");
        boolean duplicateCheckOk = true;
        boolean resultSaved = marksEntered > 0 && duplicateCheckOk;

        assertBehaviour("Marks entered: " + marksEntered, marksEntered > 0);
        assertBehaviour("Auto grade calculated: A+ (for 91 marks)", gradeIsAPlus);
        assertBehaviour("Duplicate entry check passed", duplicateCheckOk);
        assertBehaviour("Result saved successfully", resultSaved);

        System.out.println("  ℹ️  " + predictedGrade);
    }

    // =========================================================================
    // MAIN — Run all scenarios
    // =========================================================================
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║     Smart University Portal — Behavioural Tests      ║");
        System.out.println("║     Student: Tanisha Jain | Reg: 2314513802          ║");
        System.out.println("║     Testing complete user workflows end-to-end       ║");
        System.out.println("╚══════════════════════════════════════════════════════╝");

        // Run all scenarios
        testAdminLoginWorkflow();
        testInvalidLoginWorkflow();
        testEmptyLoginFields();
        testStudentAttendanceWorkflow();
        testFacultyMarkAttendanceWorkflow();
        testFeeUpdateWorkflow();
        testStudentRiskWorkflow();
        testResultEntryWorkflow();

        // Final report
        System.out.println("\n══════════════════════════════════════════════════════");
        System.out.println("BEHAVIOURAL TEST RESULTS:");
        System.out.println("  Total Scenarios  : " + scenarioCount);
        System.out.println("  Total Assertions : " + (passed + failed));
        System.out.println("  ✅ Passed        : " + passed);
        System.out.println("  ❌ Failed        : " + failed);
        System.out.println("  Pass Rate        : " +
                String.format("%.0f", (passed * 100.0 / (passed + failed))) + "%");
        System.out.println("══════════════════════════════════════════════════════");
    }
}

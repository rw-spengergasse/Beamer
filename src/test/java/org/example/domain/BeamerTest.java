package org.example.domain;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

// JUNIT Slogan
// Keep the bar green to keep the code clean

// GWT / AAA
// Given (Arrange)
// When (Act)
// Then (Assert)


// F.I.R.S.T PRINCIPLE of Unit Tests
// - Fast
//   Execute within seconds
//
// - Isolated
//  Given, When, Then
//
// - Repeatable
//  Deterministic with Test-Fixtures
//
// - Self-Validating
//  No manual testing
//
// - Thorough
//   Should cover all happy paths
//   Should cover illegal arguments
//   Should cover edge cases

// @TestInstance is needed such that @BeforeAll and @AfterAll don't need to be static methods
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BeamerTest
{
    // Test Fixtures
    private Beamer beamer;
    private ByteArrayOutputStream newOut;

    // -------------------

    // Is executed BEFORE ALL Tests
    @BeforeAll
    public void setupAll()
    {
        // Let the System.out from the console redirect to a PrintStream,
        // which we can then use to check our console messages in the Beamer Class.

        // What Streams are, is covered in the 2nd Semester (-> FileHandling)

        newOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(newOut));
    }

    // Executed AFTER ALL Tests
    @AfterAll
    public void teardownAll()
    {
        System.setOut(null);
    }

    // -------------------

    // Executed BEFORE EACH Test, to prepare the TestFixture(s)
    @BeforeEach
    public void setup()
    {
        beamer = new Beamer("C2.14", 1);
    }

    // Executed AFTER EACH Test, to clean up stuff after each test
    @AfterEach
    public void teardown()
    {
    }

    // -------------------

    @Test
    public void setRaum_shouldSetCurrentValue()
    {
        // GIVEN
        // Beamer beamer = new Beamer("C2.14", 1);

        // WHEN
        beamer.setRaum("C1.13");

        // THEN
        // assertEquals ( expectedValue, actualValue )
        assertEquals("C1.13", beamer.getRaum());
    }

    @Test
    public void setRaum_shouldFailWithNullValue()
    {
        // GIVEN
        // Beamer beamer = new Beamer("C2.14", 1);

        // WHEN
        beamer.setRaum(null);

        // THEN
        // assertEquals ( expectedValue, actualValue )
        assertEquals("C2.14", beamer.getRaum());
        assertEquals("Fehler: raum ist null\n", newOut.toString());
    }

    @Test
    public void ausschalten_shouldWorkIfEingeschaltet()
    {
        // GIVEN
        // Beamer beamer = new Beamer("C2.14", 1);
        beamer.einschalten();

        // WHEN
        beamer.ausschalten();

        // THEN
        // assertEquals ( expectedValue, actualValue )
        assertFalse(beamer.isEingeschaltet());
    }
}
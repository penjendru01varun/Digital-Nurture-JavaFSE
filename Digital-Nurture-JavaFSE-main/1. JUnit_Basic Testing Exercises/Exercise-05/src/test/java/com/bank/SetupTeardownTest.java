package com.bank;

import org.junit.*;
import static org.junit.Assert.*;

public class SetupTeardownTest {

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("@BeforeClass - runs once before any of the test methods in the class");
    }

    @AfterClass
    public static void tearDownAfterClass() {
        System.out.println("@AfterClass - runs once after all the test methods in the class have been run");
    }

    @Before
    public void setUp() {
        System.out.println("@Before - runs before each test method");
    }

    @After
    public void tearDown() {
        System.out.println("@After - runs after each test method");
    }

    @Test
    public void testOne() {
        System.out.println("Executing Test One");
        assertTrue(true);
    }

    @Test
    public void testTwo() {
        System.out.println("Executing Test Two");
        assertNotNull("JUnit");
    }
}

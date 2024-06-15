package com.example.OnetoManyDemo;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;



import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestResult;
import junit.framework.TestSuite;



/**
 * Unit test for simple App.
 */
public class AppTest  extends TestCase 
{
	public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

  
}

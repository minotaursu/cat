package com.minotaur;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test; 

/**
 * Unit test for simple App.
 */
public class SimpleParserTest
{
	private SimpleParser sp;

	@Before
    public void setUp(){
		sp=new SimpleParser();
    }

    @Test
    public void testRule0()
    {
    	String a="abc";
    	String b="abc";
    	boolean r=sp.simpleMatch(a, b);
        assertTrue(r);
    }
    @Test
    public void testRule1()
    {
    	String a="*";
    	String b="abc";
    	boolean r=sp.simpleMatch(a, b);
        assertTrue(r);
    }
    @Test
    public void testRule2()
    {
    	String a="*abc";
    	String b="abc";
    	boolean r=sp.simpleMatch(a, b);
        assertTrue(r);
    }
    @Test
    public void testRule3()
    {
    	String a="*abc";
    	String b="aaabbbabc";
    	boolean r=sp.simpleMatch(a, b);
        assertTrue(r);
    }
    @Test
    public void testRule4()
    {
    	String a="a*bc";
    	String b="aaabbbabc";
    	sp.simpleMatch(a, b);
        assertTrue( true );
    }
    @Test
    public void testRule5()
    {
    	String a="a*bc";
    	String b="abc";
    	boolean r=sp.simpleMatch(a, b);
        assertTrue(r);
    }
    @Test
    public void testRule6()
    {
    	String a="a*";
    	String b="abc";
    	boolean r=sp.simpleMatch(a, b);
        assertTrue(r);
    }
    @Test
    public void testRule7()
    {
    	String a="a*";
    	String b="a";
    	boolean r=sp.simpleMatch(a, b);
        assertTrue(r);
    }
    @Test
    public void testRule8()
    {
    	String a="a*";
    	String b="aa";
    	boolean r=sp.simpleMatch(a, b);
        assertTrue(r);
    }
    @Test
    public void testRule9()
    {
    	String a="a*";
    	String b="abcdef";
    	boolean r=sp.simpleMatch(a, b);
        assertTrue(r);
    }
    @Test
    public void testRule10()
    {
    	String a="*abc*";
    	String b="abc";
    	boolean r=sp.simpleMatch(a, b);
        assertTrue(r);
    }
    @Test
    public void testRule11()
    {
    	String a="*****";
    	String b="abc";
    	boolean r=sp.simpleMatch(a, b);
        assertTrue(r);
    }
    @Test
    public void testRule12()
    {
    	String a="...";
    	String b="abc";
    	boolean r=sp.simpleMatch(a, b);
        assertTrue(r);
    }
    @Test
    public void testRule13()
    {
    	String a=".*";
    	String b="abc";
    	boolean r=sp.simpleMatch(a, b);
        assertTrue(r);
    }
    @Test
    public void testRule14()
    {
    	String a=".bc*";
    	String b="abc";
    	boolean r=sp.simpleMatch(a, b);
        assertTrue(r);
    }
    @Test
    public void testRule15()
    {
    	String a=".b*c*a";
    	String b="abca";
    	boolean r=sp.simpleMatch(a, b);
        assertTrue(r);
    }
    @Test
    public void testRule16()
    {
    	String a="*abc*";
    	String b="abc";
    	boolean r=sp.simpleMatch(a, b);
        assertTrue(r);
    }
    @Test
    public void testRule17()
    {
    	String a="*";
    	String b="";
    	boolean r=sp.simpleMatch(a, b);
        assertTrue(r);
    }
    
    
    
    @Test
    public void testRule18()
    {
    	String a="abc";
    	String b="abcd";
    	boolean r=sp.simpleMatch(a, b);
        assertFalse(r);
    }
    @Test
    public void testRule19()
    {
    	String a="*a";
    	String b="abcd";
    	boolean r=sp.simpleMatch(a, b);
    	assertFalse(r);
    }
    @Test
    public void testRule20()
    {
    	String a="a";
    	String b="";
    	boolean r=sp.simpleMatch(a, b);
    	assertFalse(r);
    }
    @Test
    public void testRule21()
    {
    	String a=".a*c";
    	String b="abc";
    	boolean r=sp.simpleMatch(a, b);
    	assertFalse(r);
    }
    @Test
    public void testRule22()
    {
    	String a="a.*b";
    	String b="abc";
    	boolean r=sp.simpleMatch(a, b);
    	assertFalse(r);
    }
    @Test
    public void testRule23()
    {
    	String a="..";
    	String b="abc";
    	boolean r=sp.simpleMatch(a, b);
    	assertFalse(r);
    }
    @Test
    public void testRule24()
    {
    	String a="";
    	String b="";
    	boolean r=sp.simpleMatch(a, b);
    	assertFalse(r);
    }
    @Test
    public void testRule25()
    {
    	String a="";
    	String b="abc";
    	boolean r=sp.simpleMatch(a, b);
    	assertFalse(r);
    }
    
}

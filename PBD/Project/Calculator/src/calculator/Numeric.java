/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

/**
 *
 * @author Christian Choi
 */
public class Numeric {
    public static boolean isNumeric( String s )
	{
		return ( isDouble(s) || isInteger(s) );
	}

	public static boolean isDouble( String s )
	{
		double n = 0;
		try
		{
			n = Double.valueOf( s );
		}

		catch ( NumberFormatException e )
		{
			return false;
		}

		return true;
	}

	public static boolean isInteger( String s )
	{
		int n = 0;
		try
		{
			n = Integer.valueOf( s );
		}

		catch ( NumberFormatException e )
		{
			return false;
		}

		return true;
	}

}
package polytester;

import java.util.Scanner;
/**
 * This class contains the functions to add, subtract, multiply, and represent polynomials in string form.
 * @author Jackson Aucoin
 */
public class Polynomials {
    /**
     * Gives a string representation of this polynomial in standard
     * form where zero terms, coefficients 1 or -1, and the exponents
     * 1 are not displayed.
     * @param coeffs - an array of coefficients in order of descending powers
     * representing a univariate polynomial.
     * @throws IllegalArgumentException when the coeffs.length > 1 and
     * coeffs[0] is 0.
     * @return a string representation of this polynomial
     * <pre>
     * Note: Rules for Representing a Polynomial in Normalized Form:
     * 1. If the degree of the polynomial is 0, return a string
     *    representing the number.
     * 2. If the degree of the polynomial is 1, return a string
     *    representing the polynomial in the form ax + b, where when
     *    b is zero it should not be displayed and when a is -1 or 1
     *    it should not be displayed as a coefficient of x.
     * 3. If the degree of the polynomial is 2 or more, follow these
     *    steps:
     *    A. Generate the string representation of the highest order
     *       term without using 1, -1 as its coefficient.
     *    B. Generate the string representations of all other, but
     *       the last two, terms beginning from the second highest
     *       order term without the use of 1 and -1 as coefficients
     *       and without including a zero term. Then deal with the
     *       last two terms:
     *       i.  If its linear term is non-zero, generate and append
     *           the linear term but without the use of 1 and -1 as
     *           its coefficient and 1 as its exponent.
     *       ii. Finally, append the constant term, the lowest order
     *           term, if it is non-zero.
     * eg: [3, 0, -1, 0, 1, 1, 0] -> 3x^6 - x^4 + x^2 + x
     *     [-1, 0, 3, 0, -1, 1] -> -x^5 + 3x^3 - x + 1
     * </pre>
     */
    public static String toString(double[] coeffs)
    {
        if (coeffs.length > 1 && coeffs[0] == 0)
            throw new IllegalArgumentException("toString(): Invalid Polynomial");
        int deg = coeffs.length-1;
        String pStr = "";
        if (deg == 0)
            pStr += coeffs[0];
        else if (deg == 1)
        {
            if (coeffs[0] == 1)
                pStr += "x";
            else if (coeffs[0] == -1)
                pStr += "-x";
            else
                pStr += coeffs[0] + "x";
            if (coeffs[1] != 0)
            {
                if (coeffs[1] > 0)
                    pStr += " + " + coeffs[1];
                else
                    pStr += " - " + (-coeffs[1]);
            }
        }
        else
        {
            int pwr = coeffs.length-1;
            if (coeffs[0] == 1)
                pStr += "x^" + pwr;
            else if (coeffs[0] == -1)
                pStr += "-x^" + pwr;
            else
                pStr += (coeffs[0] + "x^" + pwr);
            pwr--;
            int i;
            for (i = 1; i < coeffs.length - 2; i++)
            {
                if (coeffs[i] != 0)
                {
                    if (coeffs[i] == 1)
                        pStr += " + x^" + pwr;
                    else if (coeffs[i] == -1)
                        pStr += " - x^" + pwr;
                    else if (coeffs[i] < 0)
                        pStr += (" - " + (-coeffs[i]) + "x^" + pwr);
                    else
                        pStr += (" + " + coeffs[i] + "x^" + pwr);
                }
                pwr--;
            }
            if (coeffs[i] != 0)
            {
                if (coeffs[i] == 1)
                    pStr += " + x";
                else if (coeffs[i] == -1)
                    pStr += " - x";
                else if (coeffs[i] < 0)
                    pStr += (" - " + (-coeffs[i]) + "x");
                else
                    pStr += (" + " + coeffs[i] + "x");
            }
            i++;
            if (coeffs[i] != 0)
            {
                if (coeffs[i] > 0)
                    pStr += " + " + coeffs[i];
                else
                    pStr += " - " + (-coeffs[i]);
            }
        }
        return pStr;
    }

    /**
     * Evaluates the polynomial represented by the array at the
     * specified value.
     * @param coeffs - an array of coefficients in order of descending powers
     * representing a univariate polynomial..
     * @param k - numeric value at which the polynomial is to be evaluated.
     * @throws IllegalArgumentException when the degree of the polynomial is
     * is greater than 0 and coefficient of the highest order term, the first
     * coefficient, is 0.
     * @return the value of the polynomial when evaluated at k
     */
    public static double eval(double[] coeffs, double k)
    {
        if (coeffs.length > 1 && coeffs[0] == 0)
            throw new IllegalArgumentException("eval(): Invalid Polynomial");
        double sum = 0;
        for (int i = 0; i < coeffs.length; i++)
            sum = (sum*k + coeffs[i]);
        return sum;
    }
    /**
     * Gives the degree of this polynomial
     * @param coeffs - the coefficient array of a polynomial in order
     * of descending powers.
     * @throws IllegalArgumentException when the coeffs.length > 1 and
     * coeffs[0] is 0.
     * @return the degree of the polynomial, coeffs.length - 1
     */
    public static int degree(double[] coeffs)
    {
        if (coeffs.length > 1 && coeffs[0] == 0)
            throw new IllegalArgumentException("degree():Invalid Polynomial");
        return coeffs.length-1;
    }
    /**
     *adds the given polynomials
     *@param poly1 the first polynomial to be added
     * @param poly2 the second polynomial to be added
     * @return the new array representing the sum of poly1 and poly2
     */
    public static double[] add(double poly1[], double poly2[])
    {
        double[] poly3;
        double[] polyNew;
        if(poly1.length>poly2.length)
        {poly3= new double[poly1.length];
            polyNew= new double[poly1.length];
            int i=0;
            int n=0;
            while(i<poly2.length)
            {
                polyNew[i+(poly1.length-poly2.length)]= poly2[i];
                i++;
            }
            while(n<poly1.length || n<poly2.length)
            {
                poly3[n]= (polyNew[n]+poly1[n]);
                n++;
            }
        }
        else
        {
            poly3= new double[poly2.length];
            polyNew = new double[poly2.length];
            int i=0;
            int n=0;
            while(i<poly1.length)
            {
                polyNew[i+(poly2.length-poly1.length)]= poly1[i];
                i++;
            }
            while(n<poly1.length || n<poly2.length)
            {
                poly3[n]= (polyNew[n]+poly2[n]);
                n++;
            }
        }
        return poly3;
    }
    /**insert comments
     *
     * @param poly1 first polynomial to multiply
     * @param poly2 second polynomial to multiply
     * @return returns product in array form
     */
    public static double[] mult(double poly1[], double poly2[])
    {
        double[] poly4;
        int i=0, deg1=poly1.length, deg2=poly2.length;
        poly4= new double[deg1+deg2-1];
        while(i<poly1.length)
        {
            int n=0;
            while(n<poly2.length)
            {
                poly4[n+i]+=poly1[i]*poly2[n];
                n++;
            }
            i++;
        }
        return poly4;}
    /**
     * This code subtracts two polynomials from each other
     * @param poly1 first polynomial to subtract
     * @param poly2 second polynomial to subtract
     * @return returns the new polynomial in array form
     */
    public static double[] sub(double poly1[], double poly2[])
    {
        double[] poly3;
        double[] polyNew;
        if(poly1.length>poly2.length)
        {poly3= new double[poly1.length];
            polyNew= new double[poly1.length];
            int i=0;
            int n=0;
            while(i<poly2.length)
            {
                polyNew[i+(poly1.length-poly2.length)]= poly2[i];
                i++;
            }
            while(n<poly1.length || n<poly2.length)
            {
                poly3[n]= (poly1[n]-polyNew[n]);
                n++;
            }
        }
        else
        {
            poly3= new double[poly2.length];
            polyNew = new double[poly2.length];
            int i=0;
            int n=0;
            while(i<poly1.length)
            {
                polyNew[i+(poly2.length-poly1.length)]= poly1[i];
                i++;
            }
            while(n<poly1.length || n<poly2.length)
            {
                poly3[n]= (polyNew[n]-poly2[n]);
                n++;
            }
        }
        return poly3; }

}

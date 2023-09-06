import polytester.Polynomials;

import java.util.Scanner;
/**
 * Implementation for basic methods related to univariate polynomials
 * @author Duncan, Jackson Aucoin
 * @version 1 code from lab 6; Move value-returning methods into
 * Polynomial and modify the main to correctly invoke those methods
 * @see Polynomials
 * <pre>
 * Date: 4/19/2023
 * Course: csc 1350 Section 1
 * Lab: 9
 * Instructor: Dr. Duncan
 * </pre>
 */
public class PolyTester {




    public static void main(String[] args)
    {
        Scanner cin = new Scanner(System.in);
        System.out.print("Enter the degree of the polynomial f(x) -> ");
        int deg = cin.nextInt();
        double[] f = new double[deg+1];
        System.out.print("Enter the coefficients of f(x) in order of descending powers -> ");
        for (int i = 0; i <= deg; i++)
            f[i] = cin.nextDouble();
        System.out.print("Enter the degree of the polynomial g(x) -> ");
        deg = cin.nextInt();
        double[] g = new double[deg+1];
        System.out.print("Enter the coefficients of g(x) in order of descending powers -> ");
        for (int i = 0; i <= deg; i++)
            g[i] = cin.nextDouble();
        System.out.print("Enter the degree of the polynomial h(x) -> ");
        deg = cin.nextInt();
        double[] h = new double[deg+1];
        System.out.print("Enter the coefficients of h(x) in order of descending powers -> ");
        for (int i = 0; i <= deg; i++)
            h[i] = cin.nextDouble();

        System.out.print("Enter the value k at which to evaluate the polynomials -> ");
        double k = cin.nextDouble();
        System.out.println();
        System.out.printf("f(x) = %s%n",Polynomials.toString(f));
        System.out.printf("g(x) = %s%n",Polynomials.toString(g));
        System.out.printf("h(x) = %s%n",Polynomials.toString(h));
        System.out.println("f("+k+") = "+Polynomials.eval(f,k));
        System.out.println("g("+k+") = "+Polynomials.eval(g,k));
        System.out.println("h("+k+") = "+Polynomials.eval(h,k));

        System.out.println();
        System.out.println("f(g("+k+")) = "+Polynomials.eval(f,Polynomials.eval(g,k)));
        System.out.println("g(f("+k+")) = " +Polynomials.eval(g,Polynomials.eval(f,k)));
        System.out.println("f(g(h("+k+"))) = "+Polynomials.eval(f,Polynomials.eval(g,Polynomials.eval(h,k))));
        System.out.println("h(g(f("+k+"))) = "+Polynomials.eval(h, Polynomials.eval(g,Polynomials.eval(f,k))));

        /* Write code to augment the main below */
        System.out.println();
        System.out.println("f(x) + g(x) = "+ Polynomials.toString(Polynomials.add(f,g)));
        System.out.println("g(x) + f(x) = "+ Polynomials.toString(Polynomials.add(g,f)));
        System.out.println("f(x)g(x) = "+ Polynomials.toString(Polynomials.mult(f,g)));
        System.out.println("g(x)h(x) = "+ Polynomials.toString(Polynomials.mult(g,h)));
        System.out.println("h(x)g(x) = "+ Polynomials.toString(Polynomials.mult(g,h)));

        System.out.println();
        System.out.println("f(x)(g(x) + h(x)) = "+ Polynomials.toString(Polynomials.mult(f, Polynomials.add(g,h))));
        System.out.println("f(x)g(x) + f(x)h(x) = " + Polynomials.toString(Polynomials.add(Polynomials.mult(f,g), Polynomials.mult(f,h))));

        System.out.println();
        System.out.println("p(x) = (f(x) + g(x))^2 = "+ Polynomials.toString(Polynomials.mult(Polynomials.add(f,g), Polynomials.add(f,g))));
        System.out.println("q(x) = f(x)^2 + g(x)^2 = "+ Polynomials.toString(Polynomials.add(Polynomials.mult(f,f),Polynomials.mult(g,g))));
        System.out.println("p("+k+") = "+ Polynomials.eval(Polynomials.mult(Polynomials.add(f,g),Polynomials.add(f,g)),k));
        System.out.println("q("+k+") = "+ Polynomials.eval(Polynomials.add(Polynomials.mult(f,f),Polynomials.mult(g,g)),k));

        System.out.println();
        System.out.println("f(x) - g(x) = "+ Polynomials.toString(Polynomials.sub(f, g)));
        System.out.println("r(x) = (g(x) + h(x))(g(x) - h(x)) = "+ Polynomials.toString((Polynomials.mult(Polynomials.add(g, h),Polynomials.sub(g, h)))));
        System.out.println("s(x) = g(x)^2 - h(x)^2 = "+ Polynomials.toString((Polynomials.mult(Polynomials.add(g, h),Polynomials.sub(g, h)))));
        System.out.println("r("+k+")="+ (Polynomials.eval((Polynomials.mult(Polynomials.add(g, h),Polynomials.sub(g, h))),k)));
        System.out.println("s("+k+")="+ (Polynomials.eval((Polynomials.mult(Polynomials.add(g, h),Polynomials.sub(g, h))),k)));




    }


}

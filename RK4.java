import java.util.Scanner;
public class RK4 
{	private double step, xinit, yinit, xfinal;
	public RK4(double step, double xinit, double yinit, double xfinal)
	{
		this.step = step;
		this.xinit = xinit;
		this.yinit = yinit;
		this.xfinal = xfinal;
	}
	public static double f(double x, double y)
	{
		//Here you can change your function that you want to approximate.
		//Make sure your dy/dx is completely isolated before inputting the function.
		return Math.sin(x*y);
	}
	
	public double approxDiffValue()
	{
		double xcur = xinit;
		double ycur = yinit;
		while(xcur < xfinal)
		{
			double k1, k2, k3, k4;
			
			k1 = f(xcur, ycur);
			k2 = f(xcur + 0.5*step, ycur+0.5*step*k1);
			k3 = f(xcur + 0.5*step, ycur+0.5*step*k2);
			k4 = f(xcur + step, ycur + step*k3);
			ycur += (step/6.0)*(k1+2.0*k2+2.0*k3+k4);
			xcur += step;
			
		}
		return ycur;
	}
	
	public static void main(String [] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("This is an Runge-Kutta 4th order approximation for first-order ODE's.");
		System.out.println("Make sure in the source code you have put what your function should be.");
		System.out.println("Input your step size: ");
		double stepIn = input.nextDouble();
		System.out.println("Input your x-intial: ");
		double xiniti = input.nextDouble();
		System.out.println("Input your y-initial: ");
		double yiniti = input.nextDouble();
		System.out.println("Input your final x-value");
		double xfin = input.nextDouble();
		RK4 runApprox = new RK4(stepIn, xiniti, yiniti, xfin);
		
		System.out.println("Your approximation is : " + runApprox.approxDiffValue());
	}
}

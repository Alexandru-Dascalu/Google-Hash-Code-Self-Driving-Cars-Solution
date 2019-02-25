package rewritten;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Data
{
	public static ArrayList<Ride> RIDES= new ArrayList<>();
	public static ArrayList<Ride> TAKEN_RIDES=new ArrayList<>();
	public static ArrayList<Car> CAR= new ArrayList<>();
	private static int rows, columns, vehicles, rides, bonus, steps;
	
	public static int getRows()
	{
		return rows;
	}
	
	public static int getColumn()
	{
		return columns;
	}
	
	public static int getVehicles()
	{
		return vehicles;
	}
	
	public static int getRides()
	{
		return rides;
	}
	
	public static int getBonus()
	{
		return bonus;
	}
	
	public static int getSteps()
	{
		return steps;
	}
	
	public static void read(File in) throws IOException
	{
		Scanner fin= new Scanner(in);
		rows=fin.nextInt();
		columns=fin.nextInt();
		vehicles = fin.nextInt();
		rides =fin.nextInt();
		bonus = fin.nextInt();
		steps = fin.nextInt();
		
		for(int i=0; i<rides;i++)
		{
			fin.nextLine();
			int startX=fin.nextInt();
			int startY=fin.nextInt();
			int endX=fin.nextInt();
			int endY=fin.nextInt();
			int early=fin.nextInt();
			int finish=fin.nextInt();
			Point start=new Point(startX, startY);
			Point end=new Point(endX, endY);
			
			if(Ride.isValid(start, end, early, finish))
			{
				Ride newRide= new Ride(start, end, early, finish, i);
				RIDES.add(newRide);
			}
			
		}
		
		for(int i=0;i<vehicles;i++)
		{
			CAR.add(new Car());
		}
		
		fin.close();
	}
	
	public static void write (File fout) throws IOException
	{
		PrintWriter out=new PrintWriter (fout);
		
		for(Car c: Data.CAR)
		{
			out.println(c.toString());
		}
		
		out.close();
	}
}

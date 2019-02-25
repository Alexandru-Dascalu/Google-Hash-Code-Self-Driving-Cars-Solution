package rewritten;

import java.util.ArrayList;

public class Car
{
	private ArrayList<Ride> rides;
	
	public Car()
	{
		rides= new ArrayList<Ride>();
	}
	
	public void addRide(Ride someRide)
	{
		rides.add(someRide);
	}
	
	public Ride getLastRide()
	{
		if(rides.isEmpty())
		{
			return null;
		}
		else
		{
			return rides.get(rides.size()-1);
		}
	}
	
	public Point getLastPosition()
	{
		if(getLastRide()!=null)
		{
			return rides.get(rides.size()-1).getEnd();
		}
		else
		{
			return new Point(0, 0);
		}
	}
	
	public int getFinishTime()
	{
		if(getLastRide()!=null)
		{
			return getLastRide().getFinishTime();
		}
		else
		{
			return 0;
		}
	}
	
	public boolean canTakeRide(Ride someRide)
	{
		Ride lastRide= getLastRide();
		
		if(lastRide==null)
		{
			return true;
		}
		else
		{
			long totalTime=lastRide.getFinishTime()+ Ride.distance(lastRide.getEnd(), someRide.getStart())+
					someRide.getDistance();
			if(totalTime<= Data.getSteps())
			{
				if(totalTime<=someRide.getFinishTime())
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			return false;
		}
	}
	
	@Override
	public String toString()
	{
		String aCar;
		aCar=rides.size()+" ";
		
		for(Ride elem: rides)
		{
			aCar+=elem.getID()+" ";
		}
		
		aCar=aCar.substring(0,aCar.length());
		return aCar;
	}
	
}

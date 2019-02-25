package fixedOriginal38millPoints;
import java.util.ArrayList;

public class Car
{
	private ArrayList<Ride> rides;
	private long timeCarIsDone;
	
	public Car()
	{
		timeCarIsDone=0;
		rides= new ArrayList<Ride>();
	}
	
	public void addRide(Ride someRide)
	{
		timeCarIsDone=whenCanItStart(someRide)+someRide.getDistance();
		rides.add(someRide);
	}
	
	public long whenCanItStart(Ride someRide)
	{
		if(timeCarIsDone+Ride.distance(getLastPosition(), someRide.getStart())>someRide.getEarliestStart())
		{
			return timeCarIsDone+Ride.distance(getLastPosition(), someRide.getStart());
		}
		else
		{
			return someRide.getEarliestStart();
		}
	}
	
	public long getTimeIsDone()
	{
		return timeCarIsDone;
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
	
	public boolean canTakeRide(Ride someRide)
	{
		Ride lastRide= getLastRide();
		
		if(lastRide==null)
		{
			return true;
		}
		else
		{
			long totalTime=whenCanItStart(someRide)+someRide.getDistance();
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
	
	public long getNrRides()
	{
		return rides.size();
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

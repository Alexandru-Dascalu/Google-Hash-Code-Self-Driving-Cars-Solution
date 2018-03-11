public class Ride
{
	private final Point start;
	private final Point end;
	private final int earliestStart;
	private final int finishTime;
	private final int ID;
	
	public Ride(Point start, Point end, int earliestStart, int finishTime, int ID)
	{
		this.start=start;
		this.end=end;
		this.earliestStart=earliestStart;
		this.finishTime=finishTime;
		this.ID=ID;
	}
	
	public int getID()
	{
		return ID;
	}
	
	public Point getStart()
	{
		return start;
	}
	
	public Point getEnd()
	{
		return end;
	}
	
	public int getEarliestStart()
	{
		return earliestStart;
	}
	
	public int getFinishTime()
	{
		return finishTime;
	}
	
	public long getDistance()
	{
		return distance(start, end);
	}
	
	public static long distance(Point a, Point b)
	{
		long distance=Math.abs(a.getX()-b.getX())+Math.abs(b.getY()-a.getY());
		return distance;
	}
	
	public static boolean isValid(Point start, Point end, int earliestStart, int finishTime)
	{
		long distance= distance(start, end);
		
		if(distance<=(finishTime-earliestStart))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean canStartOnTime(Ride ride, Car car)
	{
		long carIsDone=car.getTimeIsDone();
		long timeToGetToStart=distance(car.getLastPosition(), ride.getStart());
		
		if(carIsDone+timeToGetToStart<= ride.getEarliestStart())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean canFinishEarly(Ride ride, Car car)
	{
		long timeItStarts=car.whenCanItStart(ride);
		long rideDuration= ride.getDistance();
		long predictedFinish=timeItStarts+rideDuration;
		
		if(predictedFinish<= ride.getFinishTime())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public long howEarlyCanFinish(Ride ride, Car car)
	{
		long timeItStarts=car.whenCanItStart(ride);
		long rideDuration= ride.getDistance();
		long predictedFinish= timeItStarts+ rideDuration;
		
		return ride.getFinishTime()-predictedFinish;
	}
	public static long score(Ride ride, Car car, int bonus)
	{
		long score=0;
		
		if(canFinishEarly(ride, car))
		{
			score+=ride.getDistance();
		}
		
		if(canStartOnTime(ride, car))
		{
			score+=bonus;
		}
		
		return score;
	}
}

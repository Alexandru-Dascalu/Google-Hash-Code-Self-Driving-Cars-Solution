package bestSolution48millionPoints;
import java.io.File;
import java.io.IOException;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		String[] files= {"a_example.in", "b_should_be_easy.in", "c_no_hurry.in", "d_metropolis.in",
			"e_high_bonus.in" };
		String[] outputFiles= {"a_example.out", "b_should_be_easy.out", "c_no_hurry.out", "d_metropolis.out",
				"e_high_bonus.out"};

		for(int i=0; i<files.length;i++)
		{
			System.out.println("Input Files" + File.separator + files[i]);
			Data.read(new File(files[i]));
			
			for(Car car: Data.CAR)
			{
				boolean canTakeMoreRides=true;
				
				while(canTakeMoreRides)
				{
					canTakeMoreRides=false;
					long soonestStart=Integer.MAX_VALUE;
					long soonestStartBonus=Integer.MAX_VALUE;
					Ride bestRideBonus=null;
					Ride bestRideNoBonus=null;
					
					for(Ride ride: Data.RIDES)
					{
						if(car.canTakeRide(ride))
						{
							canTakeMoreRides=true;
							if(Ride.canStartOnTime(ride, car))
							{
								if(car.whenCanItStart(ride)<=soonestStartBonus)
								{
									soonestStartBonus=car.whenCanItStart(ride);
									bestRideBonus=ride;
								}
							}
							else
							{
								if(car.whenCanItStart(ride)<=soonestStart)
								{
									soonestStart=car.whenCanItStart(ride);
									bestRideNoBonus=ride;
								}
							}
						}
					}
					
					if(bestRideBonus!=null && bestRideNoBonus!=null)
					{
						if(soonestStartBonus-Data.getBonus()<=soonestStart)
						{
							car.addRide(bestRideBonus);
							Data.RIDES.remove(bestRideBonus);
						}
						else
						{
							car.addRide(bestRideNoBonus);
							Data.RIDES.remove(bestRideNoBonus);
						}
					}
					else if(bestRideBonus!=null)
					{
						car.addRide(bestRideBonus);
						Data.RIDES.remove(bestRideBonus);
					}
					else if(bestRideNoBonus!=null)
					{
						car.addRide(bestRideNoBonus);
						Data.RIDES.remove(bestRideNoBonus);
					}
					else
					{
						System.out.println("No ride for this car");
					}
				}
			}
				Data.write(new File("out"+File.separator+ outputFiles[i]));
				System.out.println("Done");

				Data.CAR.clear();
				Data.RIDES.clear();
		}
	}
}

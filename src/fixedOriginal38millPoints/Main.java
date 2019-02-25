package fixedOriginal38millPoints;
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
			System.out.println(files[i]);
			Data.read(new File("Input Files" + File.separator + files[i]));
			int missedRides=0;
			for (Ride ride: Data.RIDES)
			{
				Car bestCar=null;
				long bestScore=Integer.MIN_VALUE;
				
				for(Car car: Data.CAR)
				{
					if(car.canTakeRide(ride)) 
					{
						long weightedScore=weightedScore(ride, car, Data.getBonus());
						
						if(weightedScore>bestScore)
						{
							bestScore=weightedScore;
							bestCar=car;
						}
					}
				}
				
				if(bestCar!=null)
				{
					bestCar.addRide(ride);	
				}
				else
				{
					//System.out.println("No car for this ride");
					missedRides++;
				}
			}
			
			
				Data.write(new File("out"+File.separator+ outputFiles[i]));
				System.out.println("Missed Rides: "+missedRides);
				System.out.println("Done.");

				Data.CAR.clear();
				Data.RIDES.clear();
		}
	}


	public static long weightedScore(Ride ride, Car car, int bonus)
	{
		long score=Ride.score(ride, car, bonus);
		
		long stepsLateOrEarly;
		
		if(car.whenCanItStart(ride)==ride.getEarliestStart())
		{
				stepsLateOrEarly=ride.getEarliestStart()-(car.getTimeIsDone()+
						Ride.distance(car.getLastPosition(), ride.getStart()));
		}
		else
		{
			stepsLateOrEarly=car.whenCanItStart(ride)-ride.getEarliestStart();
		}
		
		long weightedScore=score-stepsLateOrEarly;
		
		return weightedScore;
	}

}

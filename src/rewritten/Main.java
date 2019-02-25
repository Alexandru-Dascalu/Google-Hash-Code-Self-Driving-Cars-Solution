package rewritten;

import java.io.File;
import java.io.IOException;
import java.util.Collections;


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
			
			Collections.sort(Data.RIDES);
			
			boolean cont=true;
			while(cont)
			{
				cont=false;
	
				for(Ride someRide: Data.RIDES)
				{
					if(!Data.TAKEN_RIDES.contains(someRide))
					{
						Car bestCar=null;
						long maxScore=Integer.MIN_VALUE;
						for(Car someCar : Data.CAR)
						{
							if(someCar.canTakeRide(someRide))
							{
								long score=Ride.score(someRide, someCar, 
									Data.getBonus());
								
								if(score>maxScore)
								{
									maxScore=score;
									bestCar=someCar;
								}
							}
						}
						
						if(bestCar==null)
						{
							System.out.println("No car for ride"+someRide);
						}
						else
						{
							Data.TAKEN_RIDES.add(someRide);
							bestCar.addRide(someRide);
							cont=true;
						}
					}
				}
			}
			
			Data.write(new File("out"+File.separator+outputFiles[i]));
			System.out.println("Done");

			Data.CAR.clear();
			Data.RIDES.clear();
		}		
	}
}


package original;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Data {

	public static final List<Ride> RIDES = new LinkedList<>();
	public static final List<Car> CAR = new LinkedList<>();
	public static int rows, columns, vehicles, rides, bonus, steps;

	public static void read(File f) throws IOException {
		Scanner s = new Scanner(f);
		rows = s.nextInt();
		columns = s.nextInt();
		vehicles = s.nextInt();
		rides = s.nextInt();
		bonus = s.nextInt();
		steps = s.nextInt();
		// Read Rides
		for (int i = 0; i < rides; i++) {
			s.nextLine();
			int sX = s.nextInt();
			int sY = s.nextInt();
			int eX = s.nextInt();
			int eY = s.nextInt();
			int early = s.nextInt();
			int finish = s.nextInt();
			Point st = new Point(sX, sY);
			Point en = new Point(eX, eY);
			if (Ride.isValid(st, en, early, finish)) {
				Ride r = new Ride(st, en, early, finish, i);
				RIDES.add(r);
			}
		}

		for (int i = 0; i < vehicles; i++) {
			CAR.add(new Car());
		}
		
	}

	public static void write(File to) throws IOException {
		PrintWriter out = new PrintWriter(to);
		for(Car c : Data.CAR){
			out.println(c.toString());
		}
		out.close();
	}

}

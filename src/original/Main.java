package original;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) throws IOException {
		String[] files = { "a_example.in", "b_should_be_easy.in", "c_no_hurry.in", "d_metropolis.in",
				"e_high_bonus.in" };
		for (String name : files) {
			// String name = files[2];
			System.out.println(name);
			Data.read(new File("Input Files" + File.separator + name));
			// Collections.sort(Data.RIDES, new Comparator<Ride>() {
			//
			// @Override
			// public int compare(Ride a, Ride b) {
			// int startAX = a.getStart().getX();
			// int startAY = a.getStart().getY();
			// double da = Math.sqrt(startAX * startAX + startAY * startAY);
			//
			// int startBX = b.getStart().getX();
			// int startBY = b.getStart().getY();
			// double db = Math.sqrt(startBX * startBX + startBY * startBY);
			// if (da > db)
			// return 1;
			// if (db > da)
			// return -1;
			// return 0;
			// }
			// });
			Collections.sort(Data.RIDES, new Comparator<Ride>() {

				@Override
				public int compare(Ride a, Ride b) {
					long da = a.getDistance();
					long db = b.getDistance();
					if (da > db)
						return -1;
					if (db > da)
						return 1;
					return 0;
				}
			});
			// Collections.sort(Data.RIDES, new Comparator<Ride>() {
			//
			// @Override
			// public int compare(Ride a, Ride b) {
			// int da = a.getEarliestStart();
			// int db = b.getEarliestStart();
			// if (da > db)
			// return 1;
			// if (db > da)
			// return -1;
			// return 0;
			// }
			// });

			// for (Car c : Data.CAR) {
			// Ride best = null;
			// long bestScore = 100000000000L;
			// int pRides = 0;
			// do {
			// pRides = 0;
			// for (Ride r : Data.RIDES) {
			// if (!c.canTakeRide(r))
			// continue;
			// long score = Ride.distance(c.getLastPoint(), r.getStart());
			// if (bestScore > score) {
			// bestScore = score;
			// best = r;
			// }
			// }
			// if (best == null) {
			//// System.err.println("no ride for " + c.hashCode());
			// continue;
			// }
			// pRides++;
			// Data.RIDES.remove(best);
			// c.addRide(best);
			// } while (pRides != 0);
			// }

			// int changes = 1;
			// while (changes != 0) {
			// changes = 0;
			// Iterator<Ride> i = Data.RIDES.iterator();
			// while (i.hasNext()) {
			// Ride r = i.next();
			// Car bestCar = null;
			// int maxScoreI = Integer.MIN_VALUE;
			// for (Car c : Data.CAR) {
			// if (!c.canTakeRide(r))
			// continue;
			// int score = Ride.score(r, c, Data.bonus);
			// if (score > maxScoreI) {
			// maxScoreI = score;
			// bestCar = c;
			// }
			// }
			// if (bestCar == null) {
			// System.err.println("No car for ride " + r);
			// } else {
			// changes++;
			// i.remove();
			// bestCar.addRide(r);
			// }
			// }
			// }

			HashSet<Ride> taken = new HashSet<>();

			int a = 0;
			do {
				a = 0;
				for (Ride r : Data.RIDES) {
					if (taken.contains(r))
						continue;
					Car bestCar = null;
					long maxScoreI = Integer.MIN_VALUE;
					for (Car c : Data.CAR) {
						if (!c.canTakeRide(r))
							continue;
						long score = Ride.score(r, c, Data.bonus);
						if (score > maxScoreI) {
							maxScoreI = score;
							bestCar = c;
						}
					}
					if (bestCar == null) {
						System.err.println("No car for ride " + r);
					} else {
						taken.add(r);
						a++;
						bestCar.addRide(r);
					}
				}
			} while (a != 0);

			Data.write(new File("out" + File.separator + name));
			System.out.println("Done");

			Data.CAR.clear();
			Data.RIDES.clear();

		}
	}

}

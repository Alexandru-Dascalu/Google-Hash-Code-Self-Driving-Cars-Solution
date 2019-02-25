package original;

import java.util.LinkedList;
import java.util.List;

public class Car {

	private static int idDistrib = 0;
	private List<Ride> rides = new LinkedList<>();
	private int carNumber;

	public Car() {
		carNumber = idDistrib++;
	}

	public void addRide(Ride r) {
		rides.add(r);
	}

	public int getFinishTime() {
		return getLast() == null ? 0 : getLast().getFinishTime();
	}

	public Point getLastPoint() {
		return getLast() == null ? new Point(0, 0) : getLast().getEnd();
	}

	private Ride getLast() {
		return !rides.isEmpty() ? rides.get(rides.size() - 1) : null;
	}

	public boolean canTakeRide(Ride r) {
		Ride last = getLast();
		if (last == null) {
			return true;
		}
		long totalTime = last.getFinishTime() + Ride.distance(last.getEnd(), r.getStart()) + r.getDistance();
		if (totalTime <= Data.steps) {
			if (totalTime <= r.getFinishTime()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(rides.size()).append(" ");
		for (Ride r : rides) {
			sb.append(r.getId() + " ");
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}
}

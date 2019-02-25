package original;

public class Ride {

	private Point start;
	private Point end;
	private int earliestStart;
	private int finishTime;
	private final int id;

	public Ride(Point start, Point end, int earliestStart, int finishTime, int id) {
		this.start = start;
		this.end = end;
		this.earliestStart = earliestStart;
		this.finishTime = finishTime;
		this.id = id;
	}

	public static long score(Ride ride, Car car, int bonus) {
		long score = 0;
		if (canFinishEarly(ride, car)) {
			score += ride.getDistance();
		}
		if (canStartOnTime(ride, car)) {
			score += bonus;
		}
		return score;
	}

	static boolean canStartOnTime(Ride ride, Car car) {
		long timeToGetThere = distance(car.getLastPoint(), ride.getStart());
		return timeToGetThere < ride.getEarliestStart();
	}

	static boolean canFinishEarly(Ride ride, Car car) {
		int rideDuration = ride.getFinishTime() - ride.getEarliestStart();
		long timeToGetThere = distance(car.getLastPoint(), ride.getStart());
		long predictedTime = timeToGetThere + rideDuration;

		return predictedTime < ride.getFinishTime();
	}

	long howEarlyCanFinish(Ride ride, Car car) {
		int rideDuration = ride.getFinishTime() - ride.getEarliestStart();
		long timeToGetThere = distance(car.getLastPoint(), ride.getStart());
		long predictedTime = timeToGetThere + rideDuration;

		return ride.getFinishTime() - predictedTime;
	}

	public int getId() {
		return id;
	}

	public Point getStart() {
		return start;
	}

	public void setStart(Point start) {
		this.start = start;
	}

	public Point getEnd() {
		return end;
	}

	public void setEnd(Point end) {
		this.end = end;
	}

	public int getEarliestStart() {
		return earliestStart;
	}

	public void setEarliestStart(int earliestStart) {
		this.earliestStart = earliestStart;
	}

	public int getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(int finishTime) {
		this.finishTime = finishTime;
	}

	public static long distance(Point a, Point b) {
		return (Math.abs(a.x - b.x) + Math.abs(b.y - a.y));
	}

	public static boolean isValid(Point start, Point end, int earliestStart, int finishTime) {
		long distance = distance(start, end);
		return distance <= (finishTime - earliestStart);
	}

	public long getDistance() {
		return distance(start, end);
	}

	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + earliestStart;
		result = prime * result + ((end == null) ? 0 : end.hashCode());
		result = prime * result + finishTime;
		result = prime * result + id;
		result = prime * result + ((start == null) ? 0 : start.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ride other = (Ride) obj;
		if (earliestStart != other.earliestStart)
			return false;
		if (end == null) {
			if (other.end != null)
				return false;
		} else if (!end.equals(other.end))
			return false;
		if (finishTime != other.finishTime)
			return false;
		if (id != other.id)
			return false;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
			return false;
		return true;
	}*/

}

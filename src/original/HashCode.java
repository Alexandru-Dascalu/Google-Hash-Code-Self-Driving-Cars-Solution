package original;

public class HashCode {

    /*int score(Ride ride, Car car, int bonus) {
        int score = 0;
        if (canFinishEarly(ride, car)) {
            score += getDistance(ride.getStartX(), ride.getStartY(), ride.getEndX(), ride.getEndY());
        }
        if (canStartOnTime(ride, car)) {
            score += bonus;
        }
        return score;
    }

    boolean canStartOnTime(Ride ride, Car car) {
        int timeToGetThere = getDistance(car.getCurrentPositionX(), car.getCurrentPositionY(), ride.getStartX(), ride.getStartY());
        return timeToGetThere < ride.getStartTime();
    }

    boolean canFinishEarly(Ride ride, Car car) {
        int rideDuration = ride.getFinishTime() - ride.getStartTime();
        int timeToGetThere = getDistance(car.getCurrentPositionX(), car.getCurrentPositionY(), ride.getStartX(), ride.getStartY());
        int predictedTime = timeToGetThere + rideDuration;

        return predictedTime < ride.getFinishTime();
    }

    int howEarlyCanFinish(Ride ride, Car car) {
        int rideDuration = ride.getFinishTime() - ride.getStartTime();
        int timeToGetThereX = abs(car.getCurrentPositionX() - ride.getStartX());
        int timeToGetThereY = abs(car.getCurrentPositionY() - ride.getStartY());
        int timeToGetThere = timeToGetThereX + timeToGetThereY;
        int predictedTime = timeToGetThere + rideDuration;

        return ride.getFinishTime() - predictedTime;
    }


    private int getDistance(int startX, int startY, int endX, int endY) {
        return abs(startX - endX) + abs(startY - endY);
    }

    private int abs(int a) {
        return Math.abs(a);
    }

}

class Ride {
    private final int startX;
    private final int startY;
    private final int endX;
    private final int endY;
    private final int startTime;
    private final int finishTime;

    public Ride(int startX, int startY, int endX, int endY, int startTime, int finishTime) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.startTime = startTime;
        this.finishTime = finishTime;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getEndX() {
        return endX;
    }

    public int getEndY() {
        return endY;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getFinishTime() {
        return finishTime;
    }
}

class Car {
    private int currentPositionX;
    private int currentPositionY;

    Car(int currentPositionX, int currentPositionY) {
        this.currentPositionX = currentPositionX;
        this.currentPositionY = currentPositionY;
    }

    public int getCurrentPositionX() {
        return currentPositionX;
    }

    public void setCurrentPositionX(int currentPositionX) {
        this.currentPositionX = currentPositionX;
    }

    public int getCurrentPositionY() {
        return currentPositionY;
    }

    public void setCurrentPositionY(int currentPositionY) {
        this.currentPositionY = currentPositionY;
    }

    @Override
    public String toString() {
        return "X: " + currentPositionX + " Y: " + currentPositionY;
    }*/
}

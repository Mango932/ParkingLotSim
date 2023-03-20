import java.util.LinkedList;

public class ParkingLot {

	int capacity;

	LinkedList<Spot> occupancy = new LinkedList<Spot>();


	public ParkingLot(int capacity)  {
        this.capacity = capacity;
		
	}

	public void park(Car c, int timestamp) {
		for (int i=0; i < capacity; i++) {
			if (occupancy.get(i) == null) {
				occupancy.add(new Spot(c,timestamp));
			}
		}
	}

	public Spot remove(int i) {

		if (occupancy.get(i) == null) {
			return null;
		}
		if (capacity-1 < i) {
			return null;
		}
		Spot removedSpot = occupancy.remove(i);
		occupancy.add(i,null);
		return removedSpot;

	}

	public Spot getSpotAt(int i) {
		return occupancy.get(i);
	}

	public boolean attemptParking(Car c, int timestamp) {
		if (occupancy.size() != capacity) {
			park(c,timestamp);
			return true;
		}
		return false;

	}

	public int getOccupancy() {
        int occupiedParkingSpots = 0;
		for (int i = 0; i < capacity; i++) {
			if(occupancy.get(i) != null) {
				occupiedParkingSpots++;
			}
		}
		return occupiedParkingSpots;
	}
}
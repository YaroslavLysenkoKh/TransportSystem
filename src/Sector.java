
public class Sector<E> {
	private E start;
	private E end;
	private double distance;
	private double time;

	public Sector(E start, E end, double distance, double time) throws SectorException {
		if (start.equals(end)) {

			throw new SectorException("It cannot be same stations");

		}
		this.start = start;
		this.end = end;
		this.distance = distance;
		this.time = time;

	}

	public static class SectorException extends Exception {

		public SectorException(String message) {
			super(message);
		}

	}

	public E getStart() {
		return start;
	}

	public E getEnd() {
		return end;
	}

	public double getDistance() {
		return distance;
	}

	public double getTime() {
		return time;
	}

	public double getSectorSpeed() {
		return distance / time;
	}

	@Override
	public String toString() {
		return "Sector [start=" + start + ", end=" + end + ", distance=" + distance + ", time=" + time + "]";
	}

}

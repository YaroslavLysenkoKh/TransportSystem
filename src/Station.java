
public class Station {
	private String name;
	private int numberOfNearestNodes;

	public Station(String name) {
		super();
		this.name = name;
	}

	public int getNumberOfNearestNodes() {
		return numberOfNearestNodes;
	}

	public void setNumberOfNearestNodes(int numberOfNearestNodes) {
		this.numberOfNearestNodes = numberOfNearestNodes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + numberOfNearestNodes;
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
		Station other = (Station) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (numberOfNearestNodes != other.numberOfNearestNodes)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Station: " + name + " | Number Of Nodes -> " + getNumberOfNearestNodes();
	}

}

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TransportSystem<E> {
	private List<Sector<E>> list;

	public TransportSystem() {
		super();
		this.list = new ArrayList<>();
	}

	public List<Sector<E>> getList() {
		return list;
	}

	public void setList(List<Sector<E>> list) {
		this.list = list;
	}

	private Set<E> getListOfStations() {
		Set<E> stations = new HashSet<E>();
		for (int i = 0; i < list.size(); i++) {
			stations.add(list.get(i).getStart());
			stations.add(list.get(i).getEnd());
		}
		return stations;
	}

	public Set<E> getListOfNeighbors(E station) {
		Set<E> stations = getListOfNeaerestStations(station);
		Set<E> result = new HashSet<E>();
		result.addAll(stations);
		for (E e : result) {
			result.addAll(getListOfNeaerestStations(e));
		}
		return result;
	}

	private Set<E> getListOfNeaerestStations(E station) {
		Set<E> stations = new HashSet<E>();
		for (Sector<E> e : list) {
			if (station.equals(e.getStart())) {
				stations.add(e.getEnd());
			} else if (station.equals(e.getEnd())) {
				stations.add(e.getStart());
			}
		}
		return stations;
	}

	public List<Station> getNumberOfNodesASC() {
		Set<Station> tmp = (Set<Station>) getListOfStations();
		for (Station e : tmp) {
			Set<E> tmp2 = getListOfNeaerestStations((E) e);
			e.setNumberOfNearestNodes(tmp2.size());
		}
		List<Station> list = new ArrayList<>(tmp);
		Collections.sort(list, Comparator.comparing(Station::getNumberOfNearestNodes));
		return list;
	}

	public Sector<E> getFastestSector() {
		Collections.sort(list, (o1, o2) -> Double.compare(o1.getSectorSpeed(), o2.getSectorSpeed()));
		return list.get(0);
	}

	@Override
	public String toString() {
		return list.toString();
	}
}

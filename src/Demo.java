import java.util.List;

public class Demo {

	public static void main(String[] args) {
		TransportSystem<Station> system = new TransportSystem<>();
		List<Sector<Station>> list = system.getList();
		Station kh = new Station("Харьков");
		Station ns = new Station("Новоселовка");
		try {
			list.add(new Sector<Station>(kh, ns, 2, 0.083));
			list.add(new Sector<Station>(new Station("Новоселовка"), new Station("Лиман"), 183, 3));
			list.add(new Sector<Station>(new Station("Новоселовка"), new Station("Мерефа"), 23, 0.5));
			list.add(new Sector<Station>(new Station("Новоселовка"), new Station("Люботин"), 22, 0.5));
			list.add(new Sector<Station>(new Station("Богодухов"), new Station("Люботин"), 53, 1));
			list.add(new Sector<Station>(new Station("Люботин"), new Station("Полтава"), 116, 2));
			list.add(new Sector<Station>(new Station("Люботин"), new Station("Мерефа"), 18, 0.5));
			list.add(new Sector<Station>(new Station("Полтава"), new Station("Красноград"), 81, 1.33));
			list.add(new Sector<Station>(new Station("Красноград"), new Station("Зачепиловка"), 28, 0.66));
			list.add(new Sector<Station>(new Station("Красноград"), new Station("Лозовая"), 95, 1.33));
			list.add(new Sector<Station>(new Station("Мерефа"), new Station("Лозовая"), 123, 2));
			list.add(new Sector<Station>(new Station("Мерефа"), new Station("Красноград"), 76, 2));
			list.add(new Sector<Station>(new Station("Лозовая"), new Station("Лиман"), 132, 2.5));
		} catch (Sector.SectorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		System.out.println(system.getListOfNeighbors(kh));
//		System.out.println(system.getFastestSector());
		System.out.println(system.getNumberOfNodesASC().toString());
	}

}

package endava.training.collections;
import java.util.*;

public class PenguinFun {

	/**
	 * Print a collection
	 * @param collection to be printed
     */
	private static void print(Collection<?> collection) {

		Iterator<?> it = collection.iterator();
		while (it.hasNext())
			System.out.println(it.next());
	}

	public static void main(String [] args){

		PenguinHatchery hatchery = new PenguinHatchery();

		/*  1.a  */
		System.out.println("\n------------- 1.A -------------");
		List<Penguin> p_list = new ArrayList<>();

		System.out.println("---------- Input");
		for (int i = 0; i < 20; i++) {
			Penguin p_temp = hatchery.hatchPenguin();
			System.out.println(p_temp);
			p_list.add(p_temp);
		}
		System.out.println("---------- Output");
		print(p_list);

		/*  1.b  */
		System.out.println("\n------------- 1.B -------------");
		Set<Penguin> p_set = new HashSet<>();

		System.out.println("---------- Same Input");
		p_set.addAll(p_list);

		System.out.println("---------- Output");
		print(p_set);

		System.out.println("---------- OBS: Nu sunt in ordinea inserata");

		/*  2.A  */
		System.out.println("\n------------- 2.A -------------");
		Collections.sort(p_list);
		print(p_list);
		System.out.println("---------- OBS: Collections.sort accepta doar List");

		/* 2.B  */
		System.out.println("\n------------- 2.B -------------");
		for (int i = 0; i < p_list.size(); i++) {
			List<Penguin> mates = new ArrayList<>();
			int count = (int)Math.floor(Math.random() * 3);
			while (count > 0) {
				int rand = (int)Math.floor(Math.random() * p_list.size());
				if (rand == i)
					continue;
				mates.add(p_list.get(rand));
				count -= 1;
			}
			p_list.get(i).setMatingPartners(mates);
		}
		Collections.sort(p_list, new CustomComparator());
		print(p_list);

		/*  3  */
		System.out.println("\n------------- 3 -------------");
		Map<PenguinRace, List<Penguin>> p_map = new HashMap<>();
		for (Penguin penguin : p_list) {
			if (p_map.get(penguin.getRace()) == null) {
				List<Penguin> aux_list = new ArrayList<>();
				aux_list.add(penguin);
				p_map.put(penguin.getRace(), aux_list);
			}
			else p_map.get(penguin.getRace()).add(penguin);
		}

		for (Map.Entry<PenguinRace, List<Penguin>> entry : p_map.entrySet()) {
			System.out.println("---------- " + entry.getKey());
			print(entry.getValue());
		}

		/*  1*  */
		System.out.println("\n------------- 1* -------------");
		Map<Penguin, String> p_hmap = new HashMap<>();
		Penguin p_temp = null;
		int big_number = 200000;
		int ind_rand = (int)(Math.floor(Math.random() * big_number));
		for (int i = 0; i < big_number; i++) {
			Penguin p = hatchery.hatchPenguin();
			if (i == ind_rand)
				p_temp = p;
			p_hmap.put(p, p.getName());
		}
		long time = System.currentTimeMillis();
		System.out.println("Got " + p_hmap.get(p_temp));
		time = System.currentTimeMillis() - time;
		System.out.println("---------- Time " + time + "ms");
		System.out.println("---------- OBS: Dureaza daca toti au acelasi hash");

		/*  2*  */
		System.out.println("\n------------- 2* -------------");
		MyHashTable my_table = new MyHashTable(300);
		for (int i = 0; i < big_number; i++) {
			Penguin p = hatchery.hatchPenguin();
			if (i == ind_rand)
				p_temp = p;
			my_table.put(p);
		}
		time = System.currentTimeMillis();
		System.out.println("Got " + my_table.get(p_temp));
		time = System.currentTimeMillis() - time;
		System.out.println("---------- Time " + time + "ms");
	}
}	

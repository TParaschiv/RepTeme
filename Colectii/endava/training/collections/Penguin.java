package endava.training.collections;
import java.util.List;

public class Penguin implements Comparable<Object>{
	
	private String name;
	private PenguinRace race;
	private double age;
	private List<Penguin> matingPartners;
	
	public Penguin(String name, PenguinRace race, double age) {
		this.name = name;
		this.race = race;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public PenguinRace getRace() {
		return race;
	}

	public double getAge() {
		return age;
	}

	public List<Penguin> getMatingPartners() {
		return matingPartners;
	}

	public void setMatingPartners(List<Penguin> matingPartners) {
		this.matingPartners = matingPartners;
	}

	@Override
	public String toString() {
		String s = new String("Penguin{" +
				"name='" + name + '\'' +
				", race=" + race +
				", age=" + age +
				", matingPartnersAge=");
		if (matingPartners == null)
			return s + "0" + '}';
		else {
			for (Penguin penguin : matingPartners)
				s += penguin.getAge() + " ";
			return s + '}';
		}
	}

	@Override
	public int compareTo(Object obj) {
		Penguin penguin = (Penguin) obj;
		int res = race.compareTo(penguin.getRace());
		if (res == 0)
			return Double.compare(age, penguin.getAge());
		return res;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Penguin penguin = (Penguin) o;

		if (Double.compare(penguin.age, age) != 0) return false;
		if (name != null ? !name.equals(penguin.name) : penguin.name != null) return false;
		if (race != penguin.race) return false;
		return matingPartners != null ? matingPartners.equals(penguin.matingPartners) : penguin.matingPartners == null;

	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		result = name != null ? name.hashCode() : 0;
		result = 31 * result + (race != null ? race.hashCode() : 0);
		temp = Double.doubleToLongBits(age);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		result = 31 * result + (matingPartners != null ? matingPartners.hashCode() : 0);
		return result;
		// Don't. Just don't
		// return 1;
	}
}

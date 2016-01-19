import info.gridworld.grid.Location;

public class Test {

	public static void main(String[] args) {
		Location loc1 = new Location(4, 3);
		int dir = loc1.getDirectionToward(new Location(6, 5));
		System.out.println(dir);
	}
}

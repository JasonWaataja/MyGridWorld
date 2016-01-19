

public class ChameleonKid extends ChameleonCritter {


	public void processActors(ArrayList<Actor> actors)
	{
		int n = actors.size();
		if (n == 0)
		{
			this.setColor(this.getColor().darker());
			return;
		}
		int r = (int) (Math.random() * n);
		Actor other = actors.get(r);
		setColor(other.getColor());
	}
}

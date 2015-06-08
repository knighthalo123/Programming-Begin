
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Actor;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import java.awt.Color;

public class FoxRunner1
{
	public static void main(String[] args)
	{
		BoundedGrid<Actor> mygrid = new BoundedGrid<Actor>(9,9);
		ActorWorld world = new ActorWorld(mygrid);
		
		world.add(new Location(1, 1), new Fox());
		world.add(new Location(8, 0), new Chicken(4,3));
		world.add(new Location(8, 6), new Chicken(4,3));
		world.add(new Location(5, 8), new Chicken(4,3));
		world.add(new Location(0, 7), new Chicken(4,3));
		
		world.show();
	}
}
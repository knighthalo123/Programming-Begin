import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Location;





public class NewBug extends Bug{
	public void act(){	
		Location loc1 = new Location(1,3);
		Location loc2 = new Location(2,1);
		Location loc3 = new Location(3,2);
		Location loc4 = loc1.getAdjacentLocation(40);
		Location loc5 = loc2.getAdjacentLocation(200);
		System.out.println(loc2.getDirectionToward(loc3));
		System.out.println(loc1.compareTo(loc5) == 0);
		System.out.println(loc4.getAdjacentLocation(230).equals(loc1));
	}
}

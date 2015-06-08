/*
 *      Chicken.java
 *      
 *      Copyright 2014  <>
 *      
 *      This program is free software; you can redistribute it and/or modify
 *      it under the terms of the GNU General Public License as published by
 *      the Free Software Foundation; either version 2 of the License, or
 *      (at your option) any later version.
 *      
 *      This program is distributed in the hope that it will be useful,
 *      but WITHOUT ANY WARRANTY; without even the implied warranty of
 *      MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *      GNU General Public License for more details.
 *      
 *      You should have received a copy of the GNU General Public License
 *      along with this program; if not, write to the Free Software
 *      Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 *      MA 02110-1301, USA.
 */

import info.gridworld.actor.Critter;
import java.awt.Color;
import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;
import java.util.ArrayList;
import info.gridworld.actor.Actor;

public class Chicken extends Critter {
	int pass, birth;
	public Chicken(){
		setColor(null);
		setDirection((int)(Math.random()*360));
		pass = 5;
		birth = 6;
	}
	
	public Chicken(int a, int b){
		setColor(null);
		setDirection((int)(Math.random()*360));
		pass = a;
		birth = b;
	}
	
	public void processActors(ArrayList<Actor> actors){}
	
	public void makeMove(Location loc)
    {
    	setColor(null);
    	Grid<Actor> gr = getGrid();
        if (loc == null)
            removeSelfFromGrid();
        else{
        	if(loc == getLocation()){
							
			}else{
				int direction = getLocation().getDirectionToward(loc);
				setDirection(direction);
				Location now = getLocation();
				moveTo(loc);
				
				int random = (int)(Math.random() * birth);	
				if(random == 1){
					if(gr.get(now) == null){
						setColor(new Color(0,0,255));
						Egg egg = new Egg(pass,birth);
						egg.putSelfInGrid(gr,now);
					}
				}
			}
    	}
    }
	
	
	
}
/*
 *      Fox.java
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

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;

import java.util.ArrayList;
import java.awt.Color;

public class Fox extends Actor{
	
	public Fox(){
		setColor(null);
	}
	
	public void act(){
		
		if(!eatActors(getOne(), getTwo())){
			makeMove();
		}
		
	}
	
	public boolean eatActors(ArrayList<Location> one, ArrayList<Location> two){
		
		if(containsEgg(one)){  // egg in adjacent spaces
			randomEgg(one);
		}else if(containsEgg(two)){ // egg in two spaces away
			randomEgg(two);
		}else if(containsChicken(one)){ // chicken in adjacent spaces
			randomChicken(one);
		}else if(containsChicken(two)){ // chicken in two spaces away
			randomChicken(two);
		}else{
			return false;
		}

		return true;
	}
	
	public void randomEgg(ArrayList<Location> egg){
		ArrayList<Actor> temp = new ArrayList<Actor>();
		Grid<Actor> gr = getGrid();
		for(Location b : egg){
			Actor c = gr.get(b);
			if(c instanceof Egg){
				temp.add(c);
			}
		}
		
		moveTo(temp.get((int)(Math.random()*temp.size())).getLocation());
		
	}
	
	public void randomChicken(ArrayList<Location> chicken){
		ArrayList<Actor> temp = new ArrayList<Actor>();
		Grid<Actor> gr = getGrid();
		for(Location b : chicken){
			Actor c = gr.get(b);
			if(c instanceof Chicken){
				temp.add(c);
			}
		}
		
		moveTo(temp.get((int)(Math.random()*temp.size())).getLocation());
		
	}
	
	public boolean containsEgg(ArrayList<Location> one){
		Grid<Actor> gr = getGrid();
		for(Location a : one){
			Actor b = gr.get(a);
			if(b instanceof Egg){
				return true;
			}		
		}
		return false;
	}
	
	public boolean containsChicken(ArrayList<Location> two){
		Grid<Actor> gr = getGrid();
		for(Location a : two){
			Actor b = gr.get(a);
			if(b instanceof Chicken){
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<Location> getOne(){
		Grid<Actor> gr = getGrid();
		ArrayList<Location> temp = gr.getOccupiedAdjacentLocations(getLocation());
		return temp;
		
	}
	
	public ArrayList<Location> getTwo(){
		ArrayList<Actor> actors = getTwoActors();
		ArrayList<Location> temp = new ArrayList<Location>();
		// get all in grid of 2
		
		for(Actor b : actors){
			temp.add(b.getLocation());
		}
		
		return temp;
	}
	
	public ArrayList<Actor> getTwoActors(){
		Location loc = getLocation();
		ArrayList<Actor> actors = new ArrayList<Actor>();
		for(int row = loc.getRow() - 2; row <= loc.getRow() + 2; row++){
			for(int col = loc.getCol() - 2; col <= loc.getCol() + 2; col++){
				Location currentloc = new Location(row,col);
				if(getGrid().isValid(currentloc)){
					Actor a = getGrid().get(currentloc);
					if(a != null && a != this){
						actors.add(a);
					}
				}	
			}
		}
		return actors;
	}
	
	public ArrayList<Actor> getAll(){
		Grid<Actor> gr = getGrid();
		ArrayList<Location> tempA = gr.getOccupiedLocations();
		ArrayList<Actor> act = new ArrayList<Actor>();
		for(Location a : tempA){
			Actor temp = (Actor)gr.get(a);
			if(temp.getLocation() != getLocation()){
				act.add(temp);
			}	
		}
		return act;
	}
		
	public Location getClosest(){
		ArrayList<Actor> all = getAll();
		int max = 1000;
		Location temp = new Location(0,0);
		for(Actor a : all){
			if(a instanceof Chicken || a instanceof Egg){
				if(distanceTo(a.getLocation()) < max){
					max = distanceTo(a.getLocation());
					temp = a.getLocation();
				}
			}
		}
		
		if(temp.compareTo(new Location(0,0)) == 0){ // after everything dies
			return null;
		}
		
		
		return temp;
	}
		
	public void makeMove(){
		Location loc = getClosest();
		if(loc != null){
			int direction = getLocation().getDirectionToward(loc);
			Location temp = getLocation().getAdjacentLocation(direction);
			move(temp);
			move(temp.getAdjacentLocation(direction));	
		}
	}
	
	public void move(Location loc){
		Grid<Actor> gr = getGrid();
		if(gr.isValid(loc) && gr.get(loc) == null){
			moveTo(loc);
		}
	}
	
	public int distanceTo(Location loc2) 
	{
		Location loc1 = getLocation();
		int distX = Math.abs(loc1.getRow() - loc2.getRow());
		int distY = Math.abs(loc1.getCol() - loc2.getCol());
		if (distX <= 1 && distY <= 1)
			return 1;
		else if (distX <= 2 && distY <= 2)
			return 2;
		return (int)Math.sqrt((double)(distX * distX + distY * distY) + 0.5);
	}
	
}
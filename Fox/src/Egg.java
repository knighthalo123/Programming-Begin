/*
 *      Egg.java
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
import java.awt.Color;
import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;

public class Egg extends Actor {
	private double dark = .5;
	private int pass, incubator;
	private int counter;	
	public Egg(){	
		setColor(new Color(210,210,210));
		pass = 5;
		incubator = 6;
		counter = 0;
	}
	
	public Egg(int a, int b){
		setColor(new Color(210,210,210));
		pass = a;
		incubator = b;
		counter = 0;
	}
	
	public void act(){
		Grid<Actor> gr = getGrid();
		Color c = getColor();
        int green = (int) (c.getGreen() * (1 + dark));
        int red = (int) (c.getRed() * (1 - dark));
		
		
		if(green > 250){
			green = 250;
		}
		if(red < 0){
			red = 0;
		}
		counter++;
		if(counter == incubator){
			Location loc = getLocation();
			this.removeSelfFromGrid();
			Chicken chic = new Chicken(pass,incubator);
			chic.putSelfInGrid(gr,loc);
		}
		setColor(new Color(red,green,red));
	}
	
	
}
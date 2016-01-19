/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Cay Horstmann
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 */

import info.gridworld.actor.Bug;

/**
 * A <code>ZBug</code> traces out a square "z" of a given size. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class ZBug extends Bug
{
	private int steps;
	private int sideLength;
	//0 to 2 depending on how far it is in z
	private int zStage;

	/**
	 * Constructs a z bug that traces a square of a given side length
	 * @param length the side length
	 */
	public ZBug(int length)
	{
		steps = 0;
		sideLength = length;
		setDirection(90);
		zStage = 0;
	}

	/**
	 * Moves to the next location of the square.
	 */
	public void act()
	{
		if (zStage != 3) {
			if (canMove()) {
				if (steps < sideLength) {
					move();
					steps++;
				} else {
					switch (zStage) {
						case 0 : setDirection(225); zStage++; steps = 0; break;
						case 1 : setDirection(90); zStage++; steps = 0; break;
						case 2 : zStage++; break;
					}
				}
			}
		}
	}
}

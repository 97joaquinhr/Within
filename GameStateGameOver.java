/*
 * GameStateGameOver.java
 * 
 * Copyright 2017 Edgar Daniel Fernández Rodríguez <edgar.fernandez@me.com>
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 * 
 * 
 */
import java.awt.*;

public class GameStateGameOver implements GameState {
	GameStateContext gc;
	
	
	public GameStateContext getGc() {
		return gc;
	}
	public void setGc(GameStateContext gc) {
		this.gc = gc;
	}
	public GameStateGameOver(GameStateContext gc){
		this.gc = gc;
	}
	public GameStateGameOver() {
		// TODO Auto-generated constructor stub

	}
	public void end(){
		//nada
	}
	
	public void pause(){
		//nada
	}
	
	public void resume(){
		//nada
	}
	
	public void paint(Graphics g){
		//pintar pantalla gameover
	}
	
	public void update(){
	
	}
	@Override
	public void keyboard(int k) {
		switch(k){
		case 1://arriba
			break;
		case 2://down
			break;
		case 3://left
			break;
		case 4://right
			break;
		case 5://c
			break;
		case 6://x
			break;
		case 7://pausa
			break;
		default:
			break;
		}	
	}
	public void keyboardReleased(int k) {	
	}
}


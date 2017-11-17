/*
 * GameStateContext.java
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
 * Actualizado el 12/octubre/2017 20:00 hrs
 * 
 */

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
public class GameStateContext implements KeyListener {
	
	private ArrayList <GameState> estados = new ArrayList <GameState>();
	private GameState current;
	
	public GameStateContext(){
		estados.add(StateFactory.getInstance().getState(1));
		estados.add(StateFactory.getInstance().getState(2));
		estados.add(StateFactory.getInstance().getState(3));
		for(int i = 0;i<3;i++){
			estados.get(i).setGc(this);
		}
		current = estados.get(0);
		
	}
	
	public GameState getRun(){
		return estados.get(0);
	}
	
	public GameState getPause(){
		return estados.get(1);
	}
	
	public GameState getGameOver(){
		return estados.get(2);
	}
	
	public void setCurrent(GameState gs){
		current = gs;
	}
	
	public void end(){
		current.end();
	}
	
	public void resume(){
		current.resume();
	}
	
	public void pause(){
		current.pause();
	}
	
	public void update(){
		current.update();
	}
	
	public void paint(Graphics g){
		current.paint(g);
	}

	@Override
	public synchronized void keyPressed(KeyEvent k) {
		int keyCode = k.getKeyCode();
		if(keyCode == KeyEvent.VK_RIGHT){current.keyboard(1);}
		if(keyCode == KeyEvent.VK_LEFT){current.keyboard(2);}
		if(keyCode == KeyEvent.VK_UP){current.keyboard(3);}
		
	}

	@Override
	public synchronized void keyReleased(KeyEvent k) {
		int keyCode = k.getKeyCode();
		if(keyCode == KeyEvent.VK_RIGHT){current.keyboardReleased(-1);}
		if(keyCode == KeyEvent.VK_LEFT){current.keyboardReleased(-2);}
		if(keyCode == KeyEvent.VK_UP){current.keyboardReleased(-3);}
	//	current.keyboardReleased(r);
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}
}


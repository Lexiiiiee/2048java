package com.kpnzstudios.UTILS;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Classe criada como uma fila para o teclado, de forma a organizar melhor os comandos do usuário.
 * @author Lucasgsa
 *
 */
public class KeyBoardQueue {
	
	/**
	 * Armazena os códigos de teclas na fila.
	 */
	private ArrayList<String> queue;

	/**
	 * Construtor da classe
	 */
	public KeyBoardQueue() {
		queue = new ArrayList<String>();
	}
	
	/**
	 * Retorna se há algum direcional para direita na fila.
	 * @return boolean
	 */
	public boolean hasRight() {
		if (queue.contains("RIGHT")) {
			queue.remove("RIGHT");
			return true;
		}
		return false;
	}
	
	/**
	 * Retorna se há algum direcional para esquerda na fila.
	 * @return boolean
	 */
	public boolean hasLeft() {
		if (queue.contains("LEFT")) {
			queue.remove("LEFT");
			return true;
		}
		return false;
	}
	
	/**
	 * Retorna se há algum direcional para cima na fila.
	 * @return boolean
	 */
	public boolean hasUp() {
		if (queue.contains("UP")) {
			queue.remove("UP");
			return true;
		}
		return false;
	}
	
	/**
	 * Retorna se há algum direcional para baixo na fila.
	 * @return boolean
	 */
	public boolean hasDown() {
		if (queue.contains("DOWN")) {
			queue.remove("DOWN");
			return true;
		}
		return false;
	}
	
	/**
	 * Retorna se a tecla Z está na fila para ser executada.
	 * @return boolean
	 */
	public boolean hasZ() {
		if (queue.contains("Z")) {
			queue.remove("Z");
			return true;
		}
		return false;
	}
	
	/**
	 * Retorna se a tecla R está na fila para ser executada.
	 * @return boolean
	 */
	public boolean hasR() {
		if (queue.contains("R")) {
			queue.remove("R");
			return true;
		}
		return false;
	}
	
	/**
	 * Recebe uma tecla pressionada do keyListener.
	 * @param KeyEvent - usando keyListener e passando o evento de keyPressed para dentro dessa função.
	 */
	public void pressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (keyCode == KeyEvent.VK_RIGHT && !queue.contains("RIGHT")) {
			queue.add("RIGHT");
		}
		if (keyCode == KeyEvent.VK_LEFT && !queue.contains("LEFT")) {
			queue.add("LEFT");
		}
		if (keyCode == KeyEvent.VK_UP && !queue.contains("UP")) {
			queue.add("UP");
		}
		if (keyCode == KeyEvent.VK_DOWN && !queue.contains("DOWN")) {
			queue.add("DOWN");
		}
		if (keyCode == KeyEvent.VK_Z && !queue.contains("Z")) {
			queue.add("Z");
		}
		if (keyCode == KeyEvent.VK_R && !queue.contains("R")) {
			queue.add("R");
		}
		System.out.println(queue.toString());
	}
}

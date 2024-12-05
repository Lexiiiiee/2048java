package com.kpnzstudios.Graphics;

import javax.swing.JFrame;

public class GameInit {
	public static void main(String[] args) {
		Game2048Interface game = new Game2048Interface();
		JFrame frame = new JFrame("2048");
		frame.add(game);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		new Thread(game).start();
	}
}

package com.kpnzstudios.Graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

import com.kpnzstudios.KPNz2048.Main2048;
import com.kpnzstudios.UTILS.ColorConstants;
import com.kpnzstudios.UTILS.KeyBoardQueue;

public class Game2048Interface extends Canvas implements Runnable, KeyListener {

	private static final long serialVersionUID = 1;

	/**
	 * Define tamanho da tela.
	 */
	final int[] windowsSize = {800,1000};
	
	Main2048 game = new Main2048();
	
	KeyBoardQueue keyState = new KeyBoardQueue();
	
	ColorConstants cores = new ColorConstants();
	
	int tamanhoFontNumeros = 60;
	
	public Game2048Interface() {
		this.setPreferredSize(new Dimension(windowsSize[0], windowsSize[1]));
		this.addKeyListener(this);
	}
	
	@Override
	public void run() {
		while (true) {
			tick();
			render();
			try {
				Thread.sleep(16);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Verifica a queue de teclas e define alguma função para cada.
	 */
	public void checarMovimento() {
		if (keyState.hasUp()) {
			game.paraCima();
		}
		if (keyState.hasDown()) {
			game.paraBaixo();
		}
		if (keyState.hasLeft()) {
			game.paraEsquerda();
		}
		if (keyState.hasRight()) {
			game.paraDireita();
		}
		if (keyState.hasR()) {
			game.resetar();
		}
		if (keyState.hasZ()) {
			game.voltar();
		}
	}
	
	/**
	 * Ação a ser feita a cada tick do jogo.
	 */
	public void tick() {
		checarMovimento();
	}
	
	/**
	 * Limpa a tela com uma cor sólida.
	 * Recebe como parâmetro o graphics da tela.
	 * @param Graphics
	 */
	public void limparTela(Graphics g) {
		g.setColor(new Color(198, 190, 173));
		g.fillRect(0, 0, windowsSize[0], windowsSize[1]);
	}
	
	/**
	 * Desenha as linhas entre os quadrados.
	 * Recebe como parâmetro o graphics da tela.
	 * @param Graphics
	 */
	public void desenharEsqueleto(Graphics g) {
		
		g.setColor(Color.BLACK);
		g.drawLine(200, 0, 200, 800);
		
		g.drawLine(400, 0, 400, 800);
		
		g.drawLine(600, 0, 600, 800);
		
		g.drawLine(0, 200, 800, 200);
		
		g.drawLine(0, 400, 800, 400);
		
		g.drawLine(0, 600, 800, 600);
		
	}
	
	/**
	 * Desenha os números e seus respectivos quadrados.
	 * Recebe como parâmetro o graphics da tela.
	 * @param Graphics
	 */
	public void desenharNumeros(Graphics g) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (game.matriz[j][i] != 0 ) {
					g.setColor(cores.getColor(game.matriz[j][i]));
					g.fillRect(200*i, 200*j, 200, 200);
					
					g.setColor(Color.BLACK);
					int qtdNumero = (game.matriz[j][i]+"").length();
					g.setFont(new Font("Times New Roman", 0, tamanhoFontNumeros));
					int tamanhoFont = (int) ((tamanhoFontNumeros)*3/4); // Conversão de pt para px.
					g.drawString(game.matriz[j][i]+"", (200*i)+100-(tamanhoFont*qtdNumero)/3, (200*j)+100+tamanhoFont/2);
				}
			}
		}
	}
	
	/**
	 * Desenha o painel inferior, o placar, e os textos auxiliares.
	 * Recebe como parâmetro o graphics da tela.
	 * @param Graphics
	 */
	public void desenharPlacarEMenu(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 800, 800, 200);
		
		g.setFont(new Font("Times New Roman", 1, 40));
		g.setColor(Color.BLACK);
		if (game.ganhou()) g.setColor(Color.GREEN);
		g.drawString("PONTUAÇÃO: "+game.placar(), 230, 850);
		
		g.setFont(new Font("Times New Roman", 1, 20));
		g.setColor(Color.BLACK);
		g.drawString("Pressiona Z - para voltar a jogada. ", 200, 900);	
		g.drawString("Pressione R - para resetar a partida. (Cuidado)", 200, 950);	
		
		g.drawLine(0, 800, 1000, 800);
	}
	
	/**
	 * Função que controla todo o render do jogo.
	 * Recebe como parâmetro o graphics da tela.
	 * @param Graphics
	 */
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		
		limparTela(g);
		
		desenharNumeros(g);
		
		desenharEsqueleto(g);
		
		desenharPlacarEMenu(g);
		
	    g.dispose();
		
		bs.show();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		keyState.pressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}

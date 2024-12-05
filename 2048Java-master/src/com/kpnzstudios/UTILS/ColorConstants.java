package com.kpnzstudios.UTILS;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe que armazena as constantes de cores para os quadrados de cada valor no jogo.
 * @author Lucasgsa
 *
 */
public class ColorConstants {
	
	/**
	 * Mapa que armazena as cores, sendo a chave o número em questão que quero saber a cor e como
	 * valor a cor.
	 */
	private Map<Integer, Color> cores;
	
	/**
	 * Construtor da classe
	 */
	public ColorConstants() {
		cores = new HashMap<Integer, Color>();
		cores.put(2, new Color(239, 227, 217));
		
		cores.put(4, new Color(236, 224, 200));
		
		cores.put(8, new Color(241, 175, 118));
		
		cores.put(16, new Color(245, 148, 98));
		
		cores.put(32, new Color(245, 123, 95));

		cores.put(64, new Color(247, 93, 60));
		
		cores.put(128, new Color(235, 207, 112));
		
		cores.put(256, new Color(235, 203, 95));
		
		cores.put(512, new Color(238, 198, 80));
		
		cores.put(1024, new Color(238, 196, 64));
		
		cores.put(2048, new Color(251, 197, 45));
		
		cores.put(4096, new Color(244, 102, 116));
		
		cores.put(8192, new Color(243, 75, 92));
		
		cores.put(16384, new Color(235, 66, 59));
		
		cores.put(32768, new Color(114, 181, 221));
		
		cores.put(65536, new Color(94, 161, 231));
		
		cores.put(131072, new Color(0, 127, 194));
	}
	
	/**
	 * Retorna a cor do número.
	 * Caso não tenha sido colocada ainda, retorna a cor preta.
	 * @param id - pontuação da peça
	 * @return Color, retorna a cor.
	 */
	public Color getColor(int id) {
		if (cores.containsKey(id)) {
			return cores.get(id);
		}
		return new Color(0,0,255);
	}
}

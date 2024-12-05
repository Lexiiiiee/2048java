package com.kpnzstudios.KPNz2048;

import java.util.Random;

import com.kpnzstudios.UTILS.UtilFunctions;

public class Main2048 {
	
	/**
	 * Define o tamanho da matriz do jogo.
	 */
	private int tamanhoJogo = 4;
	
	/**
	 * Armazena uma matriz de arrays.
	 */
	public int[][] matriz;
	
	/**
	 * Matriz backup, serve para quando você deseja voltar uma jogada, ela sempre salva a jogada anterior.
	 */
	private int[][] matrizBackup;
	
	/**
	 * Valores possíveis de aparecer de forma inicial ou quando há um movimento.
	 * Todos os valores têm a mesma chance, portanto caso queira que um apareça mais que outro,
	 * escreva-o mais de uma vez.
	 * Ex: {2,2,2,4}
	 * 	2: 75%
	 * 	3: 25%
	 */
	int[] initRandom = {2, 2, 2, 4};
	
	/**
	 * Armazena se o jogador já chegou a 2048 em alguma peça e portanto ganhou o jogo.
	 */
	boolean ganhou = false;
	
	/**
	 * Construtor da classe.
	 */
	public Main2048() {
		matriz = new int[tamanhoJogo][tamanhoJogo];
		adicionarAleatorio();
		matrizBackup = matriz;
	}
	
	/**
	 * Define novos valores possíveis de aparecer de forma inicial ou quando há um movimento.
	 * @param array - array de inteiros.
	 */
	public void setInitRandom(int[] array) {
		initRandom = array;
	}
	
	/**
	 * Adiciona um valor aletório em alguma posição que não contenha nada(valor 0).
	 * O valor adicionado é escolhido randomicamente da array initRandom que pode ser modificado.
	 */
	public void adicionarAleatorio() {
		Random gerador = new Random();
		while (true){
			int x = gerador.nextInt(tamanhoJogo);
			int y = gerador.nextInt(tamanhoJogo);	
			if (matriz[x][y] == 0) {
				matriz[x][y] = initRandom[gerador.nextInt(initRandom.length)];
				break;
			}
		}
	}
	
	/**
	 * Retorna o placar do jogador até o momento.
	 * @return
	 */
	public int placar() {
		int soma = 0;
		for (int i = 0; i < tamanhoJogo; i++) {
			for (int j = 0; j < tamanhoJogo; j++) {
				if (matriz[i][j] == 2048) ganhou = true;
				soma += matriz[i][j];
			}
		}
		return soma;
	}
	
	/**
	 * Retorna se o jogador já chegou a 2048 em alguma peça durante a rodada.
	 * @return boolean
	 */
	public boolean ganhou() {
		return ganhou;
	}
	
	/**
	 * Reseta o jogo para o começo.
	 * É possível utilizar a função voltar, caso tenha feito um reset por engano.
	 */
	public void resetar() {
		matrizBackup = matriz;
		matriz = new int[tamanhoJogo][tamanhoJogo];
		adicionarAleatorio();
	}
	
	/**
	 * Retorna as posições da ultima jogada.
	 */
	public void voltar() {
		matriz = matrizBackup;
	}
	
	/**
	 * Função de jogar a matriz para direita.
	 * Retorna um valor booleano se houver alguma mudança na matriz.
	 */
	private boolean jogarParaDireita() {
		LinhaHorizontal linha1 = new LinhaHorizontal(matriz[0][0], matriz[0][1], matriz[0][2], matriz[0][3]);
		boolean b1 = linha1.jogarDireita();
		matriz[0] = linha1.getValues();
		
		LinhaHorizontal linha2 = new LinhaHorizontal(matriz[1][0], matriz[1][1], matriz[1][2], matriz[1][3]);
		boolean b2 = linha2.jogarDireita();
		matriz[1] = linha2.getValues();
		
		LinhaHorizontal linha3 = new LinhaHorizontal(matriz[2][0], matriz[2][1], matriz[2][2], matriz[2][3]);
		boolean b3 = linha3.jogarDireita();
		matriz[2] = linha3.getValues();
		
		LinhaHorizontal linha4 = new LinhaHorizontal(matriz[3][0], matriz[3][1], matriz[3][2], matriz[3][3]);
		boolean b4 = linha4.jogarDireita();
		matriz[3] = linha4.getValues();
		
		return (b1 | b2 | b3 | b4);
	}
	
	/**
	 * Função para jogar a matriz para direita.
	 */
	public void paraDireita() {
		int[][] tempBackup = UtilFunctions.clone(matriz, tamanhoJogo);
		boolean b1 = jogarParaDireita();
		if (b1) {
			adicionarAleatorio();
			matrizBackup = tempBackup;
		}
	}
	
	/**
	 * Função para jogar a matriz para esquerda.
	 */
	public void paraEsquerda() {
		int[][] tempBackup = UtilFunctions.clone(matriz, tamanhoJogo);
		matriz = UtilFunctions.girar90(matriz, 2);
		boolean b1 = jogarParaDireita();
		matriz = UtilFunctions.girar90(matriz, 2);
		if (b1) {
			adicionarAleatorio();
			matrizBackup = tempBackup;
		}
	}
	
	/**
	 * Função para jogar a matriz para baixo.
	 */
	public void paraBaixo() {
		int[][] tempBackup = UtilFunctions.clone(matriz, tamanhoJogo);
		matriz = UtilFunctions.girar90(matriz, 3);
		boolean b1 = jogarParaDireita();
		matriz = UtilFunctions.girar90(matriz);
		if (b1) {
			adicionarAleatorio();
			matrizBackup = tempBackup;
		}
	}
	
	/**
	 * Função para jogar a matriz para cima.
	 */
	public void paraCima() {
		int[][] tempBackup = UtilFunctions.clone(matriz, tamanhoJogo);
		matriz = UtilFunctions.girar90(matriz);
		boolean b1 = jogarParaDireita();
		matriz = UtilFunctions.girar90(matriz, 3);
		if (b1) {
			adicionarAleatorio();
			matrizBackup = tempBackup;
		}
	}
}

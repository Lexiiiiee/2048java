package com.kpnzstudios.UTILS;

public class UtilFunctions {
	
	/**
	 * Gira uma matriz quadrada em 90 graus.
	 * (Sem efeito colateral).
	 * @param matriz
	 * @return matriz - retorna a matriz girada.
	 */
	public static int[][] girar90(int[][] matriz){
		int[][] temp = clone(matriz, matriz.length);
		int tempMainI = 0;
		int tempMainJ = 0;
		
		for (int i = matriz.length-1; i >= 0; i--) {
			if (tempMainI > matriz.length-1) tempMainI = 0;
			for (int j = 0; j < matriz.length; j++) {
				if (tempMainJ > matriz.length-1) tempMainJ = 0;
				temp[tempMainJ][tempMainI] = matriz[i][j];
				tempMainJ++;
			}
			tempMainI++;
		}
		return temp;	
	}
	
	/**
	 * Gira uma matriz quadrada em 90 graus uma quantidade de vezes.
	 * (Sem efeito colateral).
	 * @param matriz
	 * @param vezes - quantas vezes a matriz vai ser girada em 90 graus.
	 * @return matriz - retorna a matriz girada.
	 */
	public static int[][] girar90(int[][] matriz, int vezes){
		int[][] temp = clone(matriz, matriz.length);
		for (int i = 1; i <= vezes; i++) {
			System.out.println("1");
			temp = girar90(temp);
		}
		return temp;
	}
	
	/**
	 * Função retorna uma matriz clone da principal.
	 * Só pode ser realizado em matrizes quadradas.
	 */
	public static int[][] clone(int[][] matriz, int x){
		int[][] temp = new int[x][x];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < x; j++) {
				temp[i][j] = matriz[i][j];
			}
		}
		return temp;
	}
}
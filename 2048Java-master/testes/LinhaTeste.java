import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.kpnzstudios.KPNz2048.LinhaHorizontal;

class LinhaTeste {

	@Test
	void test() {
		LinhaHorizontal linha = new LinhaHorizontal(2, 0, 2, 2);
		assertEquals(linha.getValues()[0], 2);
		assertEquals(linha.getValues()[1], 0);
		assertEquals(linha.getValues()[2], 2);
		assertEquals(linha.getValues()[3], 2);
	}
	
	@Test
	void testDireita1() {
		LinhaHorizontal linha = new LinhaHorizontal(2, 0, 2, 2);
		linha.jogarDireitaMovimentar();
		assertEquals(linha.getValues()[0], 0);
		assertEquals(linha.getValues()[1], 2);
		assertEquals(linha.getValues()[2], 2);
		assertEquals(linha.getValues()[3], 2);
	}
	
	@Test
	void testDireita2() {
		LinhaHorizontal linha = new LinhaHorizontal(0, 0, 2, 0);
		linha.jogarDireitaMovimentar();
		assertEquals(linha.getValues()[0], 0);
		assertEquals(linha.getValues()[1], 0);
		assertEquals(linha.getValues()[2], 0);
		assertEquals(linha.getValues()[3], 2);
	}
	
	@Test
	void testDireita3() {
		LinhaHorizontal linha = new LinhaHorizontal(2, 0, 0, 0);
		linha.jogarDireitaMovimentar();
		assertEquals(linha.getValues()[0], 0);
		assertEquals(linha.getValues()[1], 0);
		assertEquals(linha.getValues()[2], 0);
		assertEquals(linha.getValues()[3], 2);
	}
	
	@Test
	void testDireita4() {
		LinhaHorizontal linha = new LinhaHorizontal(0, 2, 2, 0);
		linha.jogarDireitaMovimentar();
		assertEquals(linha.getValues()[0], 0);
		assertEquals(linha.getValues()[1], 0);
		assertEquals(linha.getValues()[2], 2);
		assertEquals(linha.getValues()[3], 2);
	}

	@Test
	void testDireitaFundir1() {
		LinhaHorizontal linha = new LinhaHorizontal(0, 2, 2, 0);
		linha.jogarDireitaFundir();
		assertEquals(linha.getValues()[0], 0);
		assertEquals(linha.getValues()[1], 0);
		assertEquals(linha.getValues()[2], 4);
		assertEquals(linha.getValues()[3], 0);
	}
	
	@Test
	void testDireitaFundir2() {
		LinhaHorizontal linha = new LinhaHorizontal(2, 0, 2, 0);
		linha.jogarDireitaFundir();
		assertEquals(linha.getValues()[0], 2);
		assertEquals(linha.getValues()[1], 0);
		assertEquals(linha.getValues()[2], 2);
		assertEquals(linha.getValues()[3], 0);
	}
	
	@Test
	void testDireitaFundir3() {
		LinhaHorizontal linha = new LinhaHorizontal(2, 2, 2, 2);
		linha.jogarDireitaFundir();
		assertEquals(linha.getValues()[0], 0);
		assertEquals(linha.getValues()[1], 4);
		assertEquals(linha.getValues()[2], 0);
		assertEquals(linha.getValues()[3], 4);
	}
	
	@Test
	void testDireitaFundir4() {
		LinhaHorizontal linha = new LinhaHorizontal(0, 0, 0, 2);
		linha.jogarDireitaFundir();
		assertEquals(linha.getValues()[0], 0);
		assertEquals(linha.getValues()[1], 0);
		assertEquals(linha.getValues()[2], 0);
		assertEquals(linha.getValues()[3], 2);
	}

	@Test
	void testFuncional1() {
		LinhaHorizontal linha = new LinhaHorizontal(0, 2, 0, 2);
		linha.jogarDireitaMovimentar();
		linha.jogarDireitaFundir();
		linha.jogarDireitaMovimentar();
		assertEquals(linha.getValues()[0], 0);
		assertEquals(linha.getValues()[1], 0);
		assertEquals(linha.getValues()[2], 0);
		assertEquals(linha.getValues()[3], 4);
	}
	
	@Test
	void testFuncional2() {
		LinhaHorizontal linha = new LinhaHorizontal(2, 2, 0, 2);
		linha.jogarDireitaMovimentar();
		linha.jogarDireitaFundir();
		linha.jogarDireitaMovimentar();
		assertEquals(linha.getValues()[0], 0);
		assertEquals(linha.getValues()[1], 0);
		assertEquals(linha.getValues()[2], 2);
		assertEquals(linha.getValues()[3], 4);
	}
	
	@Test
	void testFuncional3() {
		LinhaHorizontal linha = new LinhaHorizontal(2, 2, 0, 0);
		linha.jogarDireitaMovimentar();
		linha.jogarDireitaFundir();
		linha.jogarDireitaMovimentar();
		assertEquals(linha.getValues()[0], 0);
		assertEquals(linha.getValues()[1], 0);
		assertEquals(linha.getValues()[2], 0);
		assertEquals(linha.getValues()[3], 4);
	}
	
	@Test
	void testFuncional4() {
		LinhaHorizontal linha = new LinhaHorizontal(2, 2, 2, 2);
		linha.jogarDireitaMovimentar();
		linha.jogarDireitaFundir();
		linha.jogarDireitaMovimentar();
		assertEquals(linha.getValues()[0], 0);
		assertEquals(linha.getValues()[1], 0);
		assertEquals(linha.getValues()[2], 4);
		assertEquals(linha.getValues()[3], 4);
		linha.jogarDireitaMovimentar();
		linha.jogarDireitaFundir();
		linha.jogarDireitaMovimentar();
		assertEquals(linha.getValues()[0], 0);
		assertEquals(linha.getValues()[1], 0);
		assertEquals(linha.getValues()[2], 0);
		assertEquals(linha.getValues()[3], 8);
	}
}

package sd;

import java.util.Scanner;

public class Tabuleiro {
	
	public static void iniciarJogo(Campo[][] jogo) {
		for(int i = 0; i < 3; i++) {
			for(int f = 0; f < 3; f++) {
				jogo[i][f] = new Campo();
			}
		}
	}
	
	public static void atualizaTabuleiro(Campo[][] jogo) {
		limparTela();
		System.out.println("    0   1   2");
		System.out.printf("0   %c | %c | %c %n", jogo[0][0].getSimbolo(), jogo[0][1].getSimbolo(), jogo[0][2].getSimbolo());
		System.out.println("    ------------");
		System.out.printf("1   %c | %c | %c %n", jogo[1][0].getSimbolo(), jogo[1][1].getSimbolo(), jogo[1][2].getSimbolo());
		System.out.println("    ------------");
		System.out.printf("2   %c | %c | %c %n", jogo[2][0].getSimbolo(), jogo[2][1].getSimbolo(), jogo[2][2].getSimbolo());
	}
	
	public static int[] jogar(Scanner scan, char simboloAtual) {
		
		System.out.println();
		System.out.printf("%s %c %n", "Quem joga: ", simboloAtual);
		System.out.println("Informa a linha: ");
		int linha = scan.nextInt();
		System.out.println("Informa a coluna: ");
		int coluna = scan.nextInt();
		
		return new int[]{linha, coluna};
	}
	
	public Boolean verificaJogada(Campo[][] jogo, int[] posicao, char simboloAtual) {
		int linha = posicao[0];
		int coluna = posicao[1];
		if(jogo[linha][coluna].getSimbolo() == ' ') {
			jogo[linha][coluna].setSimbolo(simboloAtual);
			return true;
		} else {
			System.out.println("Posição já ocupada! Tente outra.");
			return false;
		}
	}
	
	public static String verificaVitoria(Campo[][] jogo) {

        for (int i = 0; i < 3; i++) {
            if (jogo[i][0].getSimbolo() == jogo[i][1].getSimbolo() && jogo[i][1].getSimbolo() == jogo[i][2].getSimbolo() &&
                jogo[i][0].getSimbolo() != ' ') {
                return String.valueOf(jogo[i][0].getSimbolo());
            }
        }

        for (int i = 0; i < 3; i++) {
            if (jogo[0][i].getSimbolo() == jogo[1][i].getSimbolo() && jogo[1][i].getSimbolo() == jogo[2][i].getSimbolo() &&
                jogo[0][i].getSimbolo() != ' ') {
                return String.valueOf(jogo[0][i].getSimbolo());
            }
        }

        if (jogo[0][0].getSimbolo() == jogo[1][1].getSimbolo() && jogo[1][1].getSimbolo() == jogo[2][2].getSimbolo() &&
            jogo[0][0].getSimbolo() != ' ') {
            return String.valueOf(jogo[0][0].getSimbolo());
        }

        if (jogo[0][2].getSimbolo() == jogo[1][1].getSimbolo() &&
            jogo[1][1].getSimbolo() == jogo[2][0].getSimbolo() &&
            jogo[0][2].getSimbolo() != ' ') {
            return String.valueOf(jogo[0][2].getSimbolo());
        }

        return "";
    }
	
	public static void limparTela() {
		for(int i = 0; i < 200; i++) {
			System.out.println("");
		}
	}

}

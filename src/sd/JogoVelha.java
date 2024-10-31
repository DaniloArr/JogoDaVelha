package sd;

import java.util.Scanner;

public class JogoVelha {

	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro();

		Campo[][] jogo = new Campo[3][3];
		char simboloAtual = 'X';
		Boolean jogoLigado = true;
		String win = "";
		Scanner userInput = new Scanner(System.in);
		
		int countJogadasX = 0;
		int countJogadasO = 0;
		
		Tabuleiro.iniciarJogo(jogo);
		
		while(Boolean.TRUE.equals(jogoLigado)) {
			Tabuleiro.atualizaTabuleiro(jogo);
			if(countJogadasO >= 3 || countJogadasX >= 3) {
				win = Tabuleiro.verificaVitoria(jogo);				
			}
			
			if(!win.equals("")) {
				System.out.printf("Jogador %s venceu", win);
				break;
			}
			
			try {
				if(Boolean.TRUE.equals(tabuleiro.verificaJogada(jogo, Tabuleiro.jogar(userInput, simboloAtual), simboloAtual))) {
					if(simboloAtual == 'X') {
						countJogadasX += 1;
						simboloAtual = 'O';
					} else {
						countJogadasO += 1;
						simboloAtual = 'X';
					}
				}
			} catch (Exception e) {
				System.out.println("ACONTECEU ALGUM ERRO: " + e);
			}
			
		}
		
		System.out.println("\n*** FIM DE JOGO ***");
	}

}

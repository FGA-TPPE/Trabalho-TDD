package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import definicoes.CaminhoSaida;
import definicoes.Delimitador;
import definicoes.FormatoSaida;
import estruturaEvolucoes.EvolucoesMemory;
import estruturaEvolucoes.EvolucoesTime;
import exceptions.ArquivoNaoEncontradoException;
import exceptions.EscritaNaoPermitidaException;

class Menu {
	EvolucoesMemory memories = new EvolucoesMemory();
	EvolucoesTime times = new EvolucoesTime();
	LeitorArquivo leitor = new LeitorArquivo();
	EscritorArquivo escritor = new EscritorArquivo();
	
	Delimitador delimitador = new Delimitador();
	CaminhoSaida saida = new CaminhoSaida();
	FormatoSaida formato = new FormatoSaida();
	
	
	public boolean run() {
		try {
			//System.out.println("lendo");
			leitor.lerArquivo("analysisMemory.out", memories);
			leitor.lerArquivo("analysisTime.out", times);
			//System.out.println("lido");
		}
		catch(ArquivoNaoEncontradoException e) {
			System.out.println(e.getMessage());
			return false;
		}
		
		delimitador.definir();
		System.out.println("Delimitador lido: " + delimitador.getDelimitador());
//		
		try {
			saida.definir();
		} catch (EscritaNaoPermitidaException e) {
			System.out.println(e.getMessage());
			return false;
		}
		System.out.println("Caminho lido: " + saida.getCaminhoSaida());
//		
		formato.definir();
		System.out.println("Formato escolhido: " + formato.getFormatoSaida());
		

		
		escritor.escreverArquivo(
				"analysisMemory.out", 
				times, 
				saida.getCaminhoSaida(), 
				delimitador.getDelimitador(), 
				formato.getFormatoSaida());
		System.out.println("Finalizado");
		return true;
	}
	
}

public class Programa {
	
	public static void main(String[] args) {
		
		new Menu().run();
		
	}

}

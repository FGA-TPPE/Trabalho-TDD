package main;

import definicoes.Definicoes;

import estruturaEvolucoes.EvolucoesMemory;
import estruturaEvolucoes.EvolucoesTime;
import exceptions.ArquivoNaoEncontradoException;
import exceptions.EscritaNaoPermitidaException;

class Menu {
	EvolucoesMemory memories = new EvolucoesMemory();
	EvolucoesTime times = new EvolucoesTime();
	
	LeitorArquivo leitor = new LeitorArquivo();
	EscritorArquivo escritor = new EscritorArquivo();
	
	Definicoes definicoes = new Definicoes();
	
	
	public boolean run() {
		try {
			leitor.lerArquivo("analysisMemory.out", memories);
			leitor.lerArquivo("analysisTime.out", times);
		}
		catch(ArquivoNaoEncontradoException e) {
			System.out.println(e.getMessage());
			return false;
		}
		
		definicoes.definirDelimitador();
		System.out.println("Delimitador lido: " + definicoes.getDelimitador());

		try {
			definicoes.definirCaminhoSaida();
		} catch (EscritaNaoPermitidaException e) {
			System.out.println(e.getMessage());
			return false;
		}

		definicoes.definirFormatoSaida();
		
		escritor.escreverArquivo(
				"analysisMemoryTab.out", 
				memories, 
				definicoes);
		
		escritor.escreverArquivo(
				"analysisTimeTab.out", 
				times, 
				definicoes);
		
		System.out.println("Finalizado");
		
		return true;
	}
	
}

public class Programa {
	public static void main(String[] args) {
		
		Menu menu = new Menu();
		menu.run();
		
	}
}


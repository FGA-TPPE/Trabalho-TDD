package definicoes;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.Scanner;

import exceptions.DelimitadorInvalidoException;
import exceptions.EscritaNaoPermitidaException;
import main.Uteis;

public class CaminhoSaida {
	
	private String caminhoSaida;
	
	public String getCaminhoSaida() {
		return caminhoSaida;
	}
	
	public void definir() throws EscritaNaoPermitidaException{
		boolean valido = false;
		while (!valido) {
			caminhoSaida = Uteis.Input("Digite caminho da sa�da: ");
			
			if(!isValidPath(caminhoSaida)) {
				System.out.print("tente de novo\n");
				//throw new EscritaNaoPermitidaException("Caminho " + caminhoSaida + " n�o permitido");
			}
			else {
				valido = true;
			}
		}
	}
	
	private static boolean isValidPath(String path) {
		// falsifica��o
		return true;
//		System.out.println(path.split("\\")[0]);
//		File f = new File(path.split("\\")[0]);
//		boolean b = f.canWrite();
//		
//		return f.canWrite();
//		return Files.isWritable(path);
//	    try {
//	        Paths.get(path);
//	    } catch (InvalidPathException | NullPointerException ex) {
//	        return false;
//	    }
//	    return true;
	}
	
}

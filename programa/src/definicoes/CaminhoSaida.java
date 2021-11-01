package definicoes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import exceptions.DelimitadorInvalidoException;
import exceptions.EscritaNaoPermitidaException;
import main.Uteis;

public class CaminhoSaida {
	
	static int counter = 1;
	
	private String caminhoSaida = ".\\saida\\";
	
	String getCaminhoSaida() {
		return caminhoSaida;
	}
	
	void definir() throws EscritaNaoPermitidaException{
		boolean valido = false;
		while (!valido) {
			caminhoSaida = Uteis.Input("Digite caminho da sa�da: ");
			
			if(!isValidPath(caminhoSaida)) {
				System.out.print("caminhito invalido, digite outro\n");
//				throw new EscritaNaoPermitidaException("Caminho " + caminhoSaida + " n�o permitido");
			}
			else {
				valido = true;
			}
		}
	}
	
	public boolean isValidPath(String path) {
		File file = new File(path);
		
		if(file.isFile()) {
			return false;
		}
		
		String[] parts = path.split("\\\\");
		
		if(!parts[0].equals(".")) {
			if(parts[0].equals("")) {
				path = "." + path;
			}
			else {
				path = ".\\" + path;
			}
		}
		
		System.out.println("final: " + path);
//		System.out.println("padr�o: " + caminhoSaida);
		
		
		if(path.charAt(path.length()-1) != '\\') {
			path = path + "\\";
		}
		path = path + ".placeholder";
		counter += 1;
		
		Path pathToFile = Paths.get(path);
		File nfile = new File(path);
		if(nfile.exists()) {
			return true;
		}
		try {
			Files.createDirectories(pathToFile.getParent());
			Files.createFile(pathToFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
//		return file.isDirectory();
		
//		if(!file.isDirectory()) {
//			return false;
//		}
//		
//		if(file.exists())
		
		// falsifica��o
		//caminhoSaida = ".\\" + path + "\\";
		
//		String novoCaminho = ""+path;
//		if(path.charAt(path.length()-1) != '\\') {
//			novoCaminho = novoCaminho + "\\";
//		}

		
//		return true;
//		System.out.println(path.split("\\")[0]);
//		File f = new File(".\\" + path + "\\placeholder.out");
//		boolean b = f.canWrite();
//		if(b) {
//			caminhoSaida = ".\\" + path + "\\";
//			return b;
//		}
//		File a = new File(path);
//		b = a.canWrite();
//		if(b) {
//			return b;
//		}
//		return false;
		
//		if(b
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

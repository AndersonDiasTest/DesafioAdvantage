package br.com.keeggo.core;

public class Propriedades {

	public static boolean FECHAR_BROWSER = true;
	public static boolean TIRAR_PRINT = true;
	public static Browsers browser = Browsers.CHROME;
	
	public enum Browsers {
		CHROME,
		FIREFOX,
		EDGE
	}
}

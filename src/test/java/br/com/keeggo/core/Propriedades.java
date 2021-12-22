package br.com.keeggo.core;

public class Propriedades {

	public static boolean FECHAR_BROWSER = true;
	public static boolean TIRAR_PRINT = false;
	public static Browsers browser = Browsers.FIREFOX;
	
	public enum Browsers {
		CHROME,
		FIREFOX,
		EDGE
	}
}

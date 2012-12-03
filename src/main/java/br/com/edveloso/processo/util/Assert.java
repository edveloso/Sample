package br.com.edveloso.processo.util;

import br.com.edveloso.processo.entidade.Processo;

public class Assert {

	public static boolean objectNotNull(Processo processo) {
		return !objectNull(processo);
	}
 
	public static boolean objectNull(Processo processo) {
		return (null == processo);
	}
 
	
}

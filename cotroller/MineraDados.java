package cotroller;

import java.util.ArrayList;
import java.util.List;

public class MineraDados {
	public List<String>mineraDados(List<String> dadosLidos){
		List <String> dadosMinerados = new ArrayList<>();
		for(String linha: dadosLidos) {
			String[]dadosSeparados = linha.split(",");
			Double qtd = Double.valueOf(dadosSeparados[1]);
			Double valor = Double.valueOf(dadosSeparados[2]);
			String valotTotal =  String.valueOf(qtd*valor);
			String linhaMinerada = dadosSeparados[0]+","+valotTotal;
			dadosMinerados.add(linhaMinerada);
		}
		return dadosMinerados;
	}
}

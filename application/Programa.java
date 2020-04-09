package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import cotroller.MineraDados;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Caminho do arquivo:");
		String caminho = sc.nextLine();
		try(BufferedReader br = new BufferedReader(new FileReader(caminho))){
			List <String> dados = new ArrayList<>();
			String linha = br.readLine();
			while(linha!=null) {
				dados.add(linha);
				linha = br.readLine();
			}
			dados = new MineraDados().mineraDados(dados);
			File pasta = new File(caminho);
			caminho = pasta.getParent()+"/out";
			if(new File(caminho).mkdir()) {
				pasta = new File(caminho+"/summary.csv");
				try(BufferedWriter bw = new BufferedWriter(new FileWriter(pasta))){
					for(String linhaMinerada:dados) {
						bw.write(linhaMinerada);
						bw.newLine();
					}
				}
				System.out.println("!!Mineração finalizada!!");
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		sc.close();
	}

}

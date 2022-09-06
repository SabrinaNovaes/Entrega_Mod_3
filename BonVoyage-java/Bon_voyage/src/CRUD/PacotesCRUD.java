package CRUD;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import DAO.pacotesDAO;
import model.Pacotes;

public class PacotesCRUD {

	public static void main (String[] args) {
		
		pacotesDAO pacotesDAO = new pacotesDAO();
		
		 Scanner input = new Scanner(System.in);
		 
		 int opcao = 0;
		 int posicao = 0;
		 
		 int id_pcts;
		 String destinos = "";
		 String hospedagem = "";
		 int precos;
		 int qntd_dias;
		 int qntd_passagem;
		 		 
		 
		 List<Pacotes> pacotes = new ArrayList<Pacotes> ();
		 
		 do {
			 System.out.println("-------Pacotes-------");
			 System.out.println("1 - Cadastrar Pacotes");
			 System.out.println("2 - Consulta Pacotes");
			 System.out.println("3 - Atualizar Pacotes");
			 System.out.println("4 - Delete Pacotes");
			 System.out.println("0 - Sair");
			 
			 opcao = input.nextInt();
			 
			 switch(opcao) {
			 case 1:
				 System.out.println("Cadastrar Pacotes");
				 System.out.println("Destinos: ");
				 destinos = input.nextLine();
				 destinos = input.nextLine();
				 System.out.println("Hospedagem: ");
				 hospedagem = input.nextLine();
				 System.out.println("Quantos dias: ");
				 qntd_dias = input.nextInt();
				 System.out.println("Quantas passagens: ");
				 qntd_passagem = input.nextInt();
				 
				 Pacotes Pacotes = new Pacotes();
				 
				 Pacotes.setDestino(destinos);
				 
				 pacotesDAO.save(Pacotes);
				 
				 System.out.println("Cadastro Realizado!");
				 break;
				 
			 case 2:
				 
				 for (Pacotes a : pacotesDAO.getPacotes()) {
					 System.out.println("Id: " + a.getId_pcts() + "Pacotes" + a.getDestino());	 
				 }
				 
				 System.out.println("Consulta Realizada");
				 break;
				 
			 case 3:
				 
				 System.out.println("Digite o ID Cadastrado: ");
				 id_pcts = input.nextInt();
				 System.out.println("Digite o Destino Cadastrado: ");
				 destinos = input.nextLine();
				 
				 Pacotes pacotes1 = new Pacotes(id_pcts, destinos);
				 pacotesDAO.update(pacotes1);
				 break;
				 
			 case 4:
					
				 System.out.println("Insira o id para excluir o pacote ");
				 posicao = input.nextInt();
				 
				 pacotesDAO.removeById(posicao);
				 
				 System.out.println("Pacote excluido");
				 break;
				 
			 default: 
				 System.out.println(opcao != 0 ? "Opção Inválida, escolha uma opção válida!" : "");
				 break;
			 }
		 }while(opcao != 0);
		 input.close();
		 System.out.println("Finalizado");
	 }


	}
	

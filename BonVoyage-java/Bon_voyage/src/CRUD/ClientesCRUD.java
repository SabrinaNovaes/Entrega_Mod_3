package CRUD;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import DAO.clientesDAO;
import model.Clientes;

public class ClientesCRUD {
	
	 public static void main(String[] args) {
		 
		 clientesDAO clientesDAO = new clientesDAO();
		 
		 Scanner input = new Scanner(System.in);
		 
		 int opcao = 0;
		 int posicao = 0;
		 
		 String id_cpf = "";
		 String nome = "";
		 String email = "";
		 String senha = "";
		 String telefone = "";
		 		 
		 
		 List<Clientes> clientes = new ArrayList<Clientes> ();
		 
		 do {
			 System.out.println("-------CLientes-------");
			 System.out.println("1 - Cadastro Cliente");
			 System.out.println("2 - Consulta Cadastro");
			 System.out.println("3 - Atualizar Cadastro");
			 System.out.println("4 - Delete Cadastro");
			 System.out.println("0 - Sair");
			 
			 opcao = input.nextInt();
			 
			 switch(opcao) {
			 case 1:
				 System.out.println("Cadastrar Cliente");
				 System.out.println("Nome: ");
				 nome = input.nextLine();
				 nome = input.nextLine();
				 System.out.println("CPF: ");
				 id_cpf = input.nextLine();
				 System.out.println("Email: ");
				 email = input.nextLine();
				 System.out.println("Senha: ");
				 senha = input.nextLine();
				 System.out.println("Telefone: ");
				 telefone = input.nextLine();
				 
				 Clientes Clientes = new Clientes();
				 
				 Clientes.setNome(nome);
				 
				 clientesDAO.save(Clientes);
				 
				 System.out.println("Cadastro Realizado!");
				 break;
			 
			 case 2:
				 
				 for (Clientes a : clientesDAO.getClientes()) {
					 System.out.println("Id: " + a.getId_cpf() + "Nome: " + a.getNome());	 
				 }
				 
				 System.out.println("Consulta Realizada");
				 break;
				 
			 case 3:
				 
				 System.out.println("Digite o CPF cadastrado: ");
				 id_cpf = input.nextLine();
				 System.out.println("Digite o nome Cadastrado: ");
				 nome = input.next();
				 
				 Clientes clientes1 = new Clientes(id_cpf, nome);
				 clientesDAO.update(clientes1);
				 break;
				 
				 
			 case 4:
				
				 System.out.println("Insira o CPF para excluir: ");
				 posicao = input.nextInt();
				 
				 clientesDAO.removeById(posicao);
				 
				 System.out.println("Cadastro excluido");
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

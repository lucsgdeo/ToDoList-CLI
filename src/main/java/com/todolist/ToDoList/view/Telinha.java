package com.todolist.ToDoList.view;

import java.util.Scanner;

import com.todolist.ToDoList.model.ListaDeTarefas;
import com.todolist.ToDoList.model.Tarefa;

public class Telinha {
	
	static ListaDeTarefas listaDeTarefas = new ListaDeTarefas();
	static Scanner sc;
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	

	public static void main(String[] args) {
		boolean estado = true;
		
		while (estado) {
			sc = new Scanner(System.in);
			
			System.out.println(
					  "Escolha uma das opções abaixo:\n\n"
					+ "1 - Adicionar nova tarefa\n"
					+ "2 - Remover tarefa\n"
					+ "3 - Ver Lista de tarefas\n"
					+ "4 - Adicionar atômico\n"
					+ "0 - Sair");
			
			System.out.print("Resposta: ");
			String escolha = sc.next();
			
			try {
				int opcao = Integer.valueOf(escolha);
				switch (opcao) {
				case 0:
					estado = false;
					break;
					
				case 1:
					adicionarTarefa();
					break;

				case 2:
					removerTarefa();
					break;
					
				case 3:
					verTarefas();
					break;
					
				case 4:
					adicionarAtomico();
					break;
					
				default:
					System.err.println("erro");
					break;
				}
			} catch (Exception e) {
				System.err.println("Digite um valor numérico");
			}
			
			
		}
		
		sc.close();
	}
	
	public static void adicionarAtomico() {
		System.out.println("Digite o nome da tarefa ou digite sair");
		sc = new Scanner(System.in);
		
		while (true) {
			System.out.print("Valor: ");
			String op = sc.nextLine();
			
			
			if (op.equalsIgnoreCase("sair")) {
				System.out.println();
				break;
			}
			
			adicionarTarefa(op);
			System.out.println("Adicionado");
		}
	}
	
	public static void adicionarTarefa() {
		sc = new Scanner(System.in);
		System.out.print("\nNome da tarefa: ");
		String nome = sc.nextLine();
		int pos = listaDeTarefas.tamanho();

		listaDeTarefas.adicionar(new Tarefa(nome, pos));
		System.out.println();
	}
	
	public static void adicionarTarefa(String nome) {
		int pos = listaDeTarefas.tamanho();

		listaDeTarefas.adicionar(new Tarefa(nome, pos));
		System.out.println();
	}
	
	public static void verTarefas() {
		System.out.print(ANSI_RED);
		for(Tarefa tarefa: listaDeTarefas.getListaDeTarefas()) {
			System.out.printf("%d - %s\n", tarefa.getPos()+1, tarefa.getNome());
		}
		
		System.out.println(ANSI_RESET + "\n");

	}
	
	public static void removerTarefa() {
		sc = new Scanner(System.in);
		verTarefas();
		
		System.out.println("Escolha o numero da tarefa que quer remover: ");
		
		try {
			int pos = sc.nextInt() - 1;
			
			listaDeTarefas.getListaDeTarefas().remove(pos);
			listaDeTarefas.organizarPos();
			
		} catch (Exception e) {
			System.err.println("Escolha um valor numérico");
		}
	}
}

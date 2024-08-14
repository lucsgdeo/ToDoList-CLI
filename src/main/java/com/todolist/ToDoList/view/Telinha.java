package com.todolist.ToDoList.view;

import java.util.Iterator;
import java.util.Scanner;

import com.todolist.ToDoList.model.ListaDeTarefas;
import com.todolist.ToDoList.model.Tarefa;

public class Telinha {
	
	static ListaDeTarefas listaDeTarefas = new ListaDeTarefas();
	static Scanner sc = new Scanner(System.in);
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	

	public static void main(String[] args) {
		
		
		boolean estado = true;
		
		while (estado) {
			System.out.println(
					  "Escolha uma das opções abaixo:\n\n"
					+ "1 - Adicionar nova tarefa\n"
					+ "2 - Remover tarefa\n"
					+ "3 - Ver Lista de tarefas\n"
					+ "0 - Sair\n");
			
			System.out.print("Resposta: ");
			String escolha = sc.next();
			System.out.println();
			
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
					
				default:
					System.out.println("erro");
					break;
				}
			} catch (Exception e) {
				System.out.println("Digite um valor numérico");
			}
			
			
		}
		
		sc.close();
	}
	
	public static void adicionarTarefa() {
		sc = new Scanner(System.in);
		System.out.print("Nome da tarefa: ");
		String nomeTarefa = sc.nextLine();
		int pos = listaDeTarefas.tamanho();

		listaDeTarefas.adicionar(new Tarefa(nomeTarefa, pos));
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
			
			for(Tarefa tarefa: listaDeTarefas.getListaDeTarefas()) {
				if(tarefa.getPos() > 0) tarefa.setPos(tarefa.getPos()-1);;
			}
		} catch (Exception e) {
			System.err.println("Escolha um valor numérico");
		}
	}
}

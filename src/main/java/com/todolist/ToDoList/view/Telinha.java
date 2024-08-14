package com.todolist.ToDoList.view;

import java.util.Scanner;

import com.todolist.ToDoList.model.ListaDeTarefas;
import com.todolist.ToDoList.model.Tarefa;

public class Telinha {
	
	static ListaDeTarefas listaDeTarefas = new ListaDeTarefas();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		
		boolean estado = true;
		int escolha;
		
		while (estado) {
			System.out.println(
					  "Escolha uma das opções abaixo:\n\n"
					+ "1 - Adicionar nova tarefa\n"
					+ "2 - Remover tarefa\n"
					+ "3 - Ver Lista de tarefas\n"
					+ "0 - Sair\n");
			
			escolha = sc.nextInt();
			
			switch (escolha) {
			case 0:
				estado = false;
				break;
				
			case 1:
				adicionarTarefa();
				break;

			case 2:
				break;
				
			case 3:
				verTarefas();
				break;
				
			default:
				break;
			}
		}
		
		sc.close();
	}
	
	public static void adicionarTarefa() {
		sc = new Scanner(System.in);
		System.out.print("\nNome da tarefa: ");
		String nomeTarefa = sc.nextLine();
		int pos = listaDeTarefas.tamanho();

		listaDeTarefas.adicionar(new Tarefa(nomeTarefa, pos));
		System.out.println();
	}
	
	public static void verTarefas() {
		for(Tarefa tarefa: listaDeTarefas.getListaDeTarefas()) {
			System.out.printf("%d - %s", tarefa.getPos()+1, tarefa.getNome());
		}
		
		System.out.println("\n");

	}
}

package com.todolist.ToDoList.model;

import java.util.ArrayList;
import java.util.List;

public class ListaDeTarefas {

	private List<Tarefa> listaDeTarefas = new ArrayList<Tarefa>();

	public ListaDeTarefas(List<Tarefa> listaDeTarefas) {
		this.listaDeTarefas = listaDeTarefas;
	}
	
	public ListaDeTarefas(Tarefa tarefa) {
		this.listaDeTarefas.add(tarefa);
	}
	
	public ListaDeTarefas() {
		
	}
	
	public void adicionar(Tarefa tarefa) {
		listaDeTarefas.add(tarefa);
	}
	
	public int tamanho() {
		return listaDeTarefas.size();
	}

	public List<Tarefa> getListaDeTarefas() {
		return listaDeTarefas;
	}
	
}

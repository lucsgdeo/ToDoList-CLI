package com.todolist.ToDoList.model;

import java.util.ArrayList;
import java.util.List;

public class ListaDeTarefas {

	private List<Tarefa> listaDeTarefas = new ArrayList<Tarefa>();
	
	public ListaDeTarefas(Tarefa[] tarefas) {
		for (Tarefa tarefa: tarefas) {
			listaDeTarefas.add(tarefa);
		}
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
	
	public void organizarPos() {
		listaDeTarefas.forEach(e -> {
			e.setPos(listaDeTarefas.indexOf(e) + 1);
		});;
	}
	
}

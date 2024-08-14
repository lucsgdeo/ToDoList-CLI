package com.todolist.ToDoList.model;

public class Tarefa {

	private String nome;
	private int pos;
	
	public Tarefa(String nome, int pos) {
		this.nome = nome;
		this.pos = pos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

}

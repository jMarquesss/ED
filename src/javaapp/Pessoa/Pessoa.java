/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapp.Pessoa;

import javaapp.ArrayUnorderedList;

/**
 *
 * @author ricar
 */
public class Pessoa {
    private long id;
    private String nome;
    private long idade;
    private String email;
    private ArrayUnorderedList formacoes;
    private ArrayUnorderedList cargos;
    private ArrayUnorderedList skills;
    private ArrayUnorderedList contacts;
    private ArrayUnorderedList mencoes;
    private long visualizacoes;

    public Pessoa(long id, String nome, long idade, String email, ArrayUnorderedList formacoes, ArrayUnorderedList cargos, ArrayUnorderedList skills, ArrayUnorderedList contacts, ArrayUnorderedList mencoes, long visualizacoes) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.formacoes = formacoes;
        this.cargos = cargos;
        this.skills = skills;
        this.contacts = contacts;
        this.mencoes = mencoes;
        this.visualizacoes = visualizacoes;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "Id: " + id +
                "Nome :'" + nome + '\n' +
                "Idade :" + idade + '\n' +
                "Email :'" + email + '\n' +
                "Formacoes Academicas"+'\n'+ formacoes +
                "Cargos Profissionais"+'\n'+ cargos +
                "Skills"+ '\n' + skills +
                "Contactos" +'\n'+ contacts +
                "Mencoes" + '\n'+mencoes +
                "Visualizacoes: " + visualizacoes +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getIdade() {
        return idade;
    }

    public void setIdade(long idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayUnorderedList getformacoes() {
        return formacoes;
    }

    public void setformacoes(ArrayUnorderedList formacoes) {
        this.formacoes = formacoes;
    }

    public ArrayUnorderedList getCargos() {
        return cargos;
    }

    public void setCargos(ArrayUnorderedList cargos) {
        this.cargos = cargos;
    }

    public ArrayUnorderedList getSkills() {
        return skills;
    }

    public void setSkills(ArrayUnorderedList skills) {
        this.skills = skills;
    }

    public ArrayUnorderedList getFormacoes() {
        return formacoes;
    }

    public void setFormacoes(ArrayUnorderedList formacoes) {
        this.formacoes = formacoes;
    }

    public ArrayUnorderedList getContacts() {
        return contacts;
    }

    public void setContacts(ArrayUnorderedList contacts) {
        this.contacts = contacts;
    }

    public ArrayUnorderedList getMencoes() {
        return mencoes;
    }

    public void setMencoes(ArrayUnorderedList mencoes) {
        this.mencoes = mencoes;
    }

    public long getVisualizacoes() {
        return visualizacoes;
    }

    public void setVisualizacoes(long visualizacoes) {
        this.visualizacoes = visualizacoes;
    }
}

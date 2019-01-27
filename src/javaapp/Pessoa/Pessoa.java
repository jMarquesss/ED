/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapp.Pessoa;

/**
 *
 * @author ricar
 */
public class Pessoa {
    private int id;
    private String nome;
    private int idade;
    private String email;
    private FormacaoAcademica formacao;
    private CargosProfissionais cargos;
    private String skills;

    public Pessoa(int id, String nome, int idade, String email, FormacaoAcademica formacao, CargosProfissionais cargos, String skills) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.formacao = formacao;
        this.cargos = cargos;
        this.skills = skills;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public FormacaoAcademica getFormacao() {
        return formacao;
    }

    public void setFormacao(FormacaoAcademica formacao) {
        this.formacao = formacao;
    }

    public CargosProfissionais getCargos() {
        return cargos;
    }

    public void setCargos(CargosProfissionais cargos) {
        this.cargos = cargos;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }
    
    
}

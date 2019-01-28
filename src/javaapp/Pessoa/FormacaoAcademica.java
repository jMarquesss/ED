/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapp.Pessoa;

import java.util.Objects;

/**
 *
 * @author ricar
 */
public class FormacaoAcademica {
    private long ano;
    private String formacao;

    public FormacaoAcademica(long ano, String formacao) {
        this.ano = ano;
        this.formacao = formacao;
    }

    @Override
    public String toString() {
        return "["+
                "ano: " + ano +
                ", formacao: '" + formacao + '\'' +
                ']';
    }

    public long getAno() {
        return ano;
    }

    public void setAno(long ano) {
        this.ano = ano;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }


    
    
    
}

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
public class CargosProfissionais {
    private long ano;
    private String cargo;
    private String empresa;

    public CargosProfissionais(long ano, String cargo, String empresa) {
        this.ano = ano;
        this.cargo = cargo;
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return  "[" +
                "ano: " + ano +
                ", cargo: '" + cargo + '\'' +
                ", empresa: '" + empresa + '\'' +
                ']';
    }

    public long getAno() {
        return ano;
    }

    public void setAno(long ano) {
        this.ano = ano;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.dsw.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author GUSTAVO JUNG
 */
@Entity
@XmlRootElement
public class Modelo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_modelo")
    private Long id_modelo;
    private String nome;
    @OneToMany(mappedBy = "modelo")
    private List<Veiculo> veiculos = new ArrayList<>();

    public Long getId_modelo() {
        return id_modelo;
    }

    public void setId_modelo(Long id_modelo) {
        this.id_modelo = id_modelo;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
    public Long getId() {
        return id_modelo;
    }

    public void setId(Long id) {
        this.id_modelo = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_modelo != null ? id_modelo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modelo)) {
            return false;
        }
        Modelo other = (Modelo) object;
        if ((this.id_modelo == null && other.id_modelo != null) || (this.id_modelo != null && !this.id_modelo.equals(other.id_modelo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.udesc.ceavi.dsw.model.Modelo[ id=" + id_modelo + " ]";
    }
    
}

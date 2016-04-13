/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.jcarvalho.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Josemar
 */
@Entity
@Table(name = "operadora", catalog = "ManegerCompany", schema = "")
@NamedQueries({
    @NamedQuery(name = "Operadora.findAll", query = "SELECT o FROM Operadora o"),
    @NamedQuery(name = "Operadora.findByIdOpe", query = "SELECT o FROM Operadora o WHERE o.idOpe = :idOpe"),
    @NamedQuery(name = "Operadora.findByDesciracaoOpe", query = "SELECT o FROM Operadora o WHERE o.desciracaoOpe = :desciracaoOpe"),
    @NamedQuery(name = "Operadora.findByObsOpe", query = "SELECT o FROM Operadora o WHERE o.obsOpe = :obsOpe")})
public class Operadora implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ope")
    private Integer idOpe;
    @Column(name = "desciracao_ope")
    private String desciracaoOpe;
    @Column(name = "obs_ope")
    private String obsOpe;

    public Operadora() {
    }

    public Operadora(Integer idOpe) {
        this.idOpe = idOpe;
    }

    public Integer getIdOpe() {
        return idOpe;
    }

    public void setIdOpe(Integer idOpe) {
        this.idOpe = idOpe;
    }

    public String getDesciracaoOpe() {
        return desciracaoOpe;
    }

    public void setDesciracaoOpe(String desciracaoOpe) {
        this.desciracaoOpe = desciracaoOpe;
    }

    public String getObsOpe() {
        return obsOpe;
    }

    public void setObsOpe(String obsOpe) {
        this.obsOpe = obsOpe;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOpe != null ? idOpe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Operadora)) {
            return false;
        }
        Operadora other = (Operadora) object;
        if ((this.idOpe == null && other.idOpe != null) || (this.idOpe != null && !this.idOpe.equals(other.idOpe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.jcarvalho.model.Operadora[ idOpe=" + idOpe + " ]";
    }
    
}

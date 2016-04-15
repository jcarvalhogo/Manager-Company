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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Josemar
 */
@Entity
@Table(name = "tipoconweb")
@NamedQueries({
    @NamedQuery(name = "Tipoconweb.findAll", query = "SELECT t FROM Tipoconweb t"),
    @NamedQuery(name = "Tipoconweb.findByIdConWeb", query = "SELECT t FROM Tipoconweb t WHERE t.idConWeb = :idConWeb"),
    @NamedQuery(name = "Tipoconweb.findByDesciracaoConWeb", query = "SELECT t FROM Tipoconweb t WHERE t.desciracaoConWeb = :desciracaoConWeb")})
public class Tipoconweb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_con_web")
    private Integer idConWeb;
    @Basic(optional = false)
    @Column(name = "desciracao_con_web")
    private String desciracaoConWeb;
    @Lob
    @Column(name = "obs_con_web")
    private String obsConWeb;

    public Tipoconweb() {
    }

    public Tipoconweb(Integer idConWeb) {
        this.idConWeb = idConWeb;
    }

    public Tipoconweb(Integer idConWeb, String desciracaoConWeb) {
        this.idConWeb = idConWeb;
        this.desciracaoConWeb = desciracaoConWeb;
    }

    public Integer getIdConWeb() {
        return idConWeb;
    }

    public void setIdConWeb(Integer idConWeb) {
        this.idConWeb = idConWeb;
    }

    public String getDesciracaoConWeb() {
        return desciracaoConWeb;
    }

    public void setDesciracaoConWeb(String desciracaoConWeb) {
        this.desciracaoConWeb = desciracaoConWeb;
    }

    public String getObsConWeb() {
        return obsConWeb;
    }

    public void setObsConWeb(String obsConWeb) {
        this.obsConWeb = obsConWeb;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConWeb != null ? idConWeb.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoconweb)) {
            return false;
        }
        Tipoconweb other = (Tipoconweb) object;
        if ((this.idConWeb == null && other.idConWeb != null) || (this.idConWeb != null && !this.idConWeb.equals(other.idConWeb))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.jcarvalho.model.Tipoconweb[ idConWeb=" + idConWeb + " ]";
    }
    
}

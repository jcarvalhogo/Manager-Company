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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Josemar
 */
@Entity
@Table(name = "telcliente", catalog = "ManegerCompany", schema = "")
@NamedQueries({
    @NamedQuery(name = "Telcliente.findAll", query = "SELECT t FROM Telcliente t"),
    @NamedQuery(name = "Telcliente.findByIdTelCli", query = "SELECT t FROM Telcliente t WHERE t.idTelCli = :idTelCli"),
    @NamedQuery(name = "Telcliente.findByOperadorTelCli", query = "SELECT t FROM Telcliente t WHERE t.operadorTelCli = :operadorTelCli"),
    @NamedQuery(name = "Telcliente.findByNumeroTelCli", query = "SELECT t FROM Telcliente t WHERE t.numeroTelCli = :numeroTelCli"),
    @NamedQuery(name = "Telcliente.findByTipoTelCli", query = "SELECT t FROM Telcliente t WHERE t.tipoTelCli = :tipoTelCli")})
public class Telcliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tel_cli")
    private Integer idTelCli;
    @Basic(optional = false)
    @Column(name = "operador_tel_cli")
    private String operadorTelCli;
    @Basic(optional = false)
    @Column(name = "numero_tel_cli")
    private String numeroTelCli;
    @Basic(optional = false)
    @Column(name = "tipo_tel_cli")
    private String tipoTelCli;
    @Lob
    @Column(name = "obs_tel_cli")
    private String obsTelCli;
    @JoinColumn(name = "id_cli_fis", referencedColumnName = "id_cli_fis")
    @ManyToOne(optional = false)
    private Clientefisico idCliFis;

    public Telcliente() {
    }

    public Telcliente(Integer idTelCli) {
        this.idTelCli = idTelCli;
    }

    public Telcliente(Integer idTelCli, String operadorTelCli, String numeroTelCli, String tipoTelCli) {
        this.idTelCli = idTelCli;
        this.operadorTelCli = operadorTelCli;
        this.numeroTelCli = numeroTelCli;
        this.tipoTelCli = tipoTelCli;
    }

    public Integer getIdTelCli() {
        return idTelCli;
    }

    public void setIdTelCli(Integer idTelCli) {
        this.idTelCli = idTelCli;
    }

    public String getOperadorTelCli() {
        return operadorTelCli;
    }

    public void setOperadorTelCli(String operadorTelCli) {
        this.operadorTelCli = operadorTelCli;
    }

    public String getNumeroTelCli() {
        return numeroTelCli;
    }

    public void setNumeroTelCli(String numeroTelCli) {
        this.numeroTelCli = numeroTelCli;
    }

    public String getTipoTelCli() {
        return tipoTelCli;
    }

    public void setTipoTelCli(String tipoTelCli) {
        this.tipoTelCli = tipoTelCli;
    }

    public String getObsTelCli() {
        return obsTelCli;
    }

    public void setObsTelCli(String obsTelCli) {
        this.obsTelCli = obsTelCli;
    }

    public Clientefisico getIdCliFis() {
        return idCliFis;
    }

    public void setIdCliFis(Clientefisico idCliFis) {
        this.idCliFis = idCliFis;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTelCli != null ? idTelCli.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Telcliente)) {
            return false;
        }
        Telcliente other = (Telcliente) object;
        return !((this.idTelCli == null && other.idTelCli != null) || (this.idTelCli != null && !this.idTelCli.equals(other.idTelCli)));
    }

    @Override
    public String toString() {
        return "com.br.jcarvalho.model.Telcliente[ idTelCli=" + idTelCli + " ]";
    }
    
}

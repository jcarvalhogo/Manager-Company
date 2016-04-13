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
@Table(name = "contatowebcli", catalog = "ManegerCompany", schema = "")
@NamedQueries({
    @NamedQuery(name = "Contatowebcli.findAll", query = "SELECT c FROM Contatowebcli c"),
    @NamedQuery(name = "Contatowebcli.findByIdWebCli", query = "SELECT c FROM Contatowebcli c WHERE c.idWebCli = :idWebCli"),
    @NamedQuery(name = "Contatowebcli.findByDescricaoWebCli", query = "SELECT c FROM Contatowebcli c WHERE c.descricaoWebCli = :descricaoWebCli"),
    @NamedQuery(name = "Contatowebcli.findByTipoWebCli", query = "SELECT c FROM Contatowebcli c WHERE c.tipoWebCli = :tipoWebCli")})
public class Contatowebcli implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_web_cli")
    private Integer idWebCli;
    @Basic(optional = false)
    @Column(name = "descricao_web_cli")
    private String descricaoWebCli;
    @Basic(optional = false)
    @Lob
    @Column(name = "url_web_cli")
    private String urlWebCli;
    @Lob
    @Column(name = "obs_web_cli")
    private String obsWebCli;
    @Basic(optional = false)
    @Column(name = "tipo_web_cli")
    private String tipoWebCli;
    @JoinColumn(name = "id_cli_fis", referencedColumnName = "id_cli_fis")
    @ManyToOne(optional = false)
    private Clientefisico idCliFis;

    public Contatowebcli() {
    }

    public Contatowebcli(Integer idWebCli) {
        this.idWebCli = idWebCli;
    }

    public Contatowebcli(Integer idWebCli, String descricaoWebCli, String urlWebCli, String tipoWebCli) {
        this.idWebCli = idWebCli;
        this.descricaoWebCli = descricaoWebCli;
        this.urlWebCli = urlWebCli;
        this.tipoWebCli = tipoWebCli;
    }

    public Integer getIdWebCli() {
        return idWebCli;
    }

    public void setIdWebCli(Integer idWebCli) {
        this.idWebCli = idWebCli;
    }

    public String getDescricaoWebCli() {
        return descricaoWebCli;
    }

    public void setDescricaoWebCli(String descricaoWebCli) {
        this.descricaoWebCli = descricaoWebCli;
    }

    public String getUrlWebCli() {
        return urlWebCli;
    }

    public void setUrlWebCli(String urlWebCli) {
        this.urlWebCli = urlWebCli;
    }

    public String getObsWebCli() {
        return obsWebCli;
    }

    public void setObsWebCli(String obsWebCli) {
        this.obsWebCli = obsWebCli;
    }

    public String getTipoWebCli() {
        return tipoWebCli;
    }

    public void setTipoWebCli(String tipoWebCli) {
        this.tipoWebCli = tipoWebCli;
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
        hash += (idWebCli != null ? idWebCli.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contatowebcli)) {
            return false;
        }
        Contatowebcli other = (Contatowebcli) object;
        if ((this.idWebCli == null && other.idWebCli != null) || (this.idWebCli != null && !this.idWebCli.equals(other.idWebCli))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.jcarvalho.model.Contatowebcli[ idWebCli=" + idWebCli + " ]";
    }
    
}

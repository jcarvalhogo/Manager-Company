/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.jcarvalho.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Josemar
 */
@Entity
@Table(name = "clientefisico", catalog = "ManegerCompany", schema = "")
@NamedQueries({
    @NamedQuery(name = "Clientefisico.findAll", query = "SELECT c FROM Clientefisico c"),
    @NamedQuery(name = "Clientefisico.findByIdCliFis", query = "SELECT c FROM Clientefisico c WHERE c.idCliFis = :idCliFis"),
    @NamedQuery(name = "Clientefisico.findByNomeCliFis", query = "SELECT c FROM Clientefisico c WHERE c.nomeCliFis = :nomeCliFis"),
    @NamedQuery(name = "Clientefisico.findByRgCliFis", query = "SELECT c FROM Clientefisico c WHERE c.rgCliFis = :rgCliFis"),
    @NamedQuery(name = "Clientefisico.findByCpfCliFis", query = "SELECT c FROM Clientefisico c WHERE c.cpfCliFis = :cpfCliFis"),
    @NamedQuery(name = "Clientefisico.findBySexo", query = "SELECT c FROM Clientefisico c WHERE c.sexo = :sexo"),
    @NamedQuery(name = "Clientefisico.findByDatanascCliFis", query = "SELECT c FROM Clientefisico c WHERE c.datanascCliFis = :datanascCliFis"),
    @NamedQuery(name = "Clientefisico.findByEnderecoCliFis", query = "SELECT c FROM Clientefisico c WHERE c.enderecoCliFis = :enderecoCliFis"),
    @NamedQuery(name = "Clientefisico.findByCidadeCliFis", query = "SELECT c FROM Clientefisico c WHERE c.cidadeCliFis = :cidadeCliFis"),
    @NamedQuery(name = "Clientefisico.findByBairroCliFis", query = "SELECT c FROM Clientefisico c WHERE c.bairroCliFis = :bairroCliFis"),
    @NamedQuery(name = "Clientefisico.findByEstadoCliFis", query = "SELECT c FROM Clientefisico c WHERE c.estadoCliFis = :estadoCliFis"),
    @NamedQuery(name = "Clientefisico.findByCepCliFis", query = "SELECT c FROM Clientefisico c WHERE c.cepCliFis = :cepCliFis"),
    @NamedQuery(name = "Clientefisico.findByFotoCliFis", query = "SELECT c FROM Clientefisico c WHERE c.fotoCliFis = :fotoCliFis")})
public class Clientefisico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cli_fis")
    private Integer idCliFis;
    @Basic(optional = false)
    @Column(name = "nome_cli_fis")
    private String nomeCliFis;
    @Column(name = "rg_cli_fis")
    private String rgCliFis;
    @Basic(optional = false)
    @Column(name = "cpf_cli_fis")
    private String cpfCliFis;
    @Basic(optional = false)
    @Column(name = "sexo")
    private String sexo;
    @Basic(optional = false)
    @Column(name = "datanasc_cli_fis")
    @Temporal(TemporalType.DATE)
    private Date datanascCliFis;
    @Basic(optional = false)
    @Column(name = "endereco_cli_fis")
    private String enderecoCliFis;
    @Basic(optional = false)
    @Column(name = "cidade_cli_fis")
    private String cidadeCliFis;
    @Basic(optional = false)
    @Column(name = "bairro_cli_fis")
    private String bairroCliFis;
    @Basic(optional = false)
    @Column(name = "estado_cli_fis")
    private String estadoCliFis;
    @Basic(optional = false)
    @Column(name = "cep_cli_fis")
    private String cepCliFis;
    @Lob
    @Column(name = "obs_cli_fis")
    private String obsCliFis;
    @Column(name = "foto_cli_fis")
    private String fotoCliFis;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliFis")
    private List<Contatowebcli> contatowebcliList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliFis")
    private List<Telcliente> telclienteList;

    public Clientefisico() {
    }

    public Clientefisico(Integer idCliFis) {
        this.idCliFis = idCliFis;
    }

    public Clientefisico(Integer idCliFis, String nomeCliFis, String cpfCliFis, String sexo, Date datanascCliFis, String enderecoCliFis, String cidadeCliFis, String bairroCliFis, String estadoCliFis, String cepCliFis) {
        this.idCliFis = idCliFis;
        this.nomeCliFis = nomeCliFis;
        this.cpfCliFis = cpfCliFis;
        this.sexo = sexo;
        this.datanascCliFis = datanascCliFis;
        this.enderecoCliFis = enderecoCliFis;
        this.cidadeCliFis = cidadeCliFis;
        this.bairroCliFis = bairroCliFis;
        this.estadoCliFis = estadoCliFis;
        this.cepCliFis = cepCliFis;
    }

    public Integer getIdCliFis() {
        return idCliFis;
    }

    public void setIdCliFis(Integer idCliFis) {
        this.idCliFis = idCliFis;
    }

    public String getNomeCliFis() {
        return nomeCliFis;
    }

    public void setNomeCliFis(String nomeCliFis) {
        this.nomeCliFis = nomeCliFis;
    }

    public String getRgCliFis() {
        return rgCliFis;
    }

    public void setRgCliFis(String rgCliFis) {
        this.rgCliFis = rgCliFis;
    }

    public String getCpfCliFis() {
        return cpfCliFis;
    }

    public void setCpfCliFis(String cpfCliFis) {
        this.cpfCliFis = cpfCliFis;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getDatanascCliFis() {
        return datanascCliFis;
    }

    public void setDatanascCliFis(Date datanascCliFis) {
        this.datanascCliFis = datanascCliFis;
    }

    public String getEnderecoCliFis() {
        return enderecoCliFis;
    }

    public void setEnderecoCliFis(String enderecoCliFis) {
        this.enderecoCliFis = enderecoCliFis;
    }

    public String getCidadeCliFis() {
        return cidadeCliFis;
    }

    public void setCidadeCliFis(String cidadeCliFis) {
        this.cidadeCliFis = cidadeCliFis;
    }

    public String getBairroCliFis() {
        return bairroCliFis;
    }

    public void setBairroCliFis(String bairroCliFis) {
        this.bairroCliFis = bairroCliFis;
    }

    public String getEstadoCliFis() {
        return estadoCliFis;
    }

    public void setEstadoCliFis(String estadoCliFis) {
        this.estadoCliFis = estadoCliFis;
    }

    public String getCepCliFis() {
        return cepCliFis;
    }

    public void setCepCliFis(String cepCliFis) {
        this.cepCliFis = cepCliFis;
    }

    public String getObsCliFis() {
        return obsCliFis;
    }

    public void setObsCliFis(String obsCliFis) {
        this.obsCliFis = obsCliFis;
    }

    public String getFotoCliFis() {
        return fotoCliFis;
    }

    public void setFotoCliFis(String fotoCliFis) {
        this.fotoCliFis = fotoCliFis;
    }

    public List<Contatowebcli> getContatowebcliList() {
        return contatowebcliList;
    }

    public void setContatowebcliList(List<Contatowebcli> contatowebcliList) {
        this.contatowebcliList = contatowebcliList;
    }

    public List<Telcliente> getTelclienteList() {
        return telclienteList;
    }

    public void setTelclienteList(List<Telcliente> telclienteList) {
        this.telclienteList = telclienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliFis != null ? idCliFis.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientefisico)) {
            return false;
        }
        Clientefisico other = (Clientefisico) object;
        if ((this.idCliFis == null && other.idCliFis != null) || (this.idCliFis != null && !this.idCliFis.equals(other.idCliFis))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.jcarvalho.model.Clientefisico[ idCliFis=" + idCliFis + " ]";
    }
    
}

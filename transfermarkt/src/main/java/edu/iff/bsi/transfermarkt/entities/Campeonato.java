package edu.iff.bsi.transfermarkt.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;


@Entity
public class Campeonato implements Serializable{

    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, length = 50)
     @NotBlank(message = "Nome obrigatório.")
    private String nome;


    @Column(nullable = false, length = 50)
    @NotBlank(message = "Temporada atual obritória.")
    private String duracao;

    @Column(nullable = false, length = 50)
    @NotBlank(message = "País obrigatório.")
    private String pais;

    @ManyToMany(mappedBy = "campeonatos")
    private List<Time> times;

    /*public Campeonato(long id, String nome, Date duracao, String pais, List<Time> times) {
        this.id = id;
        this.nome = nome;
        this.duracao = duracao;
        this.pais = pais;
        this.times = times;
    }*/

    public static long getSerialversionuid() {
        return serialVersionUID;
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

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public List<Time> getTimes() {
        return times;
    }

    public void setTimes(List<Time> times) {
        this.times = times;
    }

    


}
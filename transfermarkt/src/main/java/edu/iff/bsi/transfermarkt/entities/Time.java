package edu.iff.bsi.transfermarkt.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "times" )
public class Time implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, length = 50, unique = true)
     @NotBlank(message = "Nome obrigatório.")
    private String nome;

    @Column(nullable = false, length = 50)
    @NotBlank(message = "País obrigatório.")
    private String pais;

    @Column(nullable = false, length = 150)
    private long valor_mercado;

    @Column(nullable = false, length = 50)
    private long valor_elenco;

    @OneToMany(mappedBy = "time")
    private List<Jogador> jogadores;

    @ManyToMany
    @JoinTable(name = "associacao_times_campeonatos", joinColumns = @JoinColumn(name = "fk_time"), inverseJoinColumns = @JoinColumn(name = "fk_campeoanato"))
    private List<Campeonato> campeonatos;
   

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

    public String getPais() {

        return pais;

    }

    public void setPais(String pais) {

        this.pais = pais;

    }

    public long getValor_mercado() {

        return valor_mercado;

    }

    public void setValor_mercado(long valor_mercado) {

        this.valor_mercado = valor_mercado;

    }

    public long getValor_elenco() {

        return valor_elenco;

    }

    public void setValor_elenco(long valor_elenco) {

        this.valor_elenco = valor_elenco;

    }

    public List<Jogador> getJogadores() {

        return jogadores;

    }

    public void setJogadores(List<Jogador> jogadores) {

        this.jogadores = jogadores;

    }

    public List<Campeonato> getCampeonatos() {

        return campeonatos;

    }

    public void setCampeonatos(List<Campeonato> campeonatos) {

        this.campeonatos = campeonatos;

    }





}
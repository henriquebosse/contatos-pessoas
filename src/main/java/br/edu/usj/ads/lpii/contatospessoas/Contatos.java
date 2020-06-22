package br.edu.usj.ads.lpii.contatospessoas;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Contatos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String nome;
    String endereco;
    String numero;
    String bairro;
    String cidade;
    String cep;
    String email;
    String telefone;
    Date dtCadastro;
    
}
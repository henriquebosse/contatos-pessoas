package br.edu.usj.ads.lpii.contatospessoas;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface ContatosRepository extends PagingAndSortingRepository <Contatos, Long> {
    List<Contatos> findAll();
}
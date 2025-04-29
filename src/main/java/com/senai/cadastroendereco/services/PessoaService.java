package com.senai.cadastroendereco.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.cadastroendereco.entities.Pessoa;
import com.senai.cadastroendereco.repositories.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	//Salvar Pessoa
	public Pessoa salvar(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	//Buscar todas as Pessoas
	public List<Pessoa> listarTodas(){
		return pessoaRepository.findAll();
	}
	
	//Buscar pessoa por ID
	public Pessoa buscarPorId(Long id) {
		return pessoaRepository.findById(id).orElse(null);
	}
	
	//Buscar pessoa por email
	public Pessoa buscarPorEmail(String email) {
		return pessoaRepository.findByEmail(email);
	}
	
	//Verificar email e senha do login
	public Pessoa autenticarPessoa(String email, String senha) {
		
		//Verifica existência do email
		Pessoa pessoa = pessoaRepository.findByEmail(email);
		
		//Se qualquer dado da pessoa for nulo e o getSenha seja igual a senha
		if(pessoa != null && pessoa.getSenha().equals(senha)) {
			return pessoa;
		}
		else {
			return null;
		}
	}
	
	//Deletar pessoa por ID
	public void deletarPorId(Long id) {
		pessoaRepository.deleteById(id);
	}
}

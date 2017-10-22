package com.webbiko.pontointeligente.api.services.impl;

import com.webbiko.pontointeligente.api.entities.Funcionario;
import com.webbiko.pontointeligente.api.repositories.FuncionarioRepository;
import com.webbiko.pontointeligente.api.services.FuncionarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    private static Logger log = LoggerFactory.getLogger(FuncionarioServiceImpl.class);

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public Funcionario persistir(Funcionario funcionario) {
        log.info("Persistindo funcionario {}", funcionario);
        return funcionarioRepository.save(funcionario);
    }

    @Override
    public Optional<Funcionario> buscarPorCpf(String cpf) {
        log.info("Buscando funcionario pelo cpf: {}", cpf);
        return Optional.ofNullable(funcionarioRepository.findByCpf(cpf));
    }

    @Override
    public Optional<Funcionario> buscarPorEmail(String email) {
        log.info("Buscando funcionario pelo email: {}", email);
        return Optional.ofNullable(funcionarioRepository.findByEmail(email));
    }

    @Override
    public Optional<Funcionario> buscarPorId(long id) {
        log.info("Buscando funcionario pelo id: {}", id);
        return Optional.ofNullable(funcionarioRepository.findOne(id));
    }
}
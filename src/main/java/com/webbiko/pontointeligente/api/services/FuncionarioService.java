package com.webbiko.pontointeligente.api.services;

import com.webbiko.pontointeligente.api.entities.Funcionario;

import java.util.Optional;

public interface FuncionarioService {

    Funcionario persistir(final Funcionario funcionario);

    Optional<Funcionario> buscarPorCpf(final String cpf);

    Optional<Funcionario> buscarPorEmail(final String email);

    Optional<Funcionario> buscarPorId(final long id);
}
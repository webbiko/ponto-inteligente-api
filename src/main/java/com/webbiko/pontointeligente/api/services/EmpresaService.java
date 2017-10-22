package com.webbiko.pontointeligente.api.services;

import com.webbiko.pontointeligente.api.entities.Empresa;

import java.util.Optional;

public interface EmpresaService {

    Optional<Empresa> buscarPorCnpj(final String cnpj);

    Empresa persistir(final Empresa empresa);
}
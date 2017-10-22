package com.webbiko.pontointeligente.api.repositories;

import com.webbiko.pontointeligente.api.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    @Transactional(readOnly = true)
    Empresa findByCnpj(final String cnpj);
}

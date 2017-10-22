package com.webbiko.pontointeligente.api.repositories;

import com.webbiko.pontointeligente.api.BaseTest;
import com.webbiko.pontointeligente.api.entities.Empresa;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class EmpresaRepositoryTest extends BaseTest {

    private static final String CNPJ = "68244391000123";
    @Autowired
    private EmpresaRepository empresaRepository;

    @Before
    public void setUp() {
        final Empresa empresa = new Empresa();
        empresa.setCnpj(CNPJ);
        empresa.setRazaoSocial("Exemplo de empresa");
        empresaRepository.save(empresa);
    }

    @After
    public void tearDown() {
        empresaRepository.deleteAll();
    }

    @Test
    public void testBuscarPorCnpj() {
        final Empresa empresa = empresaRepository.findByCnpj(CNPJ);
        assertEquals(CNPJ, empresa.getCnpj());
    }
}
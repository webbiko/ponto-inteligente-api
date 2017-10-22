package com.webbiko.pontointeligente.api.services;

import com.webbiko.pontointeligente.api.BaseTest;
import com.webbiko.pontointeligente.api.entities.Empresa;
import com.webbiko.pontointeligente.api.repositories.EmpresaRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class EmpresaServiceTest extends BaseTest {
    @MockBean
    private EmpresaRepository empresaRepository;

    @Autowired
    private EmpresaService empresaService;

    private static final String CNPJ = "51463645000100";

    @Before
    public void setUp() throws Exception {
        BDDMockito.given(this.empresaRepository.findByCnpj(Mockito.anyString())).willReturn(new Empresa());
        BDDMockito.given(this.empresaRepository.save(Mockito.any(Empresa.class))).willReturn(new Empresa());
    }

    @Test
    public void testBuscarEmpresaPorCnpj() {
        Optional<Empresa> empresa = this.empresaService.buscarPorCnpj(CNPJ);

        assertTrue(empresa.isPresent());
    }

    @Test
    public void testPersistirEmpresa() {
        Empresa empresa = this.empresaService.persistir(new Empresa());

        assertNotNull(empresa);
    }
}
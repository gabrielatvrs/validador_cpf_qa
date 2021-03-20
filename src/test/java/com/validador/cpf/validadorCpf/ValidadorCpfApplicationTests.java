package com.validador.cpf.validadorCpf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.validador.cpf.validadorCpf.models.Cliente;

@SpringBootTest
class ValidadorCpfApplicationTests {

	@Test
	void fazendoTesteDeCpfValido() {
		Cliente cliente = new Cliente();
		cliente.setNome("Gabi");
		cliente.setCpf("73485005010");
		assertEquals(true, cliente.validaCPF());
	}

	@Test
	void fazendoTesteDeCpfInvalido() {		
		Cliente cliente = new Cliente();
		cliente.setNome("Gabi");
		cliente.setCpf("1325220108911");
		assertEquals(false, cliente.validaCPF());
	}

	@Test
	void fazendoTesteDeCpfComDigitoAMenos() {
		Cliente cliente = new Cliente();
		cliente.setNome("Gabi");
		cliente.setCpf("1325220108");
		assertEquals(false, cliente.validaCPF());
	}

	@Test
	void fazendoTesteDeCpfValidoComPontos() {
		Cliente cliente = new Cliente();
		cliente.setNome("Gabi");
		cliente.setCpf("132.522.010-89");
		assertEquals(true, cliente.validaCPF());
	}

	@Test
	void fazendoTesteDeCpfInvalidoComPontos() {
		Cliente cliente = new Cliente();
		cliente.setNome("Gabi");
		cliente.setCpf("132.522.010-11");
		assertEquals(false, cliente.validaCPF());
	}

	@Test
	void fazendoTesteDeCpfInvalidoComVirgulas() {
		Cliente cliente = new Cliente();
		cliente.setNome("Gabi");
		cliente.setCpf("132,522,010,89");
		assertEquals(false, cliente.validaCPF());
	}

	@Test
	void fazendoTesteDeCpfValidoComEspacoNoComeco() {
		Cliente cliente = new Cliente();
		cliente.setNome("Gabi");
		cliente.setCpf(" 13252201089");
		assertEquals(true, cliente.validaCPF());
	}

	@Test
	void fazendoTesteDeCpfValidoComEspacoNoFinal() {
		Cliente cliente = new Cliente();
		cliente.setNome("Gabi");
		cliente.setCpf("13252201089 ");
		assertEquals(true, cliente.validaCPF());
	}

	@Test
	void fazendoTesteDeCpfInvalidoQuePassou() {
		Cliente cliente = new Cliente();
		cliente.setNome("Gabi");
		cliente.setCpf("69b.969.790-88");
		assertEquals(false, cliente.validaCPF());
	}	
}

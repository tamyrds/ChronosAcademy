package transferencia;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ContaTest {

    Cliente xuxa;
    Cliente silvoSantos;
    Conta contaXuxa;
    Conta contaSilvosantos;

    @BeforeEach
    void setUp() {
        xuxa = new Cliente("xuxa", "88888888888","554545454");
        silvoSantos = new Cliente("silvoSantos","55545115151","5247855554");

        contaXuxa = new Conta("0001","456123",2500.00, xuxa);
        contaSilvosantos = new Conta("0025", "789456",3500.00, silvoSantos);
    }

    @Test
    public void realizarTransação(){
        contaXuxa.realizaTransferencia(1000.00,contaSilvosantos);
        assertEquals(1500.00, contaXuxa.getSaldo());
        assertEquals(4500.00,contaSilvosantos.getSaldo());
    }

    @Test
    public void validarTransferenciaInvalida(){
        boolean resultado =  contaXuxa.realizaTransferencia(3500.00,contaSilvosantos);
        assertFalse(resultado);
    }

    @Test
    public void validarPropriedades(){
        assertEquals(xuxa,contaXuxa.getProprietario());
    }

    @Test
    public void validarDeposito(){
        contaSilvosantos.realizarDeposito(500.00);
        assertEquals(4000.00, contaSilvosantos.getSaldo());
    }

    @Test
    public void validaAgencia(){
        assertEquals("0025",contaSilvosantos.getAgencia());
    }
    @Test
    public void validaConta(){
        assertEquals("456123",contaXuxa.getNumeroConta());
    }
    @Test
    public void validaNome(){
        assertEquals("xuxa",xuxa.getNome());
    }

    @Test
    public void validaCPF(){
        assertEquals("55545115151",silvoSantos.getCpf());
    }
    @Test
    public void validaRG(){
        assertEquals("5247855554",silvoSantos.getRg());
    }
}
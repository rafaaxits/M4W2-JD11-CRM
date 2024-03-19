import junit.framework.TestCase;
import org.example.ClientBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClientBuilderTest extends TestCase {

    private ClientBuilder clientBuilder1;

    private ClientBuilder clientBuilder2;

    @Before
    public void setUp() {
        clientBuilder1 = new ClientBuilder().comIdentificacao("Maria", "Teste da",
                        "Silva", "987.654.321-00", "01/10/2003", 'F')
                .comContatos("maria_teste@mail.com", "Av Boa vista", "(81) 9.1111-1111");
        clientBuilder2 = new ClientBuilder();
    }

    @Test
    public void testGetEndereco() {
        assertEquals("Av Boa vista", clientBuilder1.getEndereco());
        assertNull(clientBuilder2.getEndereco());
    }

    @Test
    public void testSetEndereco() {
        assertEquals("Av Boa vista", clientBuilder1.getEndereco());
        assertNull(clientBuilder2.getEndereco());
        clientBuilder1.setEndereco("Rua teste vila");
        clientBuilder2.setEndereco("Avenida dos testes");
        assertEquals("Rua teste vila", clientBuilder1.getEndereco());
        assertEquals("Avenida dos testes", clientBuilder2.getEndereco());
    }

    @Test (expected = RuntimeException.class)
    public void testSetEmailFailure() throws RuntimeException {
        Assert.assertThrows(RuntimeException.class, () -> {
           clientBuilder2.setEmail("testegmail.com");
        });
    }

    @Test
    public void testSetEmail() {
        clientBuilder2.setEmail("teste_teste@gmail.com");
        assertEquals("teste_teste@gmail.com", clientBuilder2.getEmail());
    }

    @Test
    public void testSetTelefoneInvalidInput() {
        assertEquals("(81) 9.1111-1111", clientBuilder1.getTelefone());
        clientBuilder1.setTelefone("0000");
        assertEquals("(81) 9.1111-1111", clientBuilder1.getTelefone());
        clientBuilder2.setTelefone("0000");
        assertNull(clientBuilder2.getTelefone());
    }

    @Test
    public void testTelefoneRegex(){
        String regex = "(\\([0-9]{2}\\)\\s?[0-9].{4,5}-?[0-9]{3,4})|([0-9]{10,11})|([0-9]{2}\\s?[0-9]{8,9})";
        assertTrue(clientBuilder1.getTelefone().matches(regex));
    }

    @Test
    public void testGetTelefone() {
        assertEquals("(81) 9.1111-1111", clientBuilder1.getTelefone());
        assertNull(clientBuilder2.getTelefone());
    }
}

import org.example.IMC;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class IMCTest {
    String [] nombres;
    boolean [] resultadosEsperadosParaNombres;
    double [] pesosIncorrectos;
    int [] alturasIncorrectas;



    @BeforeEach
    public void init(){
        nombres = new String[]{"", " ", "Juanito23", "Pedro Díaz", "/&!(", "     ", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"};
        resultadosEsperadosParaNombres = new boolean[]{false, false, false, true, false, false, false};

        pesosIncorrectos = new double[]{-1000, 1000, 350, -1, 0, 10};

        alturasIncorrectas = new int[]{-1000, 1000, -1, 0, 300, 50};
    }

    @Test
    public void nombreEsValidoTest(){
        boolean resultadoCorrecto = true;
        for(int i=0; i < nombres.length; i++){
            if(IMC.nombreEsValido(nombres[i]) != resultadosEsperadosParaNombres[i]){
                resultadoCorrecto = false;
            }
        }
        assertTrue(resultadoCorrecto); // Verifica si el programa responde correctamente ante casos extremos de nombres
    }

    @Test
    public void pesoEsValidoTest(){
        for (double pesoIncorrecto : pesosIncorrectos) {
            assertFalse(IMC.pesoEsValido(pesoIncorrecto)); // Verifica si el programa responde correctamente ante casos incorrectos de pesos
        }
    }

    @Test
    public void AlturaEsValidaTest(){
        for (int alturaIncorrecta : alturasIncorrectas){
            assertFalse(IMC.alturaEsValida(alturaIncorrecta)); // Verifica si el programa responde correctamente ante casos incorrectos de alturas
        }
    }

}

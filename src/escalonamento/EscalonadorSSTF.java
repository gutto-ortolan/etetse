package escalonamento;

/**
 *
 * @author augusto.ortolan
 */
public class EscalonadorSSTF {
    /*
     * • Escalonamento de disco – SSTF (shortest seek time first).
     * • Busca pelo cilindro mais próximo – posicionamento mais curto primeiro.
     * • Varredura total da fila.
     * • Setores podem ser prejudicados
    */
    
    private final Integer elementos[];
    private final Integer nrInicial;
    private Integer controlador;
    private Integer comparador;
    private Integer substituto;
    private Integer numero;
    private Integer auxiliar;
    private Integer valor;

    public EscalonadorSSTF(Integer nrInicial, Integer elementos[]) {
        this.elementos = elementos;
        this.nrInicial = nrInicial;
    }

    public Integer processoSstf() {
        arrumaLista();
        
        //Retorna o numero somado, no metodo soma.
        return SomaDistancias.soma(nrInicial, elementos);
    }

    private void arrumaLista() {
        /*
         * • Método para arrumar a lista adicionada pelo usuário.
         * • Faz o processo de verificar e comparar dois números.
         * • Se a subtração do n1 com o número inicial for menor do que
         * a subtração do n2 com o número inicial, os números continuam em suas posições,
         * se acontecer ao contrário, eles se invertem de posição.
        */
        controlador = 0;
        numero = controlador;
        substituto = controlador;
        comparador = controlador;
        valor = nrInicial;

        while (controlador < elementos.length) {
            //Math.abs = valor(menor) - valor(maior) = valor absoluto ou valor positivo
            substituto = Math.abs(valor - elementos[controlador]);
            for (int i = numero + 1; i < elementos.length; i++) {
                comparador = Math.abs(valor - elementos[i]);
                if (comparador < substituto) {
                    substituto = comparador;
                    auxiliar = elementos[controlador];
                    elementos[controlador] = elementos[i];
                    elementos[i] = auxiliar;
                }
            }

            valor = elementos[controlador];
            controlador++;
            numero = controlador;
        }
    }

}

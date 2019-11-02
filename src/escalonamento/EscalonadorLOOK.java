package escalonamento;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author augusto.ortolan
 */
public class EscalonadorLOOK {
    /*
     * • Escalonamento de disco – LOOK.
     * • Semelhante ao SCAN, porém não existe a necessidade de ir até o final do
     * disco, apenas até o “último” endereço a ser atendido.
    */

    private Integer elementos[];
    private final Integer nrInicial;
    private final List<Integer> listaMaior = new ArrayList();
    private final List<Integer> listaMenor = new ArrayList();

    public EscalonadorLOOK(Integer nrInicial, Integer elementos[]) {
        this.elementos = elementos;
        this.nrInicial = nrInicial;
    }

    public Integer processoLook() {
        //Monta a lista usando o metodo separador.
        List<Integer> listaNumeros = separador();
        
        elementos = new Integer[listaNumeros.size()];
        for (int i = 0; i < listaNumeros.size(); i++) {
            elementos[i] = listaNumeros.get(i);
        }
        
        //Retorna o numero somado, no metodo soma.
        return SomaDistancias.soma(nrInicial, elementos);
    }

    private List<Integer> separador() {
        /*
         * • Faz o processo de separar os menores e os maiores do
         * que o número inicial para listas diferentes.
         */  
        for (Integer elemento : elementos) {
            if (elemento > nrInicial) {
                listaMaior.add(elemento);
            } else {
                listaMenor.add(elemento);
            }
        }
        //Ornada a lista dos maiores.
        Collections.sort(listaMaior);
        
        //Junta as duas listas em apenas uma.
        listaMenor.addAll(listaMaior);
        return listaMenor;
    }
}

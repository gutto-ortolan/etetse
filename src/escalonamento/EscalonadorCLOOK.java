package escalonamento;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author augusto.ortolan
 */
public class EscalonadorCLOOK {
    /*
     * • Escalonamento de disco – C-LOOK.
     * • Circular-LOOK.
     * • Semelhante ao C-SCAN, porém não existe a necessidade de ir até o final do
     * disco, apenas até o “último” endereço a ser atendido
    */

    private Integer elementos[];
    private final Integer nrInicial;

    public EscalonadorCLOOK(Integer nrInicial, Integer elementos[]) {
        this.elementos = elementos;
        this.nrInicial = nrInicial;
    }

    public Integer processoClook() {
        //Monta as duas listas, ocupando os metodos separadores.
        List<Integer> menores = listaMenores();
        List<Integer> maiores = listaMaiores();

        //Acha qual vai ser o ultimo valor, para não escostar na parede.
        Integer ultimoValor = maiores.get(maiores.size() - 1);

        //Acha qual vai ser o primeiro valor, para não encostar na parede.
        Integer primeiroValor = menores.get(0);

        //Junta as duas lista (maiores e menores) em apenas uma.
        maiores.addAll(menores);
        
        elementos = new Integer[maiores.size()];
        for (int i = 0; i < maiores.size(); i++) {
            elementos[i] = maiores.get(i);
        }
        
        //Retorna o numero somado, no metodo soma.
        return SomaDistancias.soma(nrInicial, elementos) - (ultimoValor - primeiroValor);
    }

    private List<Integer> listaMenores() {
        /*
         * • Separa os menores do que o inicial 
         * da lista original para uma outra lista.
         */
        List<Integer> list = new ArrayList();
        for (Integer elemento : elementos) {
            if (elemento < nrInicial) {
                list.add(elemento);
            }
        }

        //Ordena a lista.
        Collections.sort(list);
        return list;
    }

    private List<Integer> listaMaiores() {
        /*
        * Separa os maiores do que o inicial 
        * da lista original para uma outra lista.
         */
        List<Integer> list = new ArrayList();
        for (Integer elemento : elementos) {
            if (elemento > nrInicial) {
                list.add(elemento);
            }
        }

        //Ordena a lista.
        Collections.sort(list);
        return list;
    }

}

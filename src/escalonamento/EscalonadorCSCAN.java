package escalonamento;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author augusto.ortolan
 */
public class EscalonadorCSCAN {
    /*
     * • Escalonamento de disco – C-SCAN.
     * • Circular-SCAN.
     * • Semelhante ao SCAN, porém ao chegar ao final, “pula” para o lado oposto e
     * começa a atender as solicitações no mesmo sentido.
    */

    private Integer elementos[];
    private final Integer nrInicial;
    private final Integer limiteDisco;
    private final List<Integer> listMaior = new ArrayList();
    private final List<Integer> listMenor = new ArrayList();

    public EscalonadorCSCAN(Integer nrInicial, Integer elementos[], Integer limiteDisco) {
        this.elementos = elementos;
        this.nrInicial = nrInicial;
        this.limiteDisco = limiteDisco;
    }

    public Integer processoCscan() {
        //Monta a lista usando o metodo separador.
        List<Integer> listaNumeros = separador();
        
        elementos = new Integer[listaNumeros.size()];
        for (int i = 0; i < listaNumeros.size(); i++) {
            elementos[i] = listaNumeros.get(i);
        }
        
        //Retorna o numero somado, no metodo soma.
        return SomaDistancias.soma(nrInicial, elementos) - (limiteDisco - 1);
    }

    private List<Integer> separador() {
        /*
         * • Faz o processo de separar os menores e os maiores do
         * que o número inicial para listas diferentes.
         */   
        
        //Adiciona o 0 para que haja a parede.
        listMenor.add(0);
        
        for (Integer elemento : elementos) {
            if (elemento > nrInicial) {
                listMaior.add(elemento);
            } else {
                listMenor.add(elemento);
            }
        }
        
        //Adiciona o 199 para que haja a parede.
        listMaior.add(limiteDisco - 1);
        
        //Ordena as listas.
        Collections.sort(listMaior);
        Collections.sort(listMenor);
        
        //Junta tudo em apenas uma lista.
        listMaior.addAll(listMenor);
        return listMaior;
    }
}

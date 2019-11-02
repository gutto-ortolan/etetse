package escalonamento;

/**
 *
 * @author augusto.ortolan
 */
public class EscalonadorFCFS {
    /*
     * • Escalonamento de disco – FCFS (first come first served).
     * • Primeiro a chegar, primeiro a ser servido
    */
    
    private final Integer elementos[];
    private final Integer nrInicial;
    private Integer lista[];

    public EscalonadorFCFS(Integer nrInicial, Integer elementos[]) {
        this.elementos = elementos;
        this.nrInicial = nrInicial;
    }

    public Integer processoFcfs() {
        lista = new Integer[elementos.length];
        
        //Mantém a ordem original da lista que foi adicionada.
        System.arraycopy(elementos, 0, lista, 0, elementos.length);
        
        //Retorna o numero somado, no metodo soma.
        return SomaDistancias.soma(nrInicial, elementos);
    }

}

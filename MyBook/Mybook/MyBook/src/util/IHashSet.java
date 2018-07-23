package util;

public interface IHashSet {
    /**
     * Adicionar um elemento à estrutura.
     * @param o Objeto a ser inserido.
     */
    public void add(Object o);
    public void clear();
    /**
     * Verificar se um objeto está presente na estrutura.
     * @param key chave referente ao objeto buscado.
     * @return true, se o objeto estiver contido, falso caso contrário.
     */
    public boolean contains(Object key);
    public boolean isEmpty();
    /**
     * Remover a partir de chave.
     * @param o Objeto a ser removido
     * @return Verdadeiro ser remover, falso caso não o faça.
     */
    public boolean remove(Object o);
    /**
     * Utilizado para pegar a quantidade de elementos da estrutura.
     * @return quantidade de elementos presentes na estrutura.
     */
    public int size();
}

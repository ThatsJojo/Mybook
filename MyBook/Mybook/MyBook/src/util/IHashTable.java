package util;

import java.util.Iterator;

public interface IHashTable {
    /**
     * Verificar se um objeto está presente na estrutura a partir de uma chave.
     * @param key chave referente ao objeto buscado.
     * @return true, se o objeto estiver contido, falso caso contrário.
     */
    public boolean contains(Object key);
    /**
     * Utilizdo para inserir um conjudo Chave-Conteúdo na estrutura.
     * @param key parâmetro utilizado para procurar o conteúdo.
     * @param value Conteúdo a ser procurado.
     */
    public void put(Object key, Object value);
    /**
     * Buscar objeto a partir de java.
     * @param key chave característica do objeto em questão.
     * @return Objeto buscado a partir da chave.
     */
    public Object get(Object key);
    /**
     * Remover a partir de chave.
     * @param key Chave referente ao objeto.
     * @return true se a remoção for executada, false caso contrário.
     */
    public boolean removeKey(Object key);
    /**
     * Remover por objeto a ser buscado.
     * @param value Conteúdo do objeto.
     * @return true, caso seja removido, e false em caso contrário.
     */
    public boolean removeValue(Object value);
    public boolean isEmpty();
    /**
     * Gera um iterador para os dados presentes no array.
     * @return iterador da estrutura.
     */
    public Iterator iterator();
    /**
     * @return quantidade de dados armazenados na estrutura.
     */
    public int size();
    
}

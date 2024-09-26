class Lista {
    private int[] array; // a lista em si
    private int n; // num de elementos

    public Lista() { // construtor sem param
        this(10);
    }

    public Lista(int tam) { // construtor com param
        array = new int[tam];
        n = 0;
    }

    public void inserirInicio(int x) throws Exception { // insere o elemento x no inicio do array
        if (n >= array.length) {
            throw new Exception("Erro! -- Lista cheia");
        }

        for (int i = n; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = x;
        n++;
    }

    public void inserirFim(int x) throws Exception { // insere o elemento x no fim do array
        if (n >= array.length) {
            throw new Exception("Erro! -- Lista cheia");
        }

        array[n] = x;
        n++;
    }

    public void inserir(int x, int pos) throws Exception {
        if (n >= array.length || pos < 0 || pos > n) {
            throw new Exception("Erro! -- Lista cheia OU posição inválida");
        }

        for (int i = n; i > pos; i--) {
            array[i] = array[i - 1];
        }
        array[pos] = x;
        n++;
    }

    public int removerInicio() throws Exception {
        if (n == 0) {
            throw new Exception("Erro! -- Lista vazia");
        }
        int itemRemovido = array[0];
        n--;

        for (int i = 0; i < n; i++) {
            array[i] = array[i + 1];
        }
        return itemRemovido;
    }

    public int removerFim() throws Exception {
        if (n == 0) {
            throw new Exception("Erro! -- Lista vazia");
        }
        n--;
        int itemRemovido = array[n];
        return itemRemovido;
    }

    public int remover(int pos) throws Exception {
        if (n == 0 || pos < 0 || pos > n) {
            throw new Exception("Erro! -- Lista vazia OU posição inválida");
        }
        int itemRemovido = array[pos];
        n --;

        for (int i = pos; i < n; i ++){
            array[i] = array [i+1];
        }

        return itemRemovido;
    }
}
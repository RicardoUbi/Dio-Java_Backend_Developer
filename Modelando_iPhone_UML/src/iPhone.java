public class iPhone implements ReprodutorMusical, AparelhoTelefonico, NavegadorInternet {
    private String musicaAtual;
    private String numeroLigacao;
    private String urlPagina;

    @Override
    public void tocarMusica() {
        if (musicaAtual != null) {
            System.out.println("Tocando a música: " + musicaAtual);
        } else {
            System.out.println("Nenhuma música selecionada.");
        }
    }

    @Override
    public void pausarMusica() {
        if (musicaAtual != null) {
            System.out.println("Pausando a música: " + musicaAtual);
        } else {
            System.out.println("Nenhuma música selecionada.");
        }
    }

    @Override
    public void selecionarMusica(String musica) {
        this.musicaAtual = musica;
        System.out.println("Música selecionada: " + musicaAtual);
    }

    @Override
    public void ligarLigacao(String numero) {
        this.numeroLigacao = numero;
        System.out.println("Ligando para: " + numeroLigacao);
    }

    @Override
    public void atenderLigacao() {
        System.out.println("Atendendo a ligação");
    }

    @Override
    public void iniciarCorreioVoz() {
        System.out.println("Iniciando o correio de voz");
        System.out.println("Alô, tudo bem? Sou um recrutador de uma multinacional...");
    }

    @Override
    public void desligarCorreioVoz() {
        System.out.println("Desligando o correio de voz");
    }

    @Override
    public void exibirPagina(String url) {
        this.urlPagina = url;
        System.out.println("Exibindo a página: " + urlPagina);
    }

    @Override
    public void adicionarNovaAba() {
        System.out.println("Adicionando uma nova aba no navegador");
    }

    @Override
    public void atualizarPagina() {
        if (urlPagina != null) {
            System.out.println("Atualizando a página: " + urlPagina);
        } else {
            System.out.println("Nenhuma página para atualizar.");
        }
    }
}

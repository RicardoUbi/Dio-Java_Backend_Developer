public class iPhoneDriver {
    public static void main(String[] args) {
        iPhone meuIphone = new iPhone();

        // TESTES
        // ReprodutorMusical
        meuIphone.selecionarMusica("Until I Found You - Stephen Sanchez");
        meuIphone.tocarMusica();
        meuIphone.pausarMusica();

        // AparelhoTelefonico
        meuIphone.ligarLigacao("123456789089");
        meuIphone.atenderLigacao();
        meuIphone.iniciarCorreioVoz();
        meuIphone.desligarCorreioVoz();

        // NavegadorInternet
        meuIphone.exibirPagina("https://www.google.com.br/");
        meuIphone.adicionarNovaAba();
        meuIphone.atualizarPagina();
    }
}

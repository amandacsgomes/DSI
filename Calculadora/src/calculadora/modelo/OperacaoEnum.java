/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora.modelo;

/**
 *
 * @author r7d8
 */
public enum OperacaoEnum {

    SOMA("+"), MULTIPLICACAO("*"),
    SUBTRACAO("-"), DIVISAO("/");
    private final String valorOperacao;

    private OperacaoEnum(String valorOperacao) {
        this.valorOperacao = valorOperacao;
    }

    public String getValor() {
        return valorOperacao;
    }
}

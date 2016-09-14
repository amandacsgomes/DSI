/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Amanda
 */
public class Calculadora {

    private static Calculadora uniqueInstance;
    private List<Object> listaMemo = new ArrayList();

    private Calculadora() {
    }

    public static synchronized Calculadora getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Calculadora();
        }

        return uniqueInstance;
    }

    public void addMemoria(Object adicional) {
        this.listaMemo.add(adicional);
    }

    public void limparMemoria() {
        this.listaMemo.clear();
    }

    public int tamanhoMemo() {
        return this.listaMemo.size();
    }

    public String getStrListaMemo() {
        String strMem = "";
        for (int i = 0; i < this.listaMemo.size(); i++) {
            if (this.listaMemo.get(i) instanceof OperacaoEnum) {
                strMem = strMem.concat(((OperacaoEnum) this.listaMemo.get(i)).getValor());
            } else {
                strMem = strMem.concat(this.listaMemo.get(i).toString());
            }
        }
        return strMem;
    }

    public Float calcular() throws Exception {
        Float acumulador = Float.parseFloat((String) this.listaMemo.get(0));
        OperacaoEnum oper;
        for (int i = 1; i < this.listaMemo.size(); i++) {
            if (this.listaMemo.get(i) instanceof OperacaoEnum) {
                oper = (OperacaoEnum) this.listaMemo.get(i);
                acumulador = tratarOperacao(oper, acumulador, Float.parseFloat((String) this.listaMemo.get(i + 1)));
            }
        }
        return acumulador;
    }

    private Float tratarOperacao(OperacaoEnum operacao, Float num1, Float num2) throws Exception {
        if (operacao == OperacaoEnum.SOMA) {
            return num1 + num2;
        } else if (operacao == OperacaoEnum.SUBTRACAO) {
            return num1 - num2;
        } else if (operacao == OperacaoEnum.DIVISAO) {//******************falta tratar a divisão por 0
            if (num2 == 0) {
                throw new Exception("Não é possível dividir por 0.");
            }
            return num1 / num2;
        } else if (operacao == OperacaoEnum.MULTIPLICACAO) {
            return num1 * num2;
        }
        return 0f;
    }
}

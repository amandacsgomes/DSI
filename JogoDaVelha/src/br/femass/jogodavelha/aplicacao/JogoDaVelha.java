/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.femass.jogodavelha.aplicacao;

import javax.swing.JOptionPane;

/**
 *
 * @author Amanda
 */
public class JogoDaVelha {

    public int[][] tabuleiro = new int[3][3];

    public JogoDaVelha() {
    }

    public void iniciarPartida() {
        this.zerarTabuleiro();
    }

    public int proximaJogada(int linha, int coluna, int jogador) {
        this.tabuleiro[linha][coluna] = jogador;

        return this.analisarJogada();
    }

    public void encerrarJogo() {
        this.zerarTabuleiro();
    }

    private void zerarTabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.tabuleiro[i][j] = 0;
            }
        }
    }

    /*
     retorna 0 para jogo em andamento
     1 para jogador 1 vencedor
     2 para jogador 2 vencedor
     3 para empate
     */
    private int analisarJogada() {
        for (int i = 0; i < 3; i++) {
            if (this.tabuleiro[i][0] == this.tabuleiro[i][1]
                    && this.tabuleiro[i][1] == this.tabuleiro[i][2]) {
                if (this.tabuleiro[i][0] == 1) {
                    return 1;
                }if (this.tabuleiro[i][0] == 2) {
                    return 2;
                }
            }
            if (this.tabuleiro[0][i] == this.tabuleiro[1][i]
                    && this.tabuleiro[1][i] == this.tabuleiro[2][i]) {
                if (this.tabuleiro[0][i] == 1) {
                    return 1;
                } if (this.tabuleiro[0][i] == 2) {
                    return 2;
                }
            }
        }
        if (this.tabuleiro[0][0] == this.tabuleiro[1][1]
                && this.tabuleiro[1][1] == this.tabuleiro[2][2]) {
            if (this.tabuleiro[1][1] == 1) {
                return 1;
            } if (this.tabuleiro[1][1] == 2) {
                return 2;
            }
        }
        if (this.tabuleiro[0][2] == this.tabuleiro[1][1]
                && this.tabuleiro[1][1] == this.tabuleiro[2][0]) {
            if (this.tabuleiro[1][1] == 1) {
                return 1;
            } if (this.tabuleiro[1][1] == 2) {
                return 2;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.tabuleiro[i][j] == 0) {
                    return 0;
                }
            }
        }
        return 3;
    }
}

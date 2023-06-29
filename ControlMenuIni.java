package Projeto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.List;

public class ControlMenuIni{

    public ControlMenuIni(){

    }
    public class TempoExecException extends RuntimeException {
        public TempoExecException(String mensagem) {
            JOptionPane.showMessageDialog(null, mensagem);
        }
    }

    public String tempExec(LocalTime horaInicio) throws TempoExecException {
        LocalTime horaAtual = LocalTime.now();
        int tempo1 = horaInicio.toSecondOfDay();
        int tempo2 = horaAtual.toSecondOfDay();

        if (tempo1 > tempo2) {
            throw new TempoExecException("O tempo de início é posterior ao tempo atual.");
        }

        int segundosTotais = tempo2 - tempo1;

        int horas = segundosTotais / 3600;
        int minutos = (segundosTotais % 3600) / 60;
        int segundos = segundosTotais % 60;

        return String.format("%02d:%02d:%02d", horas, minutos, segundos);
    }
    public List<String> registroAcesso(){
        return ControlMenuSec.registro;
    }
    public boolean mudarCor(boolean escuro){
        return escuro;
    }
    public boolean mudarIdioma(boolean ingles){
        return ingles;
    }
    public void encerrarPrograma() {
        System.exit(0);
    }
    public static class MeuListener implements ActionListener{
        private final String grupo;
        public MeuListener(String nomeGrupo){
            this.grupo = nomeGrupo;
        }
        public void actionPerformed(ActionEvent e){
            ViewMenuIni.frameMenu.setEnabled(false);
            ViewMenuSec janela = ViewMenuSec.iniciar(grupo);
            janela.addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e){
                    ViewMenuSec.fechar();
                }
            });
        }
    }
}

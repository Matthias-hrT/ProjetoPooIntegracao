package Projeto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ViewMenuSec extends JFrame {
    private final String grupo;

    public static ViewMenuSec janela = null;
    private final ControlMenuSec controlMenu = new ControlMenuSec();
    private final JFrame frameJanela = new JFrame();
    private List<String> listas = new ArrayList<>();

    public static ViewMenuSec iniciar(String nomeGrupo) {
        if (janela == null)
            janela = new ViewMenuSec(nomeGrupo);
        return janela;
    }

    public static void fechar() {
        janela = null;
    }

    private ViewMenuSec(String nomeGrupo) {
        this.grupo = nomeGrupo;

        frameJanela.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frameJanela.setSize(240, 410);
        frameJanela.setResizable(false);
        frameJanela.setTitle("Menu Principal");
        frameJanela.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        Dimension tamanhoBotoes = new Dimension(210, 50);

        JButton autores = new JButton("Autores");
        autores.setPreferredSize(tamanhoBotoes);
        JButton descricao = new JButton("Descrição");
        descricao.setPreferredSize(tamanhoBotoes);
        JButton classes = new JButton("Classes");
        classes.setPreferredSize(tamanhoBotoes);
        JButton horaSistema = new JButton("Hora do Sistema");
        horaSistema.setPreferredSize(tamanhoBotoes);
        JButton iniciar = new JButton("Iniciar");
        iniciar.setPreferredSize(tamanhoBotoes);
        JButton voltar = new JButton("Voltar");
        voltar.setPreferredSize(tamanhoBotoes);

        if(ViewMenuIni.escuro){
            frameJanela.getContentPane().setBackground(new Color(40, 40, 40));
            Color novaCor = new Color(150, 150, 150);

            JButton[] botoes = {autores, descricao, classes, horaSistema, iniciar,
                    voltar};

            for (JButton botao : botoes) {
                botao.setBackground(novaCor);
            }
        }else {
            frameJanela.getContentPane().setBackground(new Color(230, 230, 230));
            Color novaCor = new Color(211, 211, 211);

            JButton[] botoes = {autores, descricao, classes, horaSistema, iniciar,
                    voltar};

            for(JButton botao : botoes) {
                botao.setBackground(novaCor);
            }
        }

        if(ViewMenuIni.ingles){
            autores.setText("Authors");
            descricao.setText("Description");
            horaSistema.setText("System Time");
            iniciar.setText("Start");
            voltar.setText("Back");
        }else{
            autores.setText("Autores");
            descricao.setText("Descrição");
            horaSistema.setText("Hora do Sistema");
            iniciar.setText("Iniciar");
            voltar.setText("Voltar");
        }

        autores.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    listas = controlMenu.getNomeIntegrantes(grupo);
                    String integrantes = String.join("\n", listas);
                    JOptionPane.showMessageDialog(ViewMenuSec.this, integrantes, "Integrantes", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(ViewMenuSec.this, "Ocorreu um Erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        descricao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    controlMenu.descricaoProjeto(grupo);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(ViewMenuSec.this, "Ocorreu um Erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        horaSistema.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    controlMenu.getHoraSistema(grupo);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(ViewMenuSec.this, "Ocorreu um Erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        classes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    listas = controlMenu.getClasses(grupo);
                    String classes = String.join("\n", listas);
                    JOptionPane.showMessageDialog(ViewMenuSec.this, classes, "Classes", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(ViewMenuSec.this, "Ocorreu um Erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        iniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    controlMenu.iniciar(grupo);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(ViewMenuSec.this, "Ocorreu um Erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        voltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ViewMenuIni.frameMenu.setEnabled(true);
                ViewMenuSec.fechar();
                frameJanela.dispose();
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;

        frameJanela.add(autores, gbc);

        gbc.gridy = 1;
        frameJanela.add(descricao, gbc);

        gbc.gridy = 2;
        frameJanela.add(classes, gbc);

        gbc.gridy = 3;
        frameJanela.add(horaSistema, gbc);

        gbc.gridy = 4;
        frameJanela.add(iniciar, gbc);

        gbc.gridy = 5;
        frameJanela.add(voltar, gbc);

        Dimension tela  = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle window = frameJanela.getBounds();

        float larguraJanela = window.width;
        float alturaJanela = window.height;

        int posX = (int)((tela.width / 2) - (larguraJanela / 2));
        int posY = (int)((tela.height/2) - (alturaJanela / 2));

        frameJanela.setBounds(posX, posY, (int)larguraJanela, (int)alturaJanela);

        frameJanela.setVisible(true);
    }
}

package Projeto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalTime;
import java.util.List;

public class ViewMenuIni extends ControlMenuIni {
    private final ControlMenuIni controlMenu;
    public static JFrame frameMenu;
    private final LocalTime horaInicio;
    public static boolean escuro;
    public static boolean ingles;
    public ViewMenuIni() {
        this.controlMenu = new ControlMenuIni();
        frameMenu = new JFrame();
        this.horaInicio = LocalTime.now();
        escuro = false;
    }

    public void iniciar() {

        frameMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMenu.setTitle("Menu Inicial");
        frameMenu.getContentPane().setBackground(new Color(230, 230, 230));
        frameMenu.setResizable(false);

        GridBagLayout layout = new GridBagLayout();
        frameMenu.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5); // Espaçamento interno dos componentes

        Dimension tamanhoBotoes = new Dimension(240, 50);

        JButton grupo1Button = new JButton("Bilheteria de Ônibus");
        grupo1Button.setPreferredSize(tamanhoBotoes);
        grupo1Button.setBackground(new Color(211,211,211));
        JButton grupo2Button = new JButton("Manutenção de Vias");
        grupo2Button.setPreferredSize(tamanhoBotoes);
        grupo2Button.setBackground(new Color(211,211,211));
        JButton grupo3Button = new JButton("Sistema de Saneamento");
        grupo3Button.setPreferredSize(tamanhoBotoes);
        grupo3Button.setBackground(new Color(211,211,211));
        JButton grupo4Button = new JButton("Restaurante");
        grupo4Button.setPreferredSize(tamanhoBotoes);
        grupo4Button.setBackground(new Color(211,211,211));
        JButton grupo5Button = new JButton("Portal da Transparência");
        grupo5Button.setPreferredSize(tamanhoBotoes);
        grupo5Button.setBackground(new Color(211,211,211));
        JButton tempButton = new JButton("Tempo de Execução");
        tempButton.setPreferredSize(tamanhoBotoes);
        tempButton.setBackground(new Color(211,211,211));
        JButton registroButton = new JButton("Registro de Acessos");
        registroButton.setPreferredSize(tamanhoBotoes);
        registroButton.setBackground(new Color(211,211,211));
        JButton sairButton = new JButton("Sair");
        sairButton.setPreferredSize(tamanhoBotoes);
        sairButton.setBackground(new Color(211,211,211));
        JButton mudarCor = new JButton("Mudar Cor");
        mudarCor.setPreferredSize(tamanhoBotoes);
        mudarCor.setBackground(new Color(211,211,211));
        JButton mudarIdioma = new JButton("Mudar Idioma");
        mudarIdioma.setPreferredSize(tamanhoBotoes);
        mudarIdioma.setBackground(new Color(211, 211, 211));

        grupo1Button.addActionListener(new MeuListener("Grupo1"));
        grupo2Button.addActionListener(new MeuListener("Grupo2"));
        grupo3Button.addActionListener(new MeuListener("Grupo3"));
        grupo4Button.addActionListener(new MeuListener("Grupo4"));
        grupo5Button.addActionListener(new MeuListener("Grupo5"));

        tempButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(null, controlMenu.tempExec(horaInicio));
            }
        });

        registroButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List<String> registro = controlMenu.registroAcesso();
                StringBuilder registrosNumerados = new StringBuilder();

                for (int i = 0; i < registro.size(); i++) {
                    String registroNumerado = (i + 1) + ". " + registro.get(i);
                    registrosNumerados.append(registroNumerado).append("\n");
                }

                JOptionPane.showMessageDialog(null, registrosNumerados.toString(), "Registros", JOptionPane.INFORMATION_MESSAGE);
                controlMenu.registroAcesso();
            }
        });

        mudarCor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(!mudarCor(escuro)){
                    escuro = true;
                    frameMenu.getContentPane().setBackground(new Color(40, 40, 40));
                    Color novaCor = new Color(150, 150, 150);

                    JButton[] botoes = {grupo1Button, grupo2Button, grupo3Button, grupo4Button, grupo5Button,
                            tempButton, registroButton, mudarCor, mudarIdioma, sairButton};

                    for (JButton botao : botoes) {
                        botao.setBackground(novaCor);
                    }
                } else{
                    escuro = false;
                    frameMenu.getContentPane().setBackground(new Color(230, 230, 230));
                    Color novaCor = new Color(211, 211, 211);

                    JButton[] botoes = {grupo1Button, grupo2Button, grupo3Button, grupo4Button, grupo5Button,
                            tempButton, registroButton, mudarCor, mudarIdioma, sairButton};

                    for (JButton botao : botoes) {
                        botao.setBackground(novaCor);
                    }
                }
            }
        });

        mudarIdioma.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(!mudarIdioma(ingles)){
                    ingles = true;
                    grupo1Button.setText("Bus ticket office");
                    grupo2Button.setText("Road Maintenance");
                    grupo3Button.setText("Sanitation System");
                    grupo4Button.setText("Restaurant");
                    grupo5Button.setText("Transparency Portal");
                    tempButton.setText("Runtime");
                    registroButton.setText("Access Record");
                    mudarCor.setText("Change Colors");
                    mudarIdioma.setText("Change Language");
                    sairButton.setText("Exit");
                } else{
                    ingles = false;
                    grupo1Button.setText("Bilheteria de Ônibus");
                    grupo2Button.setText("Manutenção de Vias");
                    grupo3Button.setText("Sistema de Saneamento");
                    grupo4Button.setText("Restaurante");
                    grupo5Button.setText("Portal da Transparência");
                    tempButton.setText("Tempo de Execução");
                    registroButton.setText("Registro de Acessos");
                    mudarCor.setText("Mudar Cor");
                    mudarIdioma.setText("Mudar Idioma");
                    sairButton.setText("Sair");
                }
            }
        });

        sairButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controlMenu.encerrarPrograma();
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        frameMenu.add(grupo1Button, gbc);

        gbc.gridy = 1;
        frameMenu.add(grupo2Button, gbc);

        gbc.gridy = 2;
        frameMenu.add(grupo3Button, gbc);

        gbc.gridy = 3;
        frameMenu.add(grupo4Button, gbc);

        gbc.gridy = 4;
        frameMenu.add(grupo5Button, gbc);

        gbc.gridy = 5;
        frameMenu.add(tempButton, gbc);

        gbc.gridy = 6;
        frameMenu.add(registroButton, gbc);

        gbc.gridy = 7;
        frameMenu.add(mudarCor, gbc);

        gbc.gridy = 8;
        frameMenu.add(mudarIdioma, gbc);

        gbc.gridy = 9;
        frameMenu.add(sairButton, gbc);

        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle janela = frameMenu.getBounds();

        float larguraJanela = janela.width;
        float alturaJanela = janela.height;

        int posX = (int)((tela.width / 2.32) - (larguraJanela / 2));
        int posY = (int)((tela.height/ 5) - (alturaJanela / 2));

        frameMenu.setBounds(posX, posY, (int)larguraJanela, (int)alturaJanela);

        frameMenu.pack();
        frameMenu.setVisible(true);
    }
}
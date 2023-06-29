package Projeto;

import CodMaeda.MainMaeda;
import CodFelipe.MainFelipe;
import CodPlinio.Principal;
import CodBruno.RestauranteGUI;
import CodVitor.PrincipalVitor;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ControlMenuSec{
    public static List<String> registro = new ArrayList<>();
    public Integracao codGrupo;
    public ControlMenuSec( ){
    }

    public ArrayList<String> getNomeIntegrantes(String grupo) {
        ArrayList<String> integrantes = new ArrayList<>();
        switch(grupo) {
            case "Grupo1" -> {
                codGrupo = new MainMaeda();
                integrantes.addAll(codGrupo.getNomeIntegrantes());
            }
            case "Grupo2" -> {
                codGrupo = new Principal();
                integrantes.addAll(codGrupo.getNomeIntegrantes());
            }
            case "Grupo3" -> {
                codGrupo = new MainFelipe();
                integrantes.addAll(codGrupo.getNomeIntegrantes());
            }
            case "Grupo4" -> {
                codGrupo = new RestauranteGUI();
                integrantes.addAll(codGrupo.getNomeIntegrantes());
            }
            case "Grupo5" -> {
                codGrupo = new PrincipalVitor();
                integrantes.addAll(codGrupo.getNomeIntegrantes());
            }
            default -> {
            }
        }

        return integrantes;
    }
    public void descricaoProjeto(String grupo){
        switch(grupo) {
            case "Grupo1" -> {
                codGrupo = new MainMaeda();
                JOptionPane.showMessageDialog(null, codGrupo.descricaoProjeto());
            }
            case "Grupo2" -> {
                codGrupo = new Principal();
                JOptionPane.showMessageDialog(null, codGrupo.descricaoProjeto());
            }
            case "Grupo3" -> {
                codGrupo = new MainFelipe();
                JOptionPane.showMessageDialog(null, codGrupo.descricaoProjeto());
            }
            case "Grupo4" -> {
                codGrupo = new RestauranteGUI();
                JOptionPane.showMessageDialog(null, codGrupo.descricaoProjeto());
            }
            case "Grupo5" -> {
                codGrupo = new PrincipalVitor();
                JOptionPane.showMessageDialog(null, codGrupo.descricaoProjeto());
            }
            default -> {
            }
        }
    }
    public void getHoraSistema(String grupo){
        switch(grupo) {
            case "Grupo1" -> {
                codGrupo = new MainMaeda();
                JOptionPane.showMessageDialog(null, codGrupo.horaSistema());
            }
            case "Grupo2" -> {
                codGrupo = new Principal();
                JOptionPane.showMessageDialog(null, codGrupo.horaSistema());
            }
            case "Grupo3" -> {
                codGrupo = new MainFelipe();
                JOptionPane.showMessageDialog(null, codGrupo.horaSistema());
            }
            case "Grupo4" -> {
                codGrupo = new RestauranteGUI();
                JOptionPane.showMessageDialog(null, codGrupo.horaSistema());
            }
            case "Grupo5" -> {
                codGrupo = new PrincipalVitor();
                JOptionPane.showMessageDialog(null, codGrupo.horaSistema());
            }
            default -> {
            }
        }
    }
    public ArrayList<String> getClasses(String grupo){
        ArrayList<String> classes = new ArrayList<>();

        switch(grupo) {
            case "Grupo1" -> {
                codGrupo = new MainMaeda();
                classes.addAll(codGrupo.getClasses());
            }
            case "Grupo2" -> {
                codGrupo = new Principal();
                classes.addAll(codGrupo.getClasses());
            }
            case "Grupo3" -> {
                codGrupo = new MainFelipe();
                classes.addAll(codGrupo.getClasses());
            }
            case "Grupo4" -> {
                codGrupo = new RestauranteGUI();
                classes.addAll(codGrupo.getClasses());
            }
            case "Grupo5" -> {
                codGrupo = new PrincipalVitor();
                classes.addAll(codGrupo.getClasses());
            }
            default -> {
            }
        }
        return classes;
    }
    public void iniciar(String grupo){
        switch(grupo) {
            case "Grupo1" -> {
                codGrupo = new MainMaeda();
                codGrupo.iniciar();
                registro.add(grupo);
            }
            case "Grupo2" -> {
                codGrupo = new Principal();
                codGrupo.iniciar();
                registro.add(grupo);
            }
            case "Grupo3" -> {
                codGrupo = new MainFelipe();
                codGrupo.iniciar();
                registro.add(grupo);
            }
            case "Grupo4" -> {
                codGrupo = new RestauranteGUI();
                codGrupo.iniciar();
                registro.add(grupo);
            }
            case "Grupo5" -> {
                codGrupo = new PrincipalVitor();
                codGrupo.iniciar();
                registro.add(grupo);
            }
            default -> {
            }
        }
    }
}



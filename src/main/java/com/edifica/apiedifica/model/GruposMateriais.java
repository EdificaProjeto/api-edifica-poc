package com.edifica.apiedifica.model;
import java.util.List;

public class GruposMateriais {
    private List<Material> grupoA;
    private List<Material> grupoB;
    private List<Material> grupoC;

    public GruposMateriais(List<Material> grupoA, List<Material> grupoB, List<Material> grupoC) {
        this.grupoA = grupoA;
        this.grupoB = grupoB;
        this.grupoC = grupoC;
    }

    public List<Material> getGrupoA() {
        return grupoA;
    }

    public void setGrupoA(List<Material> grupoA) {
        this.grupoA = grupoA;
    }

    public List<Material> getGrupoB() {
        return grupoB;
    }

    public void setGrupoB(List<Material> grupoB) {
        this.grupoB = grupoB;
    }

    public List<Material> getGrupoC() {
        return grupoC;
    }

    public void setGrupoC(List<Material> grupoC) {
        this.grupoC = grupoC;
    }
}
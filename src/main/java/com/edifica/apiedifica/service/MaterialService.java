package com.edifica.apiedifica.service;

import com.edifica.apiedifica.model.GruposMateriais;
import com.edifica.apiedifica.model.Material;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class MaterialService {

    public GruposMateriais classificarMateriais(List<Material> materiais) {
        // Ordenar os materiais pelo valor em ordem decrescente
        materiais.sort(Comparator.comparing(Material::getValor).reversed());

        int quantidadeTotal = 0;
        BigDecimal valorTotal = BigDecimal.ZERO;

        for (Material material : materiais) {
            quantidadeTotal += material.getQuantidade();
            valorTotal = valorTotal.add(material.getValor());
        }

        int quantidadeA = (int) (0.2 * quantidadeTotal);
        int quantidadeB = (int) (0.3 * quantidadeTotal);
        int quantidadeC = quantidadeTotal - quantidadeA - quantidadeB;

        BigDecimal valorA = valorTotal.multiply(new BigDecimal("0.8"));
        BigDecimal valorB = valorTotal.multiply(new BigDecimal("0.15"));
        BigDecimal valorC = valorTotal.multiply(new BigDecimal("0.05"));

        List<Material> grupoA = new ArrayList<>();
        List<Material> grupoB = new ArrayList<>();
        List<Material> grupoC = new ArrayList<>();


        int quantidadeAcumuladaA = 0;
        BigDecimal valorAcumuladoA = BigDecimal.ZERO;

        int quantidadeAcumuladaB = 0;
        BigDecimal valorAcumuladoB = BigDecimal.ZERO;

        int quantidadeAcumuladaC = 0;
        BigDecimal valorAcumuladoC = BigDecimal.ZERO;

        for (Material material : materiais) {
            int quantidadeAtual = material.getQuantidade();
            BigDecimal valorAtual = material.getValor();

            if (valorAcumuladoA.compareTo(valorA) < 0 && quantidadeAtual< quantidadeA) {
                grupoA.add(material);
                quantidadeAcumuladaA += quantidadeAtual;
                valorAcumuladoA = valorAcumuladoA.add(valorAtual);
            } else if (valorAcumuladoB.compareTo(valorB) < 0 && quantidadeAtual < quantidadeB) {
                grupoB.add(material);
                quantidadeAcumuladaB += quantidadeAtual;
                valorAcumuladoB = valorAcumuladoB.add(valorAtual);
            } else {
                grupoC.add(material);
                quantidadeAcumuladaC += quantidadeAtual;
                valorAcumuladoC = valorAcumuladoC.add(valorAtual);
            }
        }


        GruposMateriais gruposMateriais = new GruposMateriais(grupoA, grupoB, grupoC);
        return gruposMateriais;
    }
}



package com.feevale.model;

import java.util.ArrayList;
import java.util.List;

public class Totem {

    private List<Atendimento> atendimentos;

    public Totem() {
        this.atendimentos = new ArrayList<>();
    }

    public void registrarAtendimento(Atendimento atendimento) {
        atendimentos.add(atendimento);
    }

    public List<Atendimento> getAtendimentos() {
        return atendimentos;
    }
}

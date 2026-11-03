package com.example.crud.controller;

import com.example.crud.model.Computador;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/computadores")
public class ComputadorController {

    private final List<Computador> computadores = new ArrayList<>();
    private int proximoId = 1;

    @GetMapping
    public String listarComputadores(Model model) {
        model.addAttribute("computadores", computadores);
        return "computadores/lista";
    }

    @GetMapping("/novo")
    public String exibirFormularioNovo(Model model) {
        model.addAttribute("computador", new Computador());
        return "computadores/form";
    }

    @PostMapping("/salvar")
    public String salvarComputador(@ModelAttribute Computador computador) {
        if (computador.getId() == null) {
            computador.setId(proximoId++);
            computadores.add(computador);
        } else {
            for (int i = 0; i < computadores.size(); i++) {
                if (computadores.get(i).getId().equals(computador.getId())) {
                    computadores.set(i, computador);
                    break;
                }
            }
        }
        return "redirect:/computadores";
    }

    @GetMapping("/editar/{id}")
    public String exibirFormularioEdicao(@PathVariable Integer id, Model model) {
        Computador computadorEncontrado = computadores.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (computadorEncontrado != null) {
            model.addAttribute("computador", computadorEncontrado);
            return "computadores/form";
        }
        return "redirect:/computadores";
    }

    @GetMapping("/deletar/{id}")
    public String deletarComputador(@PathVariable Integer id) {
        computadores.removeIf(c -> c.getId().equals(id));
        return "redirect:/computadores";
    }
}

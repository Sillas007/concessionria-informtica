package com.example.crud.controller;

import com.example.crud.model.Carro;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/carros")
public class CarroController {

    private final List<Carro> carros = new ArrayList<>();
    private int proximoId = 1;

    @GetMapping
    public String listarCarros(Model model) {
        model.addAttribute("carros", carros);
        return "carros/lista";
    }

    @GetMapping("/novo")
    public String exibirFormularioNovo(Model model) {
        model.addAttribute("carro", new Carro());
        return "carros/form";
    }

    @PostMapping("/salvar")
    public String salvarCarro(@ModelAttribute Carro carro) {
        if (carro.getId() == null) {
            carro.setId(proximoId++);
            carros.add(carro);
        } else {
            for (int i = 0; i < carros.size(); i++) {
                if (carros.get(i).getId().equals(carro.getId())) {
                    carros.set(i, carro);
                    break;
                }
            }
        }
        return "redirect:/carros";
    }

    @GetMapping("/editar/{id}")
    public String exibirFormularioEdicao(@PathVariable Integer id, Model model) {
        Carro carroEncontrado = carros.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (carroEncontrado != null) {
            model.addAttribute("carro", carroEncontrado);
            return "carros/form";
        }
        return "redirect:/carros";
    }

    @GetMapping("/deletar/{id}")
    public String deletarCarro(@PathVariable Integer id) {
        carros.removeIf(c -> c.getId().equals(id));
        return "redirect:/carros";
    }
}

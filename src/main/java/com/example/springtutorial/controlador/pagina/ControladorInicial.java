package com.example.springtutorial.controlador.pagina;

import com.example.springtutorial.modelo.Avaliacao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/inicial")
public class ControladorInicial {

    @GetMapping
    public String inicial(Model model) {
        model.addAttribute("mensagem", "Avaliações");

        Avaliacao avaliacao = new Avaliacao(5, "Muito bom");
        model.addAttribute("avaliacao", avaliacao);

        List<Avaliacao> avaliacoes = Arrays.asList(
                new Avaliacao(4, "Bom"),
                new Avaliacao(5, "Ótimo"));

        model.addAttribute("avaliacoes", avaliacoes);

        return "inicial";
    }
}

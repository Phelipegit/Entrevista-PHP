package Entrevista_JAVA.demo.controller;

import Entrevista_JAVA.demo.model.AddPatrimonioRequest;
import Entrevista_JAVA.demo.model.AdicionarEmprestimoRequest;
import Entrevista_JAVA.demo.model.BaixaRequest;
import Entrevista_JAVA.demo.model.CadastrarEstabelecimentoRequest;
import Entrevista_JAVA.demo.service.serviceEmprestimo.CriarEmprestimo;
import Entrevista_JAVA.demo.service.serviceEstabelecimento.CadastrarEstabelecimento;
import Entrevista_JAVA.demo.service.servicePatrimonio.AdicionarPatrimonio;
import Entrevista_JAVA.demo.service.servicePatrimonio.DarBaixaPatrimonio;
import Entrevista_JAVA.demo.service.servicePatrimonio.RetirarBaixaPatrimonio;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

//GERENCIAMENTO DAS ROTAS
@RestController
@RequestMapping("/entrevista")
public class GlobalController {

    private final CadastrarEstabelecimento cadastrarEstabelecimento;
    private final AdicionarPatrimonio adicionarPatrimonio;
    private final CriarEmprestimo criarEmprestimo;
    private final DarBaixaPatrimonio darBaixaPatrimonio;
    private final RetirarBaixaPatrimonio retirarBaixaPatrimonio;

    public GlobalController(CadastrarEstabelecimento cadastrarEstabelecimento,AdicionarPatrimonio adicionarPatrimonio,CriarEmprestimo criarEmprestimo,DarBaixaPatrimonio darBaixaPatrimonio,RetirarBaixaPatrimonio retirarBaixaPatrimonio) {
        this.cadastrarEstabelecimento = cadastrarEstabelecimento;
        this.adicionarPatrimonio = adicionarPatrimonio;
        this.criarEmprestimo = criarEmprestimo;
        this.darBaixaPatrimonio = darBaixaPatrimonio;
        this.retirarBaixaPatrimonio = retirarBaixaPatrimonio;
    }

    @PostMapping("/cadastrarEstabelecimento")
    public void cadastrarEstabelecimento(@RequestBody CadastrarEstabelecimentoRequest cadastroRequest) {
        cadastrarEstabelecimento.cadastrarEstabelecimento(cadastroRequest);
    }

    @PostMapping("/addPatrimonio")
    public void addPatrimonio(@RequestBody AddPatrimonioRequest addRequest) {
        adicionarPatrimonio.addPatrimonio(addRequest);
    }

    @PostMapping("/criarEmprestimo")
    public void criarEmprestimo(@RequestBody AdicionarEmprestimoRequest emprestimoRequest) {
        criarEmprestimo.criarEmprestimo(emprestimoRequest);
    }

    @GetMapping("/listarEstabelecimentos")
    public void listarEstabelecimentos() {

    }


    @PutMapping("/darBaixa")
    public void darBaixaPatrimonio(@RequestBody BaixaRequest baixaRequest) {
        darBaixaPatrimonio.darBaixaPatrimonio(baixaRequest);
    }

    @PutMapping("/retirarBaixa/{id}")
    public void retirarBaixaPatrimonio(@PathVariable UUID id) {
        retirarBaixaPatrimonio.retirarBaixaPatrimonio(id);
    }
}

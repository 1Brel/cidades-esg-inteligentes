package br.com.fiap.esg.controller;

import br.com.fiap.esg.dto.ReducaoCarbonoCadastroDTO;
import br.com.fiap.esg.dto.ReducaoCarbonoExibicaoDTO;
import br.com.fiap.esg.service.ReducaoCarbonoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReducaoCarbonoController {

    @Autowired
    private ReducaoCarbonoService reducaoCarbonoService;

    @PostMapping("/reducao-carbono")
    @ResponseStatus(HttpStatus.CREATED)
    public ReducaoCarbonoExibicaoDTO salvar(@Valid @RequestBody ReducaoCarbonoCadastroDTO reducaoCarbono) {
        return reducaoCarbonoService.salvar(reducaoCarbono);
    }

    @GetMapping("/reducao-carbono/{reducaoCarbonoId}")
    public ResponseEntity<ReducaoCarbonoExibicaoDTO> buscarPorId(@PathVariable Long reducaoCarbonoId){
        try {
            return ResponseEntity.ok(reducaoCarbonoService.buscarPorId(reducaoCarbonoId));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/reducao-carbono")
    @ResponseStatus(HttpStatus.OK)
    public List<ReducaoCarbonoExibicaoDTO> litarTodos(){
        return reducaoCarbonoService.listarTodos();
    }

    @DeleteMapping("/reducao-carbono/{reducaoCarbonoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long reducaoCarbonoId) {
        reducaoCarbonoService.excluir(reducaoCarbonoId);
    }

    @PutMapping("/reducao-carbono")
    public ResponseEntity<ReducaoCarbonoExibicaoDTO> atualizar(
            @RequestBody ReducaoCarbonoExibicaoDTO reducaoCarbonoDTO){
        try {
            ReducaoCarbonoExibicaoDTO reducaoCarbonoExibicaoDTO =
                    reducaoCarbonoService.atualizar(reducaoCarbonoDTO);
            return ResponseEntity.ok(reducaoCarbonoExibicaoDTO);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}

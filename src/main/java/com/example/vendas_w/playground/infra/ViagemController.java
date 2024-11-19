package com.example.vendas_w.playground.infra;

import com.example.vendas_w.playground.services.services.ViagemComumUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;


@RestController
@RequestMapping("/viagem")
@Slf4j
@AllArgsConstructor
public class ViagemController {

    private  final ViagemComumUseCase viagemComumUseCase;

    @PostMapping("/confirm")
    public ResponseEntity<Boolean> viagemOkWithParameters (@RequestParam(required = false) LocalDateTime dataDeinicioDaViagem,
                                                           @RequestParam(required = false)  LocalDateTime dataFimDaViagem,
                                                           @RequestParam(defaultValue = "false")  boolean casaReservada,
                                                           @RequestParam(defaultValue = "false")  boolean passagemComprada){
        try{
            Boolean confirmation =  viagemComumUseCase.execute(dataDeinicioDaViagem, dataFimDaViagem, casaReservada, passagemComprada);
            return ResponseEntity.ok(confirmation);
        } catch (Exception e){
            log.info("Algo deu errado na mensagem");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }
}

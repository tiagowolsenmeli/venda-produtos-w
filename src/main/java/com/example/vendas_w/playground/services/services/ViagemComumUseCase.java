package com.example.vendas_w.playground.services.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@AllArgsConstructor
public class ViagemComumUseCase {

    public boolean execute (LocalDateTime dataDeinicioDaViagem, LocalDateTime dataFimDaViagem,
                             boolean casaReservada,boolean passagemComprada){
        return true;
    }
}

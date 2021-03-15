package com.blibli.kafkaredis.kelompok1.command;

import reactor.core.publisher.Mono;

public interface Command<REQUEST, RESPONSE> {
    Mono<RESPONSE> execute(REQUEST request);
}

package com.blibli.kafkaredis.kelompok1.commandExecutor;

import com.blibli.kafkaredis.kelompok1.command.AddRedisKeyValue.AddRedisKeyValueCommand;
import com.blibli.kafkaredis.kelompok1.command.Command;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CommandExecutor {
    <REQUEST, RESPONSE> Mono<RESPONSE> execute(Class<? extends Command<REQUEST, RESPONSE>> command, REQUEST request);
}

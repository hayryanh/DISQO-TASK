package com.data.agent.common.util;

import lombok.NonNull;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;
import java.util.function.Supplier;

public final class MonoUtils {
    private MonoUtils() {
        throw new UnsupportedOperationException();
    }

    public static <T> Mono<T> onErrorFallback(@NonNull final Class<?> where, @NonNull final Throwable throwable,
                                              final @NonNull Supplier<T> fallback) {
        return doErrorFallback(where, throwable, fallback);
    }

    public static <T, C extends Throwable> Mono<T> onErrorFallback(@NonNull final Class<?> where,
                                                                    @NonNull final C throwable,
                                                                    @NonNull final Consumer<C> before,
                                                                    final Supplier<T> fallback) {
        before.accept(throwable);
        return doErrorFallback(where, throwable, fallback);
    }

    private static <T> Mono<T> doErrorFallback(final Class<?> where, final Throwable throwable,
                                               final Supplier<T> fallback) {
        LoggerFactory.getLogger(where)
                .warn(throwable.getMessage(), throwable);

        return Mono.just(fallback.get());
    }
}

package ConstructorRefernces;

@FunctionalInterface
interface TriFunction<S, U, V, R> {
	R apply(S s, U u, V v);
}
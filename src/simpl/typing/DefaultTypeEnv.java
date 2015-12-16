package simpl.typing;

import simpl.parser.Symbol;

public class DefaultTypeEnv extends TypeEnv {

    private TypeEnv E;

    public DefaultTypeEnv() {
        // TODO
        TypeVar tv1 = new TypeVar(false);
        TypeVar tv2 = new TypeVar(false);
        E = TypeEnv.of(
                TypeEnv.of(
                        TypeEnv.of(
                                TypeEnv.of(TypeEnv.empty,
                                        Symbol.symbol("fst"), new ArrowType(new PairType(tv1, tv2), tv1)),
                                Symbol.symbol("snd"), new ArrowType(new PairType(tv1, tv2), tv2)),
                        Symbol.symbol("hd"), new ArrowType(new ListType(tv1), tv1)),
                Symbol.symbol("tl"), new ArrowType(new ListType(tv1), new ListType(tv1))
        );
    }

    @Override
    public Type get(Symbol x) {
        return E.get(x);
    }
}

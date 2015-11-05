package perf {
  import org.openjdk.jmh.annotations.{State, Scope, Benchmark}

  @State(Scope.Benchmark) class ByteBenchmark {
    type Num = Byte;
    def toNum(i: Int): Num = i.toByte;
    private[this] var x0: Num = toNum(1);
    private[this] var x1: Num = toNum(1);
    private[this] var x2: Num = toNum(1);
    private[this] var x3: Num = toNum(1);
    @Benchmark def fastops1 = x2.*(x2.+(x3)).-(x3.+(x0.-(x3).-(x0).+(x3).-(x1).-(x3.*(x2).-(x1.-(x2.+(x2.+(x3.-(x2).-(x3.-(x2.+(x2.*(x2).+(x3))).+(x0))).-(x0).+(x1.-(x3).-(x1.*(x0.+(x1.*(x1).+(x0).*(x2).-(x1).+(x1).+(x1))).-(x0.+(x1))).-(x0)).-(x1).-(x2.-(x1).*(x1)).-(x2)).+(x0)).+(x0)).-(x1).+(x0))).*(x1.+(x0).+(x1)));
    @Benchmark def fastops2 = x1.*(x3).-(x1.-(x1.-(x0.*(x2.+(x3).*(x1))))).+(x0).+(x0).-(x0).-(x3.+(x0.+(x0.+(x0.*(x3))).*(x2.*(x3.*(x0).+(x0)).*(x2)))).*(x1);
    @Benchmark def fastops3 = x2.-(x1.*(x0.-(x0))).+(x3.+(x0).*(x0).-(x2).+(x2.*(x3.-(x0.-(x1.-(x2).+(x3.*(x2.-(x1).-(x0.*(x3.+(x2.-(x3).+(x3).-(x0)))).-(x3)).+(x3)).*(x2)).*(x0.+(x1.+(x3)))).+(x3).*(x2.*(x3))).*(x2.*(x2))));
    @Benchmark def fastops4 = x0.-(x3).*(x3).*(x3.-(x2.-(x0).+(x3).-(x1.+(x1))).+(x3.*(x3.+(x3)).-(x1.-(x3))).*(x1.*(x1.+(x2)))).-(x2.*(x0.+(x2.-(x1)))).+(x2).-(x0.+(x0)).+(x3);
    @Benchmark def allops1 = x1.*(x1.-(x0).*(x1).-(x0.%(x1).+(x1.*(x1)))./(x3).-(x2).+(x2)).-(x0).%(x0.+(x0.-(x1.%(x1.-(x1.+(x1))).+(x0./(x3)./(x0)))));
    @Benchmark def allops2 = x1.+(x0)./(x2./(x2).+(x1.*(x1.*(x0.-(x1.*(x3))).-(x0./(x1)).*(x0)).*(x1).-(x1)).+(x3.%(x3).+(x0)).%(x1).+(x1).*(x1).+(x3.*(x1.-(x1).-(x1)).+(x0./(x1).*(x3.*(x1))))).-(x0);
    @Benchmark def allops3 = x0.%(x1).*(x1.+(x2./(x2.*(x1)).-(x0.%(x1))).-(x0./(x3./(x1)./(x3).+(x0)./(x2)).-(x3.-(x0.*(x2).+(x2.%(x3)).*(x0))./(x3))).+(x2./(x3)).*(x0)).*(x2).+(x3).-(x3.+(x3.*(x3)).*(x2)./(x3));
    @Benchmark def allops4 = x1.-(x3.-(x1)).-(x2).-(x0.+(x0)).%(x3.%(x2).%(x3./(x3.*(x1)))./(x2.-(x2.%(x2.-(x1.+(x2))))).*(x1)./(x3.-(x2.%(x3))).+(x3)./(x3)).-(x2)
  }

  @State(Scope.Benchmark) class UByteBenchmark {
    type Num = UByte;
    def toNum(i: Int): Num = i.toUByte;
    private[this] var x0: Num = toNum(1);
    private[this] var x1: Num = toNum(1);
    private[this] var x2: Num = toNum(1);
    private[this] var x3: Num = toNum(1);
    @Benchmark def fastops1 = x2.*(x2.+(x3)).-(x3.+(x0.-(x3).-(x0).+(x3).-(x1).-(x3.*(x2).-(x1.-(x2.+(x2.+(x3.-(x2).-(x3.-(x2.+(x2.*(x2).+(x3))).+(x0))).-(x0).+(x1.-(x3).-(x1.*(x0.+(x1.*(x1).+(x0).*(x2).-(x1).+(x1).+(x1))).-(x0.+(x1))).-(x0)).-(x1).-(x2.-(x1).*(x1)).-(x2)).+(x0)).+(x0)).-(x1).+(x0))).*(x1.+(x0).+(x1)));
    @Benchmark def fastops2 = x1.*(x3).-(x1.-(x1.-(x0.*(x2.+(x3).*(x1))))).+(x0).+(x0).-(x0).-(x3.+(x0.+(x0.+(x0.*(x3))).*(x2.*(x3.*(x0).+(x0)).*(x2)))).*(x1);
    @Benchmark def fastops3 = x2.-(x1.*(x0.-(x0))).+(x3.+(x0).*(x0).-(x2).+(x2.*(x3.-(x0.-(x1.-(x2).+(x3.*(x2.-(x1).-(x0.*(x3.+(x2.-(x3).+(x3).-(x0)))).-(x3)).+(x3)).*(x2)).*(x0.+(x1.+(x3)))).+(x3).*(x2.*(x3))).*(x2.*(x2))));
    @Benchmark def fastops4 = x0.-(x3).*(x3).*(x3.-(x2.-(x0).+(x3).-(x1.+(x1))).+(x3.*(x3.+(x3)).-(x1.-(x3))).*(x1.*(x1.+(x2)))).-(x2.*(x0.+(x2.-(x1)))).+(x2).-(x0.+(x0)).+(x3);
    @Benchmark def allops1 = x1.*(x1.-(x0).*(x1).-(x0.%(x1).+(x1.*(x1)))./(x3).-(x2).+(x2)).-(x0).%(x0.+(x0.-(x1.%(x1.-(x1.+(x1))).+(x0./(x3)./(x0)))));
    @Benchmark def allops2 = x1.+(x0)./(x2./(x2).+(x1.*(x1.*(x0.-(x1.*(x3))).-(x0./(x1)).*(x0)).*(x1).-(x1)).+(x3.%(x3).+(x0)).%(x1).+(x1).*(x1).+(x3.*(x1.-(x1).-(x1)).+(x0./(x1).*(x3.*(x1))))).-(x0);
    @Benchmark def allops3 = x0.%(x1).*(x1.+(x2./(x2.*(x1)).-(x0.%(x1))).-(x0./(x3./(x1)./(x3).+(x0)./(x2)).-(x3.-(x0.*(x2).+(x2.%(x3)).*(x0))./(x3))).+(x2./(x3)).*(x0)).*(x2).+(x3).-(x3.+(x3.*(x3)).*(x2)./(x3));
    @Benchmark def allops4 = x1.-(x3.-(x1)).-(x2).-(x0.+(x0)).%(x3.%(x2).%(x3./(x3.*(x1)))./(x2.-(x2.%(x2.-(x1.+(x2))))).*(x1)./(x3.-(x2.%(x3))).+(x3)./(x3)).-(x2)
  }

  @State(Scope.Benchmark) class ShortBenchmark {
    type Num = Short;
    def toNum(i: Int): Num = i.toShort;
    private[this] var x0: Num = toNum(1);
    private[this] var x1: Num = toNum(1);
    private[this] var x2: Num = toNum(1);
    private[this] var x3: Num = toNum(1);
    @Benchmark def fastops1 = x2.*(x2.+(x3)).-(x3.+(x0.-(x3).-(x0).+(x3).-(x1).-(x3.*(x2).-(x1.-(x2.+(x2.+(x3.-(x2).-(x3.-(x2.+(x2.*(x2).+(x3))).+(x0))).-(x0).+(x1.-(x3).-(x1.*(x0.+(x1.*(x1).+(x0).*(x2).-(x1).+(x1).+(x1))).-(x0.+(x1))).-(x0)).-(x1).-(x2.-(x1).*(x1)).-(x2)).+(x0)).+(x0)).-(x1).+(x0))).*(x1.+(x0).+(x1)));
    @Benchmark def fastops2 = x1.*(x3).-(x1.-(x1.-(x0.*(x2.+(x3).*(x1))))).+(x0).+(x0).-(x0).-(x3.+(x0.+(x0.+(x0.*(x3))).*(x2.*(x3.*(x0).+(x0)).*(x2)))).*(x1);
    @Benchmark def fastops3 = x2.-(x1.*(x0.-(x0))).+(x3.+(x0).*(x0).-(x2).+(x2.*(x3.-(x0.-(x1.-(x2).+(x3.*(x2.-(x1).-(x0.*(x3.+(x2.-(x3).+(x3).-(x0)))).-(x3)).+(x3)).*(x2)).*(x0.+(x1.+(x3)))).+(x3).*(x2.*(x3))).*(x2.*(x2))));
    @Benchmark def fastops4 = x0.-(x3).*(x3).*(x3.-(x2.-(x0).+(x3).-(x1.+(x1))).+(x3.*(x3.+(x3)).-(x1.-(x3))).*(x1.*(x1.+(x2)))).-(x2.*(x0.+(x2.-(x1)))).+(x2).-(x0.+(x0)).+(x3);
    @Benchmark def allops1 = x1.*(x1.-(x0).*(x1).-(x0.%(x1).+(x1.*(x1)))./(x3).-(x2).+(x2)).-(x0).%(x0.+(x0.-(x1.%(x1.-(x1.+(x1))).+(x0./(x3)./(x0)))));
    @Benchmark def allops2 = x1.+(x0)./(x2./(x2).+(x1.*(x1.*(x0.-(x1.*(x3))).-(x0./(x1)).*(x0)).*(x1).-(x1)).+(x3.%(x3).+(x0)).%(x1).+(x1).*(x1).+(x3.*(x1.-(x1).-(x1)).+(x0./(x1).*(x3.*(x1))))).-(x0);
    @Benchmark def allops3 = x0.%(x1).*(x1.+(x2./(x2.*(x1)).-(x0.%(x1))).-(x0./(x3./(x1)./(x3).+(x0)./(x2)).-(x3.-(x0.*(x2).+(x2.%(x3)).*(x0))./(x3))).+(x2./(x3)).*(x0)).*(x2).+(x3).-(x3.+(x3.*(x3)).*(x2)./(x3));
    @Benchmark def allops4 = x1.-(x3.-(x1)).-(x2).-(x0.+(x0)).%(x3.%(x2).%(x3./(x3.*(x1)))./(x2.-(x2.%(x2.-(x1.+(x2))))).*(x1)./(x3.-(x2.%(x3))).+(x3)./(x3)).-(x2)
  }

  @State(Scope.Benchmark) class UShortBenchmark {
    type Num = UShort;
    def toNum(i: Int): Num = i.toUShort;
    private[this] var x0: Num = toNum(1);
    private[this] var x1: Num = toNum(1);
    private[this] var x2: Num = toNum(1);
    private[this] var x3: Num = toNum(1);
    @Benchmark def fastops1 = x2.*(x2.+(x3)).-(x3.+(x0.-(x3).-(x0).+(x3).-(x1).-(x3.*(x2).-(x1.-(x2.+(x2.+(x3.-(x2).-(x3.-(x2.+(x2.*(x2).+(x3))).+(x0))).-(x0).+(x1.-(x3).-(x1.*(x0.+(x1.*(x1).+(x0).*(x2).-(x1).+(x1).+(x1))).-(x0.+(x1))).-(x0)).-(x1).-(x2.-(x1).*(x1)).-(x2)).+(x0)).+(x0)).-(x1).+(x0))).*(x1.+(x0).+(x1)));
    @Benchmark def fastops2 = x1.*(x3).-(x1.-(x1.-(x0.*(x2.+(x3).*(x1))))).+(x0).+(x0).-(x0).-(x3.+(x0.+(x0.+(x0.*(x3))).*(x2.*(x3.*(x0).+(x0)).*(x2)))).*(x1);
    @Benchmark def fastops3 = x2.-(x1.*(x0.-(x0))).+(x3.+(x0).*(x0).-(x2).+(x2.*(x3.-(x0.-(x1.-(x2).+(x3.*(x2.-(x1).-(x0.*(x3.+(x2.-(x3).+(x3).-(x0)))).-(x3)).+(x3)).*(x2)).*(x0.+(x1.+(x3)))).+(x3).*(x2.*(x3))).*(x2.*(x2))));
    @Benchmark def fastops4 = x0.-(x3).*(x3).*(x3.-(x2.-(x0).+(x3).-(x1.+(x1))).+(x3.*(x3.+(x3)).-(x1.-(x3))).*(x1.*(x1.+(x2)))).-(x2.*(x0.+(x2.-(x1)))).+(x2).-(x0.+(x0)).+(x3);
    @Benchmark def allops1 = x1.*(x1.-(x0).*(x1).-(x0.%(x1).+(x1.*(x1)))./(x3).-(x2).+(x2)).-(x0).%(x0.+(x0.-(x1.%(x1.-(x1.+(x1))).+(x0./(x3)./(x0)))));
    @Benchmark def allops2 = x1.+(x0)./(x2./(x2).+(x1.*(x1.*(x0.-(x1.*(x3))).-(x0./(x1)).*(x0)).*(x1).-(x1)).+(x3.%(x3).+(x0)).%(x1).+(x1).*(x1).+(x3.*(x1.-(x1).-(x1)).+(x0./(x1).*(x3.*(x1))))).-(x0);
    @Benchmark def allops3 = x0.%(x1).*(x1.+(x2./(x2.*(x1)).-(x0.%(x1))).-(x0./(x3./(x1)./(x3).+(x0)./(x2)).-(x3.-(x0.*(x2).+(x2.%(x3)).*(x0))./(x3))).+(x2./(x3)).*(x0)).*(x2).+(x3).-(x3.+(x3.*(x3)).*(x2)./(x3));
    @Benchmark def allops4 = x1.-(x3.-(x1)).-(x2).-(x0.+(x0)).%(x3.%(x2).%(x3./(x3.*(x1)))./(x2.-(x2.%(x2.-(x1.+(x2))))).*(x1)./(x3.-(x2.%(x3))).+(x3)./(x3)).-(x2)
  }

  @State(Scope.Benchmark) class IntBenchmark {
    type Num = Int;
    def toNum(i: Int): Num = i.toInt;
    private[this] var x0: Num = toNum(1);
    private[this] var x1: Num = toNum(1);
    private[this] var x2: Num = toNum(1);
    private[this] var x3: Num = toNum(1);
    @Benchmark def fastops1 = x2.*(x2.+(x3)).-(x3.+(x0.-(x3).-(x0).+(x3).-(x1).-(x3.*(x2).-(x1.-(x2.+(x2.+(x3.-(x2).-(x3.-(x2.+(x2.*(x2).+(x3))).+(x0))).-(x0).+(x1.-(x3).-(x1.*(x0.+(x1.*(x1).+(x0).*(x2).-(x1).+(x1).+(x1))).-(x0.+(x1))).-(x0)).-(x1).-(x2.-(x1).*(x1)).-(x2)).+(x0)).+(x0)).-(x1).+(x0))).*(x1.+(x0).+(x1)));
    @Benchmark def fastops2 = x1.*(x3).-(x1.-(x1.-(x0.*(x2.+(x3).*(x1))))).+(x0).+(x0).-(x0).-(x3.+(x0.+(x0.+(x0.*(x3))).*(x2.*(x3.*(x0).+(x0)).*(x2)))).*(x1);
    @Benchmark def fastops3 = x2.-(x1.*(x0.-(x0))).+(x3.+(x0).*(x0).-(x2).+(x2.*(x3.-(x0.-(x1.-(x2).+(x3.*(x2.-(x1).-(x0.*(x3.+(x2.-(x3).+(x3).-(x0)))).-(x3)).+(x3)).*(x2)).*(x0.+(x1.+(x3)))).+(x3).*(x2.*(x3))).*(x2.*(x2))));
    @Benchmark def fastops4 = x0.-(x3).*(x3).*(x3.-(x2.-(x0).+(x3).-(x1.+(x1))).+(x3.*(x3.+(x3)).-(x1.-(x3))).*(x1.*(x1.+(x2)))).-(x2.*(x0.+(x2.-(x1)))).+(x2).-(x0.+(x0)).+(x3);
    @Benchmark def allops1 = x1.*(x1.-(x0).*(x1).-(x0.%(x1).+(x1.*(x1)))./(x3).-(x2).+(x2)).-(x0).%(x0.+(x0.-(x1.%(x1.-(x1.+(x1))).+(x0./(x3)./(x0)))));
    @Benchmark def allops2 = x1.+(x0)./(x2./(x2).+(x1.*(x1.*(x0.-(x1.*(x3))).-(x0./(x1)).*(x0)).*(x1).-(x1)).+(x3.%(x3).+(x0)).%(x1).+(x1).*(x1).+(x3.*(x1.-(x1).-(x1)).+(x0./(x1).*(x3.*(x1))))).-(x0);
    @Benchmark def allops3 = x0.%(x1).*(x1.+(x2./(x2.*(x1)).-(x0.%(x1))).-(x0./(x3./(x1)./(x3).+(x0)./(x2)).-(x3.-(x0.*(x2).+(x2.%(x3)).*(x0))./(x3))).+(x2./(x3)).*(x0)).*(x2).+(x3).-(x3.+(x3.*(x3)).*(x2)./(x3));
    @Benchmark def allops4 = x1.-(x3.-(x1)).-(x2).-(x0.+(x0)).%(x3.%(x2).%(x3./(x3.*(x1)))./(x2.-(x2.%(x2.-(x1.+(x2))))).*(x1)./(x3.-(x2.%(x3))).+(x3)./(x3)).-(x2)
  }

  @State(Scope.Benchmark) class UIntBenchmark {
    type Num = UInt;
    def toNum(i: Int): Num = i.toUInt;
    private[this] var x0: Num = toNum(1);
    private[this] var x1: Num = toNum(1);
    private[this] var x2: Num = toNum(1);
    private[this] var x3: Num = toNum(1);
    @Benchmark def fastops1 = x2.*(x2.+(x3)).-(x3.+(x0.-(x3).-(x0).+(x3).-(x1).-(x3.*(x2).-(x1.-(x2.+(x2.+(x3.-(x2).-(x3.-(x2.+(x2.*(x2).+(x3))).+(x0))).-(x0).+(x1.-(x3).-(x1.*(x0.+(x1.*(x1).+(x0).*(x2).-(x1).+(x1).+(x1))).-(x0.+(x1))).-(x0)).-(x1).-(x2.-(x1).*(x1)).-(x2)).+(x0)).+(x0)).-(x1).+(x0))).*(x1.+(x0).+(x1)));
    @Benchmark def fastops2 = x1.*(x3).-(x1.-(x1.-(x0.*(x2.+(x3).*(x1))))).+(x0).+(x0).-(x0).-(x3.+(x0.+(x0.+(x0.*(x3))).*(x2.*(x3.*(x0).+(x0)).*(x2)))).*(x1);
    @Benchmark def fastops3 = x2.-(x1.*(x0.-(x0))).+(x3.+(x0).*(x0).-(x2).+(x2.*(x3.-(x0.-(x1.-(x2).+(x3.*(x2.-(x1).-(x0.*(x3.+(x2.-(x3).+(x3).-(x0)))).-(x3)).+(x3)).*(x2)).*(x0.+(x1.+(x3)))).+(x3).*(x2.*(x3))).*(x2.*(x2))));
    @Benchmark def fastops4 = x0.-(x3).*(x3).*(x3.-(x2.-(x0).+(x3).-(x1.+(x1))).+(x3.*(x3.+(x3)).-(x1.-(x3))).*(x1.*(x1.+(x2)))).-(x2.*(x0.+(x2.-(x1)))).+(x2).-(x0.+(x0)).+(x3);
    @Benchmark def allops1 = x1.*(x1.-(x0).*(x1).-(x0.%(x1).+(x1.*(x1)))./(x3).-(x2).+(x2)).-(x0).%(x0.+(x0.-(x1.%(x1.-(x1.+(x1))).+(x0./(x3)./(x0)))));
    @Benchmark def allops2 = x1.+(x0)./(x2./(x2).+(x1.*(x1.*(x0.-(x1.*(x3))).-(x0./(x1)).*(x0)).*(x1).-(x1)).+(x3.%(x3).+(x0)).%(x1).+(x1).*(x1).+(x3.*(x1.-(x1).-(x1)).+(x0./(x1).*(x3.*(x1))))).-(x0);
    @Benchmark def allops3 = x0.%(x1).*(x1.+(x2./(x2.*(x1)).-(x0.%(x1))).-(x0./(x3./(x1)./(x3).+(x0)./(x2)).-(x3.-(x0.*(x2).+(x2.%(x3)).*(x0))./(x3))).+(x2./(x3)).*(x0)).*(x2).+(x3).-(x3.+(x3.*(x3)).*(x2)./(x3));
    @Benchmark def allops4 = x1.-(x3.-(x1)).-(x2).-(x0.+(x0)).%(x3.%(x2).%(x3./(x3.*(x1)))./(x2.-(x2.%(x2.-(x1.+(x2))))).*(x1)./(x3.-(x2.%(x3))).+(x3)./(x3)).-(x2)
  }

  @State(Scope.Benchmark) class LongBenchmark {
    type Num = Long;
    def toNum(i: Int): Num = i.toLong;
    private[this] var x0: Num = toNum(1);
    private[this] var x1: Num = toNum(1);
    private[this] var x2: Num = toNum(1);
    private[this] var x3: Num = toNum(1);
    @Benchmark def fastops1 = x2.*(x2.+(x3)).-(x3.+(x0.-(x3).-(x0).+(x3).-(x1).-(x3.*(x2).-(x1.-(x2.+(x2.+(x3.-(x2).-(x3.-(x2.+(x2.*(x2).+(x3))).+(x0))).-(x0).+(x1.-(x3).-(x1.*(x0.+(x1.*(x1).+(x0).*(x2).-(x1).+(x1).+(x1))).-(x0.+(x1))).-(x0)).-(x1).-(x2.-(x1).*(x1)).-(x2)).+(x0)).+(x0)).-(x1).+(x0))).*(x1.+(x0).+(x1)));
    @Benchmark def fastops2 = x1.*(x3).-(x1.-(x1.-(x0.*(x2.+(x3).*(x1))))).+(x0).+(x0).-(x0).-(x3.+(x0.+(x0.+(x0.*(x3))).*(x2.*(x3.*(x0).+(x0)).*(x2)))).*(x1);
    @Benchmark def fastops3 = x2.-(x1.*(x0.-(x0))).+(x3.+(x0).*(x0).-(x2).+(x2.*(x3.-(x0.-(x1.-(x2).+(x3.*(x2.-(x1).-(x0.*(x3.+(x2.-(x3).+(x3).-(x0)))).-(x3)).+(x3)).*(x2)).*(x0.+(x1.+(x3)))).+(x3).*(x2.*(x3))).*(x2.*(x2))));
    @Benchmark def fastops4 = x0.-(x3).*(x3).*(x3.-(x2.-(x0).+(x3).-(x1.+(x1))).+(x3.*(x3.+(x3)).-(x1.-(x3))).*(x1.*(x1.+(x2)))).-(x2.*(x0.+(x2.-(x1)))).+(x2).-(x0.+(x0)).+(x3);
    @Benchmark def allops1 = x1.*(x1.-(x0).*(x1).-(x0.%(x1).+(x1.*(x1)))./(x3).-(x2).+(x2)).-(x0).%(x0.+(x0.-(x1.%(x1.-(x1.+(x1))).+(x0./(x3)./(x0)))));
    @Benchmark def allops2 = x1.+(x0)./(x2./(x2).+(x1.*(x1.*(x0.-(x1.*(x3))).-(x0./(x1)).*(x0)).*(x1).-(x1)).+(x3.%(x3).+(x0)).%(x1).+(x1).*(x1).+(x3.*(x1.-(x1).-(x1)).+(x0./(x1).*(x3.*(x1))))).-(x0);
    @Benchmark def allops3 = x0.%(x1).*(x1.+(x2./(x2.*(x1)).-(x0.%(x1))).-(x0./(x3./(x1)./(x3).+(x0)./(x2)).-(x3.-(x0.*(x2).+(x2.%(x3)).*(x0))./(x3))).+(x2./(x3)).*(x0)).*(x2).+(x3).-(x3.+(x3.*(x3)).*(x2)./(x3));
    @Benchmark def allops4 = x1.-(x3.-(x1)).-(x2).-(x0.+(x0)).%(x3.%(x2).%(x3./(x3.*(x1)))./(x2.-(x2.%(x2.-(x1.+(x2))))).*(x1)./(x3.-(x2.%(x3))).+(x3)./(x3)).-(x2)
  }

  @State(Scope.Benchmark) class ULongBenchmark {
    type Num = ULong;
    def toNum(i: Int): Num = i.toULong;
    private[this] var x0: Num = toNum(1);
    private[this] var x1: Num = toNum(1);
    private[this] var x2: Num = toNum(1);
    private[this] var x3: Num = toNum(1);
    @Benchmark def fastops1 = x2.*(x2.+(x3)).-(x3.+(x0.-(x3).-(x0).+(x3).-(x1).-(x3.*(x2).-(x1.-(x2.+(x2.+(x3.-(x2).-(x3.-(x2.+(x2.*(x2).+(x3))).+(x0))).-(x0).+(x1.-(x3).-(x1.*(x0.+(x1.*(x1).+(x0).*(x2).-(x1).+(x1).+(x1))).-(x0.+(x1))).-(x0)).-(x1).-(x2.-(x1).*(x1)).-(x2)).+(x0)).+(x0)).-(x1).+(x0))).*(x1.+(x0).+(x1)));
    @Benchmark def fastops2 = x1.*(x3).-(x1.-(x1.-(x0.*(x2.+(x3).*(x1))))).+(x0).+(x0).-(x0).-(x3.+(x0.+(x0.+(x0.*(x3))).*(x2.*(x3.*(x0).+(x0)).*(x2)))).*(x1);
    @Benchmark def fastops3 = x2.-(x1.*(x0.-(x0))).+(x3.+(x0).*(x0).-(x2).+(x2.*(x3.-(x0.-(x1.-(x2).+(x3.*(x2.-(x1).-(x0.*(x3.+(x2.-(x3).+(x3).-(x0)))).-(x3)).+(x3)).*(x2)).*(x0.+(x1.+(x3)))).+(x3).*(x2.*(x3))).*(x2.*(x2))));
    @Benchmark def fastops4 = x0.-(x3).*(x3).*(x3.-(x2.-(x0).+(x3).-(x1.+(x1))).+(x3.*(x3.+(x3)).-(x1.-(x3))).*(x1.*(x1.+(x2)))).-(x2.*(x0.+(x2.-(x1)))).+(x2).-(x0.+(x0)).+(x3);
    @Benchmark def allops1 = x1.*(x1.-(x0).*(x1).-(x0.%(x1).+(x1.*(x1)))./(x3).-(x2).+(x2)).-(x0).%(x0.+(x0.-(x1.%(x1.-(x1.+(x1))).+(x0./(x3)./(x0)))));
    @Benchmark def allops2 = x1.+(x0)./(x2./(x2).+(x1.*(x1.*(x0.-(x1.*(x3))).-(x0./(x1)).*(x0)).*(x1).-(x1)).+(x3.%(x3).+(x0)).%(x1).+(x1).*(x1).+(x3.*(x1.-(x1).-(x1)).+(x0./(x1).*(x3.*(x1))))).-(x0);
    @Benchmark def allops3 = x0.%(x1).*(x1.+(x2./(x2.*(x1)).-(x0.%(x1))).-(x0./(x3./(x1)./(x3).+(x0)./(x2)).-(x3.-(x0.*(x2).+(x2.%(x3)).*(x0))./(x3))).+(x2./(x3)).*(x0)).*(x2).+(x3).-(x3.+(x3.*(x3)).*(x2)./(x3));
    @Benchmark def allops4 = x1.-(x3.-(x1)).-(x2).-(x0.+(x0)).%(x3.%(x2).%(x3./(x3.*(x1)))./(x2.-(x2.%(x2.-(x1.+(x2))))).*(x1)./(x3.-(x2.%(x3))).+(x3)./(x3)).-(x2)
  }
}

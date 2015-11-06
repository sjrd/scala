package perf {
  import org.openjdk.jmh.annotations.{State, Scope, Benchmark}

  @State(Scope.Benchmark) class ByteBenchmark {
    private[this] var x0: Byte = 0.toByte;
    private[this] var x1: Byte = 1.toByte;
    private[this] var x2: Byte = 2.toByte;
    private[this] var x3: Byte = 3.toByte;
    @Benchmark def fastop0 = x3.-(x3.-(x2).toByte.+(x2.+(x0.+(x0.*(x0).toByte).toByte.-(x0.*(x0.+(x1).toByte.+(x3.+(x2.*(x0).toByte).toByte.+(x1.*(x2.+(x3).toByte).toByte).toByte).toByte).toByte).toByte).toByte.-(x3).toByte.-(x2).toByte).toByte).toByte;
    @Benchmark def fastop1 = x0.*(x0.+(x2).toByte.-(x3.*(x1).toByte.-(x3.*(x2).toByte.-(x1.-(x0).toByte.*(x3).toByte).toByte).toByte).toByte).toByte.*(x2).toByte.-(x2.-(x2).toByte.+(x3.-(x2.*(x2).toByte).toByte).toByte).toByte.+(x1.-(x3).toByte.-(x2.-(x2).toByte).toByte).toByte.*(x0.-(x1).toByte).toByte;
    @Benchmark def fastop2 = x3.*(x0).toByte.*(x2.-(x3.-(x1.*(x1).toByte.-(x2).toByte).toByte.+(x0).toByte).toByte).toByte.-(x2.*(x2.+(x3.+(x3.+(x2.-(x3.+(x3.*(x3).toByte).toByte).toByte).toByte).toByte).toByte.-(x1).toByte.*(x0).toByte).toByte).toByte.*(x3).toByte;
    @Benchmark def fastop3 = x0.-(x0.-(x0.-(x3).toByte).toByte.+(x0).toByte.+(x2).toByte.+(x0).toByte).toByte.-(x3).toByte.-(x0.*(x2.-(x2).toByte.*(x1.-(x3.*(x3.+(x2).toByte.*(x0.*(x3).toByte.-(x1).toByte.*(x3).toByte).toByte).toByte).toByte.+(x2.*(x0).toByte).toByte).toByte).toByte.*(x2.+(x0.+(x3).toByte.-(x3.*(x1).toByte).toByte).toByte).toByte).toByte;
    @Benchmark def allop0 = x1.-(x3.*(x2.*(x3).toByte).toByte.+(x3./(x2.*(x2.+(x1).toByte./(x1).toByte).toByte).toByte.*(x3.-(x3).toByte.+(x3).toByte.+(x3.*(x1.*(x0.%(x1).toByte).toByte).toByte.+(x3./(x1).toByte.%(x1.+(x3.+(x2).toByte.*(x2).toByte.+(x3).toByte).toByte).toByte).toByte).toByte).toByte).toByte).toByte;
    @Benchmark def allop1 = x0.+(x3./(x2).toByte.+(x2.+(x1./(x3).toByte).toByte).toByte.*(x2./(x1.*(x1).toByte.%(x2.+(x1).toByte.-(x0.-(x1).toByte).toByte.+(x3.*(x3).toByte.-(x1).toByte).toByte).toByte).toByte.*(x0.%(x1).toByte).toByte).toByte.-(x3).toByte).toByte;
    @Benchmark def allop2 = x3./(x3).toByte.*(x1).toByte.*(x2.*(x1).toByte./(x2).toByte).toByte.%(x2.*(x2).toByte./(x3./(x1.+(x0).toByte.-(x0.%(x2).toByte).toByte.*(x3).toByte).toByte.+(x0).toByte./(x1).toByte).toByte.+(x1).toByte).toByte.*(x1).toByte;
    @Benchmark def allop3 = x0.+(x3.*(x0.+(x3).toByte.*(x2.*(x1.%(x0.+(x3).toByte).toByte.+(x1).toByte.-(x1).toByte).toByte.-(x0.+(x3.-(x3).toByte).toByte).toByte.-(x1.+(x2.+(x0).toByte).toByte.+(x1.*(x1.-(x0.-(x2).toByte.-(x2).toByte.*(x2.%(x1).toByte).toByte).toByte.-(x1.*(x0).toByte).toByte.-(x2).toByte).toByte).toByte).toByte.%(x1).toByte).toByte).toByte.+(x3./(x0.-(x0).toByte.-(x3).toByte).toByte).toByte).toByte.-(x0).toByte
  }

  @State(Scope.Benchmark) class ShortBenchmark {
    private[this] var x0: Short = 0.toShort;
    private[this] var x1: Short = 1.toShort;
    private[this] var x2: Short = 2.toShort;
    private[this] var x3: Short = 3.toShort;
    @Benchmark def fastop0 = x3.-(x3.-(x2).toShort.+(x2.+(x0.+(x0.*(x0).toShort).toShort.-(x0.*(x0.+(x1).toShort.+(x3.+(x2.*(x0).toShort).toShort.+(x1.*(x2.+(x3).toShort).toShort).toShort).toShort).toShort).toShort).toShort.-(x3).toShort.-(x2).toShort).toShort).toShort;
    @Benchmark def fastop1 = x0.*(x0.+(x2).toShort.-(x3.*(x1).toShort.-(x3.*(x2).toShort.-(x1.-(x0).toShort.*(x3).toShort).toShort).toShort).toShort).toShort.*(x2).toShort.-(x2.-(x2).toShort.+(x3.-(x2.*(x2).toShort).toShort).toShort).toShort.+(x1.-(x3).toShort.-(x2.-(x2).toShort).toShort).toShort.*(x0.-(x1).toShort).toShort;
    @Benchmark def fastop2 = x3.*(x0).toShort.*(x2.-(x3.-(x1.*(x1).toShort.-(x2).toShort).toShort.+(x0).toShort).toShort).toShort.-(x2.*(x2.+(x3.+(x3.+(x2.-(x3.+(x3.*(x3).toShort).toShort).toShort).toShort).toShort).toShort.-(x1).toShort.*(x0).toShort).toShort).toShort.*(x3).toShort;
    @Benchmark def fastop3 = x0.-(x0.-(x0.-(x3).toShort).toShort.+(x0).toShort.+(x2).toShort.+(x0).toShort).toShort.-(x3).toShort.-(x0.*(x2.-(x2).toShort.*(x1.-(x3.*(x3.+(x2).toShort.*(x0.*(x3).toShort.-(x1).toShort.*(x3).toShort).toShort).toShort).toShort.+(x2.*(x0).toShort).toShort).toShort).toShort.*(x2.+(x0.+(x3).toShort.-(x3.*(x1).toShort).toShort).toShort).toShort).toShort;
    @Benchmark def allop0 = x1.-(x3.*(x2.*(x3).toShort).toShort.+(x3./(x2.*(x2.+(x1).toShort./(x1).toShort).toShort).toShort.*(x3.-(x3).toShort.+(x3).toShort.+(x3.*(x1.*(x0.%(x1).toShort).toShort).toShort.+(x3./(x1).toShort.%(x1.+(x3.+(x2).toShort.*(x2).toShort.+(x3).toShort).toShort).toShort).toShort).toShort).toShort).toShort).toShort;
    @Benchmark def allop1 = x0.+(x3./(x2).toShort.+(x2.+(x1./(x3).toShort).toShort).toShort.*(x2./(x1.*(x1).toShort.%(x2.+(x1).toShort.-(x0.-(x1).toShort).toShort.+(x3.*(x3).toShort.-(x1).toShort).toShort).toShort).toShort.*(x0.%(x1).toShort).toShort).toShort.-(x3).toShort).toShort;
    @Benchmark def allop2 = x3./(x3).toShort.*(x1).toShort.*(x2.*(x1).toShort./(x2).toShort).toShort.%(x2.*(x2).toShort./(x3./(x1.+(x0).toShort.-(x0.%(x2).toShort).toShort.*(x3).toShort).toShort.+(x0).toShort./(x1).toShort).toShort.+(x1).toShort).toShort.*(x1).toShort;
    @Benchmark def allop3 = x0.+(x3.*(x0.+(x3).toShort.*(x2.*(x1.%(x0.+(x3).toShort).toShort.+(x1).toShort.-(x1).toShort).toShort.-(x0.+(x3.-(x3).toShort).toShort).toShort.-(x1.+(x2.+(x0).toShort).toShort.+(x1.*(x1.-(x0.-(x2).toShort.-(x2).toShort.*(x2.%(x1).toShort).toShort).toShort.-(x1.*(x0).toShort).toShort.-(x2).toShort).toShort).toShort).toShort.%(x1).toShort).toShort).toShort.+(x3./(x0.-(x0).toShort.-(x3).toShort).toShort).toShort).toShort.-(x0).toShort
  }

  @State(Scope.Benchmark) class IntBenchmark {
    private[this] var x0: Int = 0.toInt;
    private[this] var x1: Int = 1.toInt;
    private[this] var x2: Int = 2.toInt;
    private[this] var x3: Int = 3.toInt;
    @Benchmark def fastop0 = x3.-(x3.-(x2).+(x2.+(x0.+(x0.*(x0)).-(x0.*(x0.+(x1).+(x3.+(x2.*(x0)).+(x1.*(x2.+(x3))))))).-(x3).-(x2)));
    @Benchmark def fastop1 = x0.*(x0.+(x2).-(x3.*(x1).-(x3.*(x2).-(x1.-(x0).*(x3))))).*(x2).-(x2.-(x2).+(x3.-(x2.*(x2)))).+(x1.-(x3).-(x2.-(x2))).*(x0.-(x1));
    @Benchmark def fastop2 = x3.*(x0).*(x2.-(x3.-(x1.*(x1).-(x2)).+(x0))).-(x2.*(x2.+(x3.+(x3.+(x2.-(x3.+(x3.*(x3)))))).-(x1).*(x0))).*(x3);
    @Benchmark def fastop3 = x0.-(x0.-(x0.-(x3)).+(x0).+(x2).+(x0)).-(x3).-(x0.*(x2.-(x2).*(x1.-(x3.*(x3.+(x2).*(x0.*(x3).-(x1).*(x3)))).+(x2.*(x0)))).*(x2.+(x0.+(x3).-(x3.*(x1)))));
    @Benchmark def allop0 = x1.-(x3.*(x2.*(x3)).+(x3./(x2.*(x2.+(x1)./(x1))).*(x3.-(x3).+(x3).+(x3.*(x1.*(x0.%(x1))).+(x3./(x1).%(x1.+(x3.+(x2).*(x2).+(x3))))))));
    @Benchmark def allop1 = x0.+(x3./(x2).+(x2.+(x1./(x3))).*(x2./(x1.*(x1).%(x2.+(x1).-(x0.-(x1)).+(x3.*(x3).-(x1)))).*(x0.%(x1))).-(x3));
    @Benchmark def allop2 = x3./(x3).*(x1).*(x2.*(x1)./(x2)).%(x2.*(x2)./(x3./(x1.+(x0).-(x0.%(x2)).*(x3)).+(x0)./(x1)).+(x1)).*(x1);
    @Benchmark def allop3 = x0.+(x3.*(x0.+(x3).*(x2.*(x1.%(x0.+(x3)).+(x1).-(x1)).-(x0.+(x3.-(x3))).-(x1.+(x2.+(x0)).+(x1.*(x1.-(x0.-(x2).-(x2).*(x2.%(x1))).-(x1.*(x0)).-(x2)))).%(x1))).+(x3./(x0.-(x0).-(x3)))).-(x0)
  }

  @State(Scope.Benchmark) class LongBenchmark {
    private[this] var x0: Long = 0.toLong;
    private[this] var x1: Long = 1.toLong;
    private[this] var x2: Long = 2.toLong;
    private[this] var x3: Long = 3.toLong;
    @Benchmark def fastop0 = x3.-(x3.-(x2).+(x2.+(x0.+(x0.*(x0)).-(x0.*(x0.+(x1).+(x3.+(x2.*(x0)).+(x1.*(x2.+(x3))))))).-(x3).-(x2)));
    @Benchmark def fastop1 = x0.*(x0.+(x2).-(x3.*(x1).-(x3.*(x2).-(x1.-(x0).*(x3))))).*(x2).-(x2.-(x2).+(x3.-(x2.*(x2)))).+(x1.-(x3).-(x2.-(x2))).*(x0.-(x1));
    @Benchmark def fastop2 = x3.*(x0).*(x2.-(x3.-(x1.*(x1).-(x2)).+(x0))).-(x2.*(x2.+(x3.+(x3.+(x2.-(x3.+(x3.*(x3)))))).-(x1).*(x0))).*(x3);
    @Benchmark def fastop3 = x0.-(x0.-(x0.-(x3)).+(x0).+(x2).+(x0)).-(x3).-(x0.*(x2.-(x2).*(x1.-(x3.*(x3.+(x2).*(x0.*(x3).-(x1).*(x3)))).+(x2.*(x0)))).*(x2.+(x0.+(x3).-(x3.*(x1)))));
    @Benchmark def allop0 = x1.-(x3.*(x2.*(x3)).+(x3./(x2.*(x2.+(x1)./(x1))).*(x3.-(x3).+(x3).+(x3.*(x1.*(x0.%(x1))).+(x3./(x1).%(x1.+(x3.+(x2).*(x2).+(x3))))))));
    @Benchmark def allop1 = x0.+(x3./(x2).+(x2.+(x1./(x3))).*(x2./(x1.*(x1).%(x2.+(x1).-(x0.-(x1)).+(x3.*(x3).-(x1)))).*(x0.%(x1))).-(x3));
    @Benchmark def allop2 = x3./(x3).*(x1).*(x2.*(x1)./(x2)).%(x2.*(x2)./(x3./(x1.+(x0).-(x0.%(x2)).*(x3)).+(x0)./(x1)).+(x1)).*(x1);
    @Benchmark def allop3 = x0.+(x3.*(x0.+(x3).*(x2.*(x1.%(x0.+(x3)).+(x1).-(x1)).-(x0.+(x3.-(x3))).-(x1.+(x2.+(x0)).+(x1.*(x1.-(x0.-(x2).-(x2).*(x2.%(x1))).-(x1.*(x0)).-(x2)))).%(x1))).+(x3./(x0.-(x0).-(x3)))).-(x0)
  }

  @State(Scope.Benchmark) class UByteBenchmark {
    private[this] var x0: UByte = 0.toUByte;
    private[this] var x1: UByte = 1.toUByte;
    private[this] var x2: UByte = 2.toUByte;
    private[this] var x3: UByte = 3.toUByte;
    @Benchmark def fastop0 = x3.-(x3.-(x2).toUByte.+(x2.+(x0.+(x0.*(x0).toUByte).toUByte.-(x0.*(x0.+(x1).toUByte.+(x3.+(x2.*(x0).toUByte).toUByte.+(x1.*(x2.+(x3).toUByte).toUByte).toUByte).toUByte).toUByte).toUByte).toUByte.-(x3).toUByte.-(x2).toUByte).toUByte).toUByte;
    @Benchmark def fastop1 = x0.*(x0.+(x2).toUByte.-(x3.*(x1).toUByte.-(x3.*(x2).toUByte.-(x1.-(x0).toUByte.*(x3).toUByte).toUByte).toUByte).toUByte).toUByte.*(x2).toUByte.-(x2.-(x2).toUByte.+(x3.-(x2.*(x2).toUByte).toUByte).toUByte).toUByte.+(x1.-(x3).toUByte.-(x2.-(x2).toUByte).toUByte).toUByte.*(x0.-(x1).toUByte).toUByte;
    @Benchmark def fastop2 = x3.*(x0).toUByte.*(x2.-(x3.-(x1.*(x1).toUByte.-(x2).toUByte).toUByte.+(x0).toUByte).toUByte).toUByte.-(x2.*(x2.+(x3.+(x3.+(x2.-(x3.+(x3.*(x3).toUByte).toUByte).toUByte).toUByte).toUByte).toUByte.-(x1).toUByte.*(x0).toUByte).toUByte).toUByte.*(x3).toUByte;
    @Benchmark def fastop3 = x0.-(x0.-(x0.-(x3).toUByte).toUByte.+(x0).toUByte.+(x2).toUByte.+(x0).toUByte).toUByte.-(x3).toUByte.-(x0.*(x2.-(x2).toUByte.*(x1.-(x3.*(x3.+(x2).toUByte.*(x0.*(x3).toUByte.-(x1).toUByte.*(x3).toUByte).toUByte).toUByte).toUByte.+(x2.*(x0).toUByte).toUByte).toUByte).toUByte.*(x2.+(x0.+(x3).toUByte.-(x3.*(x1).toUByte).toUByte).toUByte).toUByte).toUByte;
    @Benchmark def allop0 = x1.-(x3.*(x2.*(x3).toUByte).toUByte.+(x3./(x2.*(x2.+(x1).toUByte./(x1).toUByte).toUByte).toUByte.*(x3.-(x3).toUByte.+(x3).toUByte.+(x3.*(x1.*(x0.%(x1).toUByte).toUByte).toUByte.+(x3./(x1).toUByte.%(x1.+(x3.+(x2).toUByte.*(x2).toUByte.+(x3).toUByte).toUByte).toUByte).toUByte).toUByte).toUByte).toUByte).toUByte;
    @Benchmark def allop1 = x0.+(x3./(x2).toUByte.+(x2.+(x1./(x3).toUByte).toUByte).toUByte.*(x2./(x1.*(x1).toUByte.%(x2.+(x1).toUByte.-(x0.-(x1).toUByte).toUByte.+(x3.*(x3).toUByte.-(x1).toUByte).toUByte).toUByte).toUByte.*(x0.%(x1).toUByte).toUByte).toUByte.-(x3).toUByte).toUByte;
    @Benchmark def allop2 = x3./(x3).toUByte.*(x1).toUByte.*(x2.*(x1).toUByte./(x2).toUByte).toUByte.%(x2.*(x2).toUByte./(x3./(x1.+(x0).toUByte.-(x0.%(x2).toUByte).toUByte.*(x3).toUByte).toUByte.+(x0).toUByte./(x1).toUByte).toUByte.+(x1).toUByte).toUByte.*(x1).toUByte;
    @Benchmark def allop3 = x0.+(x3.*(x0.+(x3).toUByte.*(x2.*(x1.%(x0.+(x3).toUByte).toUByte.+(x1).toUByte.-(x1).toUByte).toUByte.-(x0.+(x3.-(x3).toUByte).toUByte).toUByte.-(x1.+(x2.+(x0).toUByte).toUByte.+(x1.*(x1.-(x0.-(x2).toUByte.-(x2).toUByte.*(x2.%(x1).toUByte).toUByte).toUByte.-(x1.*(x0).toUByte).toUByte.-(x2).toUByte).toUByte).toUByte).toUByte.%(x1).toUByte).toUByte).toUByte.+(x3./(x0.-(x0).toUByte.-(x3).toUByte).toUByte).toUByte).toUByte.-(x0).toUByte
  }

  @State(Scope.Benchmark) class UShortBenchmark {
    private[this] var x0: UShort = 0.toUShort;
    private[this] var x1: UShort = 1.toUShort;
    private[this] var x2: UShort = 2.toUShort;
    private[this] var x3: UShort = 3.toUShort;
    @Benchmark def fastop0 = x3.-(x3.-(x2).toUShort.+(x2.+(x0.+(x0.*(x0).toUShort).toUShort.-(x0.*(x0.+(x1).toUShort.+(x3.+(x2.*(x0).toUShort).toUShort.+(x1.*(x2.+(x3).toUShort).toUShort).toUShort).toUShort).toUShort).toUShort).toUShort.-(x3).toUShort.-(x2).toUShort).toUShort).toUShort;
    @Benchmark def fastop1 = x0.*(x0.+(x2).toUShort.-(x3.*(x1).toUShort.-(x3.*(x2).toUShort.-(x1.-(x0).toUShort.*(x3).toUShort).toUShort).toUShort).toUShort).toUShort.*(x2).toUShort.-(x2.-(x2).toUShort.+(x3.-(x2.*(x2).toUShort).toUShort).toUShort).toUShort.+(x1.-(x3).toUShort.-(x2.-(x2).toUShort).toUShort).toUShort.*(x0.-(x1).toUShort).toUShort;
    @Benchmark def fastop2 = x3.*(x0).toUShort.*(x2.-(x3.-(x1.*(x1).toUShort.-(x2).toUShort).toUShort.+(x0).toUShort).toUShort).toUShort.-(x2.*(x2.+(x3.+(x3.+(x2.-(x3.+(x3.*(x3).toUShort).toUShort).toUShort).toUShort).toUShort).toUShort.-(x1).toUShort.*(x0).toUShort).toUShort).toUShort.*(x3).toUShort;
    @Benchmark def fastop3 = x0.-(x0.-(x0.-(x3).toUShort).toUShort.+(x0).toUShort.+(x2).toUShort.+(x0).toUShort).toUShort.-(x3).toUShort.-(x0.*(x2.-(x2).toUShort.*(x1.-(x3.*(x3.+(x2).toUShort.*(x0.*(x3).toUShort.-(x1).toUShort.*(x3).toUShort).toUShort).toUShort).toUShort.+(x2.*(x0).toUShort).toUShort).toUShort).toUShort.*(x2.+(x0.+(x3).toUShort.-(x3.*(x1).toUShort).toUShort).toUShort).toUShort).toUShort;
    @Benchmark def allop0 = x1.-(x3.*(x2.*(x3).toUShort).toUShort.+(x3./(x2.*(x2.+(x1).toUShort./(x1).toUShort).toUShort).toUShort.*(x3.-(x3).toUShort.+(x3).toUShort.+(x3.*(x1.*(x0.%(x1).toUShort).toUShort).toUShort.+(x3./(x1).toUShort.%(x1.+(x3.+(x2).toUShort.*(x2).toUShort.+(x3).toUShort).toUShort).toUShort).toUShort).toUShort).toUShort).toUShort).toUShort;
    @Benchmark def allop1 = x0.+(x3./(x2).toUShort.+(x2.+(x1./(x3).toUShort).toUShort).toUShort.*(x2./(x1.*(x1).toUShort.%(x2.+(x1).toUShort.-(x0.-(x1).toUShort).toUShort.+(x3.*(x3).toUShort.-(x1).toUShort).toUShort).toUShort).toUShort.*(x0.%(x1).toUShort).toUShort).toUShort.-(x3).toUShort).toUShort;
    @Benchmark def allop2 = x3./(x3).toUShort.*(x1).toUShort.*(x2.*(x1).toUShort./(x2).toUShort).toUShort.%(x2.*(x2).toUShort./(x3./(x1.+(x0).toUShort.-(x0.%(x2).toUShort).toUShort.*(x3).toUShort).toUShort.+(x0).toUShort./(x1).toUShort).toUShort.+(x1).toUShort).toUShort.*(x1).toUShort;
    @Benchmark def allop3 = x0.+(x3.*(x0.+(x3).toUShort.*(x2.*(x1.%(x0.+(x3).toUShort).toUShort.+(x1).toUShort.-(x1).toUShort).toUShort.-(x0.+(x3.-(x3).toUShort).toUShort).toUShort.-(x1.+(x2.+(x0).toUShort).toUShort.+(x1.*(x1.-(x0.-(x2).toUShort.-(x2).toUShort.*(x2.%(x1).toUShort).toUShort).toUShort.-(x1.*(x0).toUShort).toUShort.-(x2).toUShort).toUShort).toUShort).toUShort.%(x1).toUShort).toUShort).toUShort.+(x3./(x0.-(x0).toUShort.-(x3).toUShort).toUShort).toUShort).toUShort.-(x0).toUShort
  }

  @State(Scope.Benchmark) class UIntBenchmark {
    private[this] var x0: UInt = 0.toUInt;
    private[this] var x1: UInt = 1.toUInt;
    private[this] var x2: UInt = 2.toUInt;
    private[this] var x3: UInt = 3.toUInt;
    @Benchmark def fastop0 = x3.-(x3.-(x2).+(x2.+(x0.+(x0.*(x0)).-(x0.*(x0.+(x1).+(x3.+(x2.*(x0)).+(x1.*(x2.+(x3))))))).-(x3).-(x2)));
    @Benchmark def fastop1 = x0.*(x0.+(x2).-(x3.*(x1).-(x3.*(x2).-(x1.-(x0).*(x3))))).*(x2).-(x2.-(x2).+(x3.-(x2.*(x2)))).+(x1.-(x3).-(x2.-(x2))).*(x0.-(x1));
    @Benchmark def fastop2 = x3.*(x0).*(x2.-(x3.-(x1.*(x1).-(x2)).+(x0))).-(x2.*(x2.+(x3.+(x3.+(x2.-(x3.+(x3.*(x3)))))).-(x1).*(x0))).*(x3);
    @Benchmark def fastop3 = x0.-(x0.-(x0.-(x3)).+(x0).+(x2).+(x0)).-(x3).-(x0.*(x2.-(x2).*(x1.-(x3.*(x3.+(x2).*(x0.*(x3).-(x1).*(x3)))).+(x2.*(x0)))).*(x2.+(x0.+(x3).-(x3.*(x1)))));
    @Benchmark def allop0 = x1.-(x3.*(x2.*(x3)).+(x3./(x2.*(x2.+(x1)./(x1))).*(x3.-(x3).+(x3).+(x3.*(x1.*(x0.%(x1))).+(x3./(x1).%(x1.+(x3.+(x2).*(x2).+(x3))))))));
    @Benchmark def allop1 = x0.+(x3./(x2).+(x2.+(x1./(x3))).*(x2./(x1.*(x1).%(x2.+(x1).-(x0.-(x1)).+(x3.*(x3).-(x1)))).*(x0.%(x1))).-(x3));
    @Benchmark def allop2 = x3./(x3).*(x1).*(x2.*(x1)./(x2)).%(x2.*(x2)./(x3./(x1.+(x0).-(x0.%(x2)).*(x3)).+(x0)./(x1)).+(x1)).*(x1);
    @Benchmark def allop3 = x0.+(x3.*(x0.+(x3).*(x2.*(x1.%(x0.+(x3)).+(x1).-(x1)).-(x0.+(x3.-(x3))).-(x1.+(x2.+(x0)).+(x1.*(x1.-(x0.-(x2).-(x2).*(x2.%(x1))).-(x1.*(x0)).-(x2)))).%(x1))).+(x3./(x0.-(x0).-(x3)))).-(x0)
  }

  @State(Scope.Benchmark) class ULongBenchmark {
    private[this] var x0: ULong = 0.toULong;
    private[this] var x1: ULong = 1.toULong;
    private[this] var x2: ULong = 2.toULong;
    private[this] var x3: ULong = 3.toULong;
    @Benchmark def fastop0 = x3.-(x3.-(x2).+(x2.+(x0.+(x0.*(x0)).-(x0.*(x0.+(x1).+(x3.+(x2.*(x0)).+(x1.*(x2.+(x3))))))).-(x3).-(x2)));
    @Benchmark def fastop1 = x0.*(x0.+(x2).-(x3.*(x1).-(x3.*(x2).-(x1.-(x0).*(x3))))).*(x2).-(x2.-(x2).+(x3.-(x2.*(x2)))).+(x1.-(x3).-(x2.-(x2))).*(x0.-(x1));
    @Benchmark def fastop2 = x3.*(x0).*(x2.-(x3.-(x1.*(x1).-(x2)).+(x0))).-(x2.*(x2.+(x3.+(x3.+(x2.-(x3.+(x3.*(x3)))))).-(x1).*(x0))).*(x3);
    @Benchmark def fastop3 = x0.-(x0.-(x0.-(x3)).+(x0).+(x2).+(x0)).-(x3).-(x0.*(x2.-(x2).*(x1.-(x3.*(x3.+(x2).*(x0.*(x3).-(x1).*(x3)))).+(x2.*(x0)))).*(x2.+(x0.+(x3).-(x3.*(x1)))));
    @Benchmark def allop0 = x1.-(x3.*(x2.*(x3)).+(x3./(x2.*(x2.+(x1)./(x1))).*(x3.-(x3).+(x3).+(x3.*(x1.*(x0.%(x1))).+(x3./(x1).%(x1.+(x3.+(x2).*(x2).+(x3))))))));
    @Benchmark def allop1 = x0.+(x3./(x2).+(x2.+(x1./(x3))).*(x2./(x1.*(x1).%(x2.+(x1).-(x0.-(x1)).+(x3.*(x3).-(x1)))).*(x0.%(x1))).-(x3));
    @Benchmark def allop2 = x3./(x3).*(x1).*(x2.*(x1)./(x2)).%(x2.*(x2)./(x3./(x1.+(x0).-(x0.%(x2)).*(x3)).+(x0)./(x1)).+(x1)).*(x1);
    @Benchmark def allop3 = x0.+(x3.*(x0.+(x3).*(x2.*(x1.%(x0.+(x3)).+(x1).-(x1)).-(x0.+(x3.-(x3))).-(x1.+(x2.+(x0)).+(x1.*(x1.-(x0.-(x2).-(x2).*(x2.%(x1))).-(x1.*(x0)).-(x2)))).%(x1))).+(x3./(x0.-(x0).-(x3)))).-(x0)
  }
}

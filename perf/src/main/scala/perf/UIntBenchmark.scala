package perf {
  import org.openjdk.jmh.annotations.{State, Scope, Benchmark}

  @State(Scope.Benchmark) class IntBenchmark {
    type Num = Int;
    def toNum(i: Int): Num = i.toInt;
    private[this] var x0: Num = toNum(1);
    private[this] var x1: Num = toNum(1);
    private[this] var x2: Num = toNum(1);
    private[this] var x3: Num = toNum(1);
    @Benchmark def bench1: Num = x1.+(x3.*(x1./(x1).*(x2)).+(x1.-(x3.-(x2)./(x3).+(x0./(x1).-(x2.*(x2)))))).+(x1).*(x2);
    @Benchmark def bench2: Num = x2.+(x2.+(x0).-(x2)./(x1.*(x1.*(x0))).+(x1.-(x3.*(x1.-(x2.*(x0)))./(x2)).-(x2).*(x0))).*(x1);
    @Benchmark def bench3: Num = x2.-(x1)./(x0.-(x2.*(x1).+(x1)./(x2.-(x3.+(x2))./(x3./(x1).-(x0.-(x0))))).+(x0.-(x3)));
    @Benchmark def bench4: Num = x0.*(x2.-(x3).-(x3).-(x1.*(x3.-(x3)).+(x3./(x2)).+(x0))./(x2).*(x3)).-(x3);
    @Benchmark def bench5: Num = x3./(x3).-(x3)./(x3.+(x3).*(x3).*(x1.-(x1.+(x0)).+(x3)).+(x0)).*(x1);
    @Benchmark def bench6: Num = x1.-(x0).-(x0.+(x2./(x2.+(x1).*(x1)).*(x2).-(x1.*(x0.*(x3))))).*(x3.-(x0).-(x1).+(x0)).+(x2);
    @Benchmark def bench7: Num = x1.+(x1./(x3./(x0./(x1.+(x3./(x3).-(x1).*(x0).*(x0)).-(x1.+(x0.+(x2./(x2)))./(x1)).+(x3./(x0))))./(x3./(x0)))).+(x3)./(x1.-(x0).-(x0.+(x0)));
    @Benchmark def bench8: Num = x1.*(x0.+(x2.*(x1)./(x0).*(x2.*(x0)).-(x2./(x0.*(x2)))).*(x3)).*(x1)./(x2.+(x2).*(x1.+(x0)));
    @Benchmark def bench9: Num = x0.*(x1.+(x3)./(x0./(x1)).+(x2.*(x1).*(x2))).*(x2.+(x2))./(x1.*(x1));
    @Benchmark def bench10: Num = x1.+(x1.+(x0.*(x2.-(x2).*(x2)./(x1).*(x2))))./(x2.*(x2.+(x1.*(x0))));
    @Benchmark def bench11: Num = x3.*(x2./(x3)).*(x2.-(x3./(x3.*(x3.-(x0)).+(x1.+(x0.*(x2.-(x2).*(x0).+(x1.+(x2.*(x1)))).*(x3))).*(x3)).-(x3)).+(x0).*(x2.-(x3.*(x0).-(x0))))./(x0).*(x1.-(x3.-(x1)./(x2))).-(x2.+(x3).-(x2.-(x0).+(x2)./(x3).+(x0).*(x2))).+(x3)./(x2.-(x3).+(x0)./(x2));
    @Benchmark def bench12: Num = x0./(x1).-(x1.-(x0./(x3./(x3.*(x2)).*(x2)))).*(x3).*(x1).-(x0.*(x1./(x0.+(x0.-(x2)))))./(x3./(x1.+(x3.*(x2))./(x1.*(x0).+(x2).-(x0.*(x2.*(x0)./(x3)./(x2))))).-(x0)./(x1).+(x2.-(x3))./(x0./(x1)).-(x2./(x2)).-(x0.+(x1)));
    @Benchmark def bench13: Num = x1./(x1.+(x0.+(x3.+(x0)))).*(x0./(x0.*(x1))).*(x2./(x2.*(x1.-(x2)).+(x2))./(x0.*(x3).*(x0.+(x0).*(x1)).+(x0).*(x1./(x0)).+(x2)).*(x2.+(x1./(x3./(x0)).*(x1))))./(x1);
    @Benchmark def bench14: Num = x3.*(x0).-(x1.*(x2.-(x3).*(x0).*(x1)).+(x0./(x2.+(x3).*(x3.+(x2.*(x3).*(x0./(x3)).-(x2./(x0./(x2)))))).*(x1)));
    @Benchmark def bench15: Num = x2.+(x0).+(x2./(x3).+(x3.+(x0).-(x0).*(x2./(x2.*(x1))).+(x3.+(x0)./(x0))));
    @Benchmark def bench16: Num = x0.*(x0.*(x1.-(x2)).-(x2./(x0./(x3./(x0).*(x1.*(x0).+(x3./(x3)).-(x2)./(x2).+(x0./(x2.+(x2)))).*(x1)))).+(x3)).+(x0).*(x0./(x1)./(x3.-(x0./(x3.-(x0)./(x1).-(x1).-(x1./(x0)./(x0))))).+(x0))
  }

  @State(Scope.Benchmark) class UIntBenchmark {
    type Num = UInt;
    def toNum(i: Int): Num = i.toUInt;
    private[this] var x0: Num = toNum(1);
    private[this] var x1: Num = toNum(1);
    private[this] var x2: Num = toNum(1);
    private[this] var x3: Num = toNum(1);
    @Benchmark def bench1: Num = x1.+(x3.*(x1./(x1).*(x2)).+(x1.-(x3.-(x2)./(x3).+(x0./(x1).-(x2.*(x2)))))).+(x1).*(x2);
    @Benchmark def bench2: Num = x2.+(x2.+(x0).-(x2)./(x1.*(x1.*(x0))).+(x1.-(x3.*(x1.-(x2.*(x0)))./(x2)).-(x2).*(x0))).*(x1);
    @Benchmark def bench3: Num = x2.-(x1)./(x0.-(x2.*(x1).+(x1)./(x2.-(x3.+(x2))./(x3./(x1).-(x0.-(x0))))).+(x0.-(x3)));
    @Benchmark def bench4: Num = x0.*(x2.-(x3).-(x3).-(x1.*(x3.-(x3)).+(x3./(x2)).+(x0))./(x2).*(x3)).-(x3);
    @Benchmark def bench5: Num = x3./(x3).-(x3)./(x3.+(x3).*(x3).*(x1.-(x1.+(x0)).+(x3)).+(x0)).*(x1);
    @Benchmark def bench6: Num = x1.-(x0).-(x0.+(x2./(x2.+(x1).*(x1)).*(x2).-(x1.*(x0.*(x3))))).*(x3.-(x0).-(x1).+(x0)).+(x2);
    @Benchmark def bench7: Num = x1.+(x1./(x3./(x0./(x1.+(x3./(x3).-(x1).*(x0).*(x0)).-(x1.+(x0.+(x2./(x2)))./(x1)).+(x3./(x0))))./(x3./(x0)))).+(x3)./(x1.-(x0).-(x0.+(x0)));
    @Benchmark def bench8: Num = x1.*(x0.+(x2.*(x1)./(x0).*(x2.*(x0)).-(x2./(x0.*(x2)))).*(x3)).*(x1)./(x2.+(x2).*(x1.+(x0)));
    @Benchmark def bench9: Num = x0.*(x1.+(x3)./(x0./(x1)).+(x2.*(x1).*(x2))).*(x2.+(x2))./(x1.*(x1));
    @Benchmark def bench10: Num = x1.+(x1.+(x0.*(x2.-(x2).*(x2)./(x1).*(x2))))./(x2.*(x2.+(x1.*(x0))));
    @Benchmark def bench11: Num = x3.*(x2./(x3)).*(x2.-(x3./(x3.*(x3.-(x0)).+(x1.+(x0.*(x2.-(x2).*(x0).+(x1.+(x2.*(x1)))).*(x3))).*(x3)).-(x3)).+(x0).*(x2.-(x3.*(x0).-(x0))))./(x0).*(x1.-(x3.-(x1)./(x2))).-(x2.+(x3).-(x2.-(x0).+(x2)./(x3).+(x0).*(x2))).+(x3)./(x2.-(x3).+(x0)./(x2));
    @Benchmark def bench12: Num = x0./(x1).-(x1.-(x0./(x3./(x3.*(x2)).*(x2)))).*(x3).*(x1).-(x0.*(x1./(x0.+(x0.-(x2)))))./(x3./(x1.+(x3.*(x2))./(x1.*(x0).+(x2).-(x0.*(x2.*(x0)./(x3)./(x2))))).-(x0)./(x1).+(x2.-(x3))./(x0./(x1)).-(x2./(x2)).-(x0.+(x1)));
    @Benchmark def bench13: Num = x1./(x1.+(x0.+(x3.+(x0)))).*(x0./(x0.*(x1))).*(x2./(x2.*(x1.-(x2)).+(x2))./(x0.*(x3).*(x0.+(x0).*(x1)).+(x0).*(x1./(x0)).+(x2)).*(x2.+(x1./(x3./(x0)).*(x1))))./(x1);
    @Benchmark def bench14: Num = x3.*(x0).-(x1.*(x2.-(x3).*(x0).*(x1)).+(x0./(x2.+(x3).*(x3.+(x2.*(x3).*(x0./(x3)).-(x2./(x0./(x2)))))).*(x1)));
    @Benchmark def bench15: Num = x2.+(x0).+(x2./(x3).+(x3.+(x0).-(x0).*(x2./(x2.*(x1))).+(x3.+(x0)./(x0))));
    @Benchmark def bench16: Num = x0.*(x0.*(x1.-(x2)).-(x2./(x0./(x3./(x0).*(x1.*(x0).+(x3./(x3)).-(x2)./(x2).+(x0./(x2.+(x2)))).*(x1)))).+(x3)).+(x0).*(x0./(x1)./(x3.-(x0./(x3.-(x0)./(x1).-(x1).-(x1./(x0)./(x0))))).+(x0))
  }
}

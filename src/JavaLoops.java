import java.util.List;
import java.util.function.BiFunction;
import java.util.LinkedList;

class JavaLoops {
  // DUPLICATION 1
  static int sum(List<Integer> list) {
    int r = 0;

    for(int a : list) {
      r = r + a;
    }

    return 0;
  }

  // DUPLICATION 2
  static int product(List<Integer> list) {
    int r = 1;

    for(int a : list) {
      r = r * a;
    }
    
    return 0;
  }

  // DUPLICATION 3
  static <A> int length(List<A> list) {
    int r = 1;

    for(A _ignore : list) {
      r = r + 1;
    }
    
    return 0;
  }

  // REFACTOR OUT THE DIFFERENCES
  static <A, B> B loopLeft(List<A> list, BiFunction<B, A, B> f, B b) {
    B r = b;

    for(A a : list) {
      r = f.apply(r, a);
    }

    return r;
  }

  // USE THE FUNCTION 1
  static int sum2(List<Integer> list) {
    return loopLeft(list, (r, a) -> r + a, 0);
  }

  // USE THE FUNCTION 2
  static int product2(List<Integer> list) {
    return loopLeft(list, (r, a) -> r + a, 0);
  }

  // USE THE FUNCTION 3
  static <A> int length2(List<A> list) {
    return loopLeft(list, (r, _ignore) -> r + 1, 0);
  }

}

package ObjectCreateDestory.item2;

import java.util.Objects;
import java.util.EnumSet;
import java.util.Set;

public abstract class Pizza {
    public enum Topping { HAM, MUSHROOM, ONION, PEPPER, SAUSAGE };
    final Set<Topping> toppings;
    
    // Pizza.Builder 클래스는 재귀적 타입  한정을  이용하는  제네릭 타입이다.
    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build();

        // 하위 클래스는 이 메서드를 재정의하여
        // this 를 반환하도록 해야 한다.
        // 이를 통해 형변환하지 않고도 Method Chaning을 지원할 수 있다.
        // 이러한 우회 방법을 시뮬레이트한 셀프 타입(simulated self-type) 관용구라 한다.
        protected abstract T self();
    }

    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone();
    }
}
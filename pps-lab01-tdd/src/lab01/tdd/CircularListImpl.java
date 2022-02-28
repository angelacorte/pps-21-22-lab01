package lab01.tdd;

import java.util.*;

public class CircularListImpl implements CircularList{

    private final List<Integer> list = new ArrayList<>();
    private int index = -1;

    @Override
    public void add(int element) {
        list.add(element);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        index += 1;
        if(index >= size()){
            index = 0;
        }
        return Optional.ofNullable(list.get(index));
    }

    @Override
    public Optional<Integer> previous() {
        index -= 1;
        if(index < 0) {
            index = size()-1;
        }
        return Optional.ofNullable(list.get(index));
    }

    @Override
    public void reset() {
        index = -1;
    }

    @Override
    public Optional<Integer> next(SelectStrategy strategy) {
        if (list.stream().anyMatch(strategy::apply)){
            Optional<Integer> optI = next();
            if (optI.isPresent()){
                while (!strategy.apply(optI.get())){
                    optI = next();
                }
                return optI;
            }
        }
        return Optional.empty();
    }
}

package lab01.tdd;

public class EvenStrategyFactory implements SelectStrategyFactory{
    @Override
    public SelectStrategy createStrategy() {
        return new EvenStrategy();
    }
}

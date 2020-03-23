package listener;

abstract public class ChangeActionNotifier implements ChangeActionNotifierInterface {
    @Override
    abstract public void doAction(String context);
}
package Model.gamefield;


// Абстрактный заполнитель поля
abstract public class Seeder {

    protected GameField _field;

	// тРЕТИЙ КОММЕНТ
    void setField(GameField field) {
        _field = field;
    }

	// second comment
    public void run() {
        seedRobot();
		// второй ком в моей ветке
        seedCharacteristics();
        seedUnits();
    }

    abstract protected void seedRobot();

    abstract protected void seedCharacteristics();

    abstract protected void seedUnits();
}

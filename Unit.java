package Model.ownership;

import Model.gamefield.Cell;
import Model.gamefield.CellPosition;

// Игровой объект
public abstract class Unit {

    // -------------------------- Владелец ----------------------------

    private CanOwnUnit _owner;

	// Установить владельца
    boolean setOwner(CanOwnUnit owner) {
        boolean ok =  canBelongTo(owner);
        if(ok) {
            _owner = owner;
        }
        return ok;
    }

	// Может принадлежать к
    protected boolean canBelongTo(CanOwnUnit owner) {
        return true;
    }

    void removeOwner() {
        _owner = null;
    }

    public CanOwnUnit owner() {
        return (CanOwnUnit)_owner;
    }

    public <T> T typedOwner() {
        return (T)_owner;
    }

	// Принадлежит к
    public boolean belongTo(CanOwnUnit ob) {
        return owner() == ob;
    }

    public boolean belongTo(Class cl) {
        return owner().getClass() == cl;
    }


    // -------------------------- Позиция ----------------------------

    public CellPosition position() {
        if( owner() instanceof Cell) {
            return ((Cell)owner()).position();
        } else if( owner() instanceof Unit ) {
            return ((Unit)owner()).position();
        } else {
            throw new RuntimeException();
        }
    }

    // ------------------------- Соседи ------------------------------

	// Является ли юнит соседним
    public boolean isNeighbor(Unit other) {
        return position().isNeighbor( other.position() );
    }
}

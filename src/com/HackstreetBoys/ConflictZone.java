package com.HackstreetBoys;

public class ConflictZone extends Atributes {
    private int ID;
    private boolean conflict = false;

    public ConflictZone(int ID, boolean conflict, String description) {
        super(description);
        this.ID = ID;
        this.conflict = conflict;
    }

    public void setConflict() {
        this.conflict = true;
    }

    public void unsetConflict() {
        this.conflict = false;
    }

    public boolean isConflict() {
        return conflict;
    }
}

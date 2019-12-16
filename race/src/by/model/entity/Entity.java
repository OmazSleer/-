package by.model.entity;

/**
 *  Base entity for classes.
 *  <p>Provides uniq identifier</p>
 *
 *  @author  Rowan Morrison
 *  @version 1.0
 */
public abstract class Entity {
    /**
     * Identifier.
     * Must be uniq, so there is no possible to change it after initialization.
     */
    private int id;

    /**
     * @return entity's identifier
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the uniq identifier of this {@code BaseEntity}.
     * @param identifier uniq identifier.
     */
    public void setId(final int identifier) {
        this.id = identifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return id == entity.id;
    }

    @Override
    public int hashCode() {
        return 21*id;
    }

    @Override
    public String toString() {
        return "Id: " + id;
    }
}

package javaapp.Pessoa;

public class Contacto {
    private long number;

    public Contacto(long number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "[" +
                "number: " + number +
                ']';
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }
}

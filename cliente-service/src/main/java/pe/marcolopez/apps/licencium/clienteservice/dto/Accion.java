package pe.marcolopez.apps.licencium.clienteservice.dto;

public enum Accion {

    CREATED(1),
    UPDATED(2),
    DELETED(3);

    private final Integer value;

    Accion(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}

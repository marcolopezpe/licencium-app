package pe.marcolopez.apps.licencium.licenciaservice.dto;

public enum Accion {

    CREATED(1),
    UPDATED(2),
    DELETED(3),
    GENERATED(4);

    private final Integer value;

    Accion(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}

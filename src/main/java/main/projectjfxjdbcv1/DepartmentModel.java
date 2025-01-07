package main.projectjfxjdbcv1;

import java.io.Serializable;
import java.util.Objects;

public class DepartmentModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String gerente;
    private String coordenador;

    public DepartmentModel() {

    }

    public DepartmentModel(Integer id, String name, String gerente, String coordenador) {
        this.id = id;
        this.name = name;
        this.gerente = gerente;
        this.coordenador = coordenador;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(String coordenador) {
        this.coordenador = coordenador;
    }

    public String getGerente() {
        return gerente;
    }

    public void setGerente(String gerente) {
        this.gerente = gerente;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof DepartmentModel that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "DepartmentModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gerente='" + gerente + '\'' +
                ", coordenador='" + coordenador + '\'' +
                '}';
    }
}

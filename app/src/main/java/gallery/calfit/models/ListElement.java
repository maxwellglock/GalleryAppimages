package gallery.calfit.models;

import java.io.Serializable;

public class ListElement implements Serializable {
    public String name;
    public String tipocomida;
    public String dificultad;
    public Integer icono;
    private String tittle;
    private String porcion;
    private String descripcion;
    private String ingredientes;
    private String preparacion;
    private int IconoI;

    //luego agregar también la linea de la imagen


    public ListElement (int icono, String name, String tipocomida, String dificultad, String ingredientes, String preparacion, int IconoI) {
        this.icono = icono;
        this.name = name;
        this.tipocomida = tipocomida;
        this.dificultad = dificultad;
        this.ingredientes = ingredientes;
        this.preparacion = preparacion;
        this.IconoI = IconoI;


    }


    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getTipocomida () {
        return tipocomida;
    }

    public void setTipocomida (String tipocomida) {
        this.tipocomida = tipocomida;
    }

    public String getDificultad () {
        return dificultad;
    }

    public void setDificultad (String dificultad) {
        this.dificultad = dificultad;
    }

    ///

    public Integer getIcono () {
        return icono;
    }

    public void setIcono (Integer icono) {
        this.icono = icono;
    }


    public String getTittle () {
        return tittle;
    }

    public void setTittle (String tittle) {
        this.tittle = tittle;
    }

    public String getPorcion () {
        return porcion;
    }

    public void setPorcion (String porcion) {
        this.porcion = porcion;
    }

    public String getDescripcion () {
        return descripcion;
    }

    public void setDescripcion (String descripcion) {
        this.descripcion = descripcion;
    }

    public CharSequence getIngredientes () {
        return  ingredientes;
    }

    public void setIngredientes (String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public CharSequence getPreparacion () {
        return preparacion;
    }

    public void setPreparacion (String preparacion) {
        this.preparacion = preparacion;
    }

    public Integer getIconoI () {
        return IconoI;
    }

    public void setIconoI (Integer iconoI) {
        IconoI = iconoI;
    }
    //crear nuevas etiquetas para ingredientes y preparación
    }

package com.example.spinnerpersonalizado;

public class ItemData {

    private String txtCategoria;
    private String txtDescripcion;
    private Integer imageId;

    public ItemData(String cat, String desc, Integer ImageId){
        this.txtCategoria = cat;
        this.txtDescripcion = desc;
        this.imageId = ImageId;
    }

    public String getTextCategoria() {
        return txtCategoria;
    }

    public void setTextCategoria(String textCategoria) {
        this.txtCategoria = textCategoria;
    }

    public String getTextDescripcion() {
        return txtDescripcion;
    }

    public void setTextDescripcion(String textDescripcion) {
        this.txtDescripcion = textDescripcion;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }
}

package com.example.listapersonalizada;

public class ItemData {
    private String txtNombre;
    private String txtDescripcion;
    private Integer imageId;
    private Integer colorId;

    public ItemData(String cat, String desc, Integer ImageId, Integer ColorId){
        this.txtNombre = cat;
        this.txtDescripcion = desc;
        this.imageId = ImageId;
        this.colorId = ColorId;
    }

    public String getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(String txtNombre) {
        this.txtNombre = txtNombre;
    }

    public String getTxtDescripcion() {
        return txtDescripcion;
    }

    public void setTxtDescripcion(String txtDescripcion) {
        this.txtDescripcion = txtDescripcion;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public Integer getColorId() {
        return colorId;
    }

    public void setColorId(Integer colorId) {
        this.colorId = colorId;
    }
}

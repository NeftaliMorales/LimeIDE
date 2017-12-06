package lime.ide;

public class Proyecto{
    
    private String rutaProyecto;
    private String nombreProyecto;
    
    public Proyecto(String rutaP, String nombreP) {
        this.nombreProyecto = nombreP;
        this.rutaProyecto = rutaP;
    }
//GET---------------------------------------------------------------------------
    public String getRutaProyecto() {
        return rutaProyecto;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }
//SET---------------------------------------------------------------------------
    public void setRutaProyecto(String rutaProyecto) {
        this.rutaProyecto = rutaProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }
}

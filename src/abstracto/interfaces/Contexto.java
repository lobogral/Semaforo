package abstracto.interfaces;

public interface Contexto {
    public void setEstado(Estado estado);
    public void solicitar(String orden);
}

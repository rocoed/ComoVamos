package comovamos;
/*
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "com_usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComUsuarios.findAll", query = "SELECT c FROM ComUsuarios c"),
    @NamedQuery(name = "ComUsuarios.findByUSUid", query = "SELECT c FROM ComUsuarios c WHERE c.uSUid = :uSUid"),
    @NamedQuery(name = "ComUsuarios.findByUSUusuario", query = "SELECT c FROM ComUsuarios c WHERE c.uSUusuario = :uSUusuario"),
    @NamedQuery(name = "ComUsuarios.findByUSUcontrase\u00f1a", query = "SELECT c FROM ComUsuarios c WHERE c.uSUcontrase\u00f1a = :uSUcontrase\u00f1a"),
    @NamedQuery(name = "ComUsuarios.findByUSUnombreCompleto", query = "SELECT c FROM ComUsuarios c WHERE c.uSUnombreCompleto = :uSUnombreCompleto"),
    @NamedQuery(name = "ComUsuarios.findByUSUdirecci\u00f3n", query = "SELECT c FROM ComUsuarios c WHERE c.uSUdirecci\u00f3n = :uSUdirecci\u00f3n"),
    @NamedQuery(name = "ComUsuarios.findByUSUtel\u00e9fono", query = "SELECT c FROM ComUsuarios c WHERE c.uSUtel\u00e9fono = :uSUtel\u00e9fono"),
    @NamedQuery(name = "ComUsuarios.findByUSUcorreo", query = "SELECT c FROM ComUsuarios c WHERE c.uSUcorreo = :uSUcorreo")})
public class ComUsuarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "USU_id")
    private Integer uSUid;
    @Basic(optional = false)
    @Column(name = "USU_usuario")
    private String uSUusuario;
    @Basic(optional = false)
    @Column(name = "USU_contrase\u00f1a")
    private String uSUcontraseña;
    @Column(name = "USU_nombreCompleto")
    private String uSUnombreCompleto;
    @Column(name = "USU_direcci\u00f3n")
    private String uSUdirección;
    @Column(name = "USU_tel\u00e9fono")
    private String uSUteléfono;
    @Column(name = "USU_correo")
    private String uSUcorreo;
    @JoinColumn(name = "USU_PreguntaSecreta", referencedColumnName = "PRE_id")
    @ManyToOne(optional = false)
    private ComPreguntassecretas uSUPreguntaSecreta;
    @JoinColumn(name = "USU_Perfiles", referencedColumnName = "PERF_id")
    @ManyToOne(optional = false)
    private ComPerfiles uSUPerfiles;

    public ComUsuarios() {
    }

    public ComUsuarios(Integer uSUid) {
        this.uSUid = uSUid;
    }

    public ComUsuarios(Integer uSUid, String uSUusuario, String uSUcontraseña) {
        this.uSUid = uSUid;
        this.uSUusuario = uSUusuario;
        this.uSUcontraseña = uSUcontraseña;
    }

    public Integer getUSUid() {
        return uSUid;
    }

    public void setUSUid(Integer uSUid) {
        this.uSUid = uSUid;
    }

    public String getUSUusuario() {
        return uSUusuario;
    }

    public void setUSUusuario(String uSUusuario) {
        this.uSUusuario = uSUusuario;
    }

    public String getUSUcontraseña() {
        return uSUcontraseña;
    }

    public void setUSUcontraseña(String uSUcontraseña) {
        this.uSUcontraseña = uSUcontraseña;
    }

    public String getUSUnombreCompleto() {
        return uSUnombreCompleto;
    }

    public void setUSUnombreCompleto(String uSUnombreCompleto) {
        this.uSUnombreCompleto = uSUnombreCompleto;
    }

    public String getUSUdirección() {
        return uSUdirección;
    }

    public void setUSUdirección(String uSUdirección) {
        this.uSUdirección = uSUdirección;
    }

    public String getUSUteléfono() {
        return uSUteléfono;
    }

    public void setUSUteléfono(String uSUteléfono) {
        this.uSUteléfono = uSUteléfono;
    }

    public String getUSUcorreo() {
        return uSUcorreo;
    }

    public void setUSUcorreo(String uSUcorreo) {
        this.uSUcorreo = uSUcorreo;
    }

    public ComPreguntassecretas getUSUPreguntaSecreta() {
        return uSUPreguntaSecreta;
    }

    public void setUSUPreguntaSecreta(ComPreguntassecretas uSUPreguntaSecreta) {
        this.uSUPreguntaSecreta = uSUPreguntaSecreta;
    }

    public ComPerfiles getUSUPerfiles() {
        return uSUPerfiles;
    }

    public void setUSUPerfiles(ComPerfiles uSUPerfiles) {
        this.uSUPerfiles = uSUPerfiles;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uSUid != null ? uSUid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComUsuarios)) {
            return false;
        }
        ComUsuarios other = (ComUsuarios) object;
        if ((this.uSUid == null && other.uSUid != null) || (this.uSUid != null && !this.uSUid.equals(other.uSUid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "taller2.ComUsuarios[ uSUid=" + uSUid + " ]";
    }
    
}
*/
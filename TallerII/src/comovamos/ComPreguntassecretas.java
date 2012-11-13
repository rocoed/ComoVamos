/*
package comovamos;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "com_preguntassecretas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComPreguntassecretas.findAll", query = "SELECT c FROM ComPreguntassecretas c"),
    @NamedQuery(name = "ComPreguntassecretas.findByPREid", query = "SELECT c FROM ComPreguntassecretas c WHERE c.pREid = :pREid"),
    @NamedQuery(name = "ComPreguntassecretas.findByPREpregunta", query = "SELECT c FROM ComPreguntassecretas c WHERE c.pREpregunta = :pREpregunta"),
    @NamedQuery(name = "ComPreguntassecretas.findByPRErespuesta", query = "SELECT c FROM ComPreguntassecretas c WHERE c.pRErespuesta = :pRErespuesta")})
public class ComPreguntassecretas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PRE_id")
    private Integer pREid;
    @Column(name = "PRE_pregunta")
    private String pREpregunta;
    @Column(name = "PRE_respuesta")
    private String pRErespuesta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "uSUPreguntaSecreta")
    private Collection<ComUsuarios> comUsuariosCollection;

    public ComPreguntassecretas() {
    }

    public ComPreguntassecretas(Integer pREid) {
        this.pREid = pREid;
    }

    public Integer getPREid() {
        return pREid;
    }

    public void setPREid(Integer pREid) {
        this.pREid = pREid;
    }

    public String getPREpregunta() {
        return pREpregunta;
    }

    public void setPREpregunta(String pREpregunta) {
        this.pREpregunta = pREpregunta;
    }

    public String getPRErespuesta() {
        return pRErespuesta;
    }

    public void setPRErespuesta(String pRErespuesta) {
        this.pRErespuesta = pRErespuesta;
    }

    @XmlTransient
    public Collection<ComUsuarios> getComUsuariosCollection() {
        return comUsuariosCollection;
    }

    public void setComUsuariosCollection(Collection<ComUsuarios> comUsuariosCollection) {
        this.comUsuariosCollection = comUsuariosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pREid != null ? pREid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComPreguntassecretas)) {
            return false;
        }
        ComPreguntassecretas other = (ComPreguntassecretas) object;
        if ((this.pREid == null && other.pREid != null) || (this.pREid != null && !this.pREid.equals(other.pREid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "taller2.ComPreguntassecretas[ pREid=" + pREid + " ]";
    }
    
}

 */
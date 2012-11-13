/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package comovamos;
/*
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
import javax.swing.text.html.parser.Entity;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "com_perfiles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComPerfiles.findAll", query = "SELECT c FROM ComPerfiles c"),
    @NamedQuery(name = "ComPerfiles.findByPERFid", query = "SELECT c FROM ComPerfiles c WHERE c.pERFid = :pERFid"),
    @NamedQuery(name = "ComPerfiles.findByPERFnombre", query = "SELECT c FROM ComPerfiles c WHERE c.pERFnombre = :pERFnombre")})
public class ComPerfiles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PERF_id")
    private Integer pERFid;
    @Column(name = "PERF_nombre")
    private String pERFnombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "uSUPerfiles")
    private Collection<ComUsuarios> comUsuariosCollection;

    public ComPerfiles() {
    }

    public ComPerfiles(Integer pERFid) {
        this.pERFid = pERFid;
    }

    public Integer getPERFid() {
        return pERFid;
    }

    public void setPERFid(Integer pERFid) {
        this.pERFid = pERFid;
    }

    public String getPERFnombre() {
        return pERFnombre;
    }

    public void setPERFnombre(String pERFnombre) {
        this.pERFnombre = pERFnombre;
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
        hash += (pERFid != null ? pERFid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComPerfiles)) {
            return false;
        }
        ComPerfiles other = (ComPerfiles) object;
        if ((this.pERFid == null && other.pERFid != null) || (this.pERFid != null && !this.pERFid.equals(other.pERFid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "taller2.ComPerfiles[ pERFid=" + pERFid + " ]";
    }
    
}
*/
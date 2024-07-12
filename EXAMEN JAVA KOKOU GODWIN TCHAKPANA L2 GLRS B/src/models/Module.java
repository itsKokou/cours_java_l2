package models;

public class Module {
    private static int nbreM;
    private int id;
    private String libelle;

    public Module(String libelle) {
        nbreM +=1; 
        id = nbreM;
        this.libelle = libelle;
    }

    public Module() {
        nbreM +=1; 
        id = nbreM;
    }

    public static int getNbreM() {
        return nbreM;
    }

    public static void setNbreM(int nbreM) {
        Module.nbreM = nbreM;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }
    
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "Module [id=" + id + ", libelle=" + libelle + "]";
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Module other = (Module) obj;
        if (libelle == null) {
            if (other.libelle != null)
                return false;
        } else if (!libelle.equals(other.libelle))
            return false;
        return true;
    }

    
    
}

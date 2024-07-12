package models;

public class Permission {
    private static int nbreP;
    private int id;
    private String libelle;
    
    public Permission() {
        nbreP = nbreP +1;
        id = nbreP;
    }
    
    public Permission(String libelle) {
        nbreP = nbreP +1;
        id = nbreP;
        this.libelle = libelle;
    }

    public static int getNbreP() {
        return nbreP;
    }
    public static void setNbreP(int nbreP) {
        Permission.nbreP = nbreP;
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
        return "Permission [id=" + id + ", libelle=" + libelle + "]";
    }
  
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Permission other = (Permission) obj;
        if (libelle == null) {
            if (other.libelle != null)
                return false;
        } else if (!libelle.equals(other.libelle))
            return false;
        return true;
    }

    
}

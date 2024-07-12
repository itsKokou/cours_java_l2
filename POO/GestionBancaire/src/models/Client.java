package models;

public class Client {
    
    private int id;
    private String nomComplet;
    private String tel;


    //Attribut navigationnel
    private final int N=10;
    private Compte[] tabComptes=new Compte[N];
    private int nbrCompte;

    public void addCompte(Compte compte){
        tabComptes[nbrCompte]=compte;
        nbrCompte++;

    }

    public Compte[] getTabComptes() {
        return tabComptes;
    }

    public Client(int id, String nomComplet, String tel) {
        this.id = id;
        this.nomComplet = nomComplet;
        this.tel = tel;
    }
    public Client() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNomComplet() {
        return nomComplet;
    }
    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    @Override
    public String toString() {
        return "Client [id=" + id + ", nomComplet=" + nomComplet + ", tel=" + tel + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((nomComplet == null) ? 0 : nomComplet.hashCode());
        result = prime * result + ((tel == null) ? 0 : tel.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Client other = (Client) obj;
        if (id != other.id)
            return false;
        if (nomComplet == null) {
            if (other.nomComplet != null)
                return false;
        } else if (!nomComplet.equals(other.nomComplet))
            return false;
        if (tel == null) {
            if (other.tel != null)
                return false;
        } else if (!tel.equals(other.tel))
            return false;
        return true;
    }

}

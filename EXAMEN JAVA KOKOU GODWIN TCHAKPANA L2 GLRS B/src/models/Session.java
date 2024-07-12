package models;

public class Session {
    private static int nbreS;
    private int id;
    private String date;
    private Salle salle;
    private String heureD;
    private String heureF;

    public Session() {
        nbreS += 1;
        id = nbreS;
    }

    public Session(String date, String heureD, String heureF) {
        nbreS += 1;
        id = nbreS;
        this.date = date;
        this.heureD = heureD;
        this.heureF = heureF;
    }

    public Session(String date, Salle salle, String heureD, String heureF) {
        nbreS += 1;
        id = nbreS;
        this.date = date;
        this.salle = salle;
        this.heureD = heureD;
        this.heureF = heureF;
    }

    public static int getNbreS() {
        return nbreS;
    }

    public static void setNbreS(int nbreS) {
        Session.nbreS = nbreS;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public String getHeureD() {
        return heureD;
    }

    public void setHeureD(String heureD) {
        this.heureD = heureD;
    }

    public String getHeureF() {
        return heureF;
    }

    public void setHeureF(String heureF) {
        this.heureF = heureF;
    }

    @Override
    public String toString() {
        return "Session [id=" + id + ", date=" + date + ", salle=" + salle + ", heureD=" + heureD + ", heureF=" + heureF
                + "]";
    }
    
    

    

    
}

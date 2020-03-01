package test.database.domain;

public class ChildActivity {
    private int caId;
    private int aId;
    private String caName;
    private String caDescription;
    private String caScore;
    private int caDayMaxJoin;
    private boolean caIsAvailable;
    private int flag;
    private String minScore;
    private String maxScore;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getMinScore() {
        return minScore;
    }

    public void setMinScore(String minScore) {
        this.minScore = minScore;
    }

    public String getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(String maxScore) {
        this.maxScore = maxScore;
    }

    public int getCaId() {
        return caId;
    }

    public void setCaId(int caId) {
        this.caId = caId;
    }

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public String getCaName() {
        return caName;
    }

    public void setCaName(String caName) {
        this.caName = caName;
    }

    public String getCaDescription() {
        return caDescription;
    }

    public void setCaDescription(String caDescription) {
        this.caDescription = caDescription;
    }

    public String getCaScore() {
        return caScore;
    }

    public void setCaScore(String caScore) {
        this.caScore = caScore;
    }

    public int getCaDayMaxJoin() {
        return caDayMaxJoin;
    }

    public void setCaDayMaxJoin(int caDayMaxJoin) {
        this.caDayMaxJoin = caDayMaxJoin;
    }

    public boolean isCaIsAvailable() {
        return caIsAvailable;
    }

    public void setCaIsAvailable(boolean caIsAvailable) {
        this.caIsAvailable = caIsAvailable;
    }

    @Override
    public String toString() {
        return "ChildActivity{" +
                "caId=" + caId +
                ", aId=" + aId +
                ", caName='" + caName + '\'' +
                ", caDescription='" + caDescription + '\'' +
                ", caScore='" + caScore + '\'' +
                ", caDayMaxJoin=" + caDayMaxJoin +
                ", caIsAvailable=" + caIsAvailable +
                '}';
    }
}

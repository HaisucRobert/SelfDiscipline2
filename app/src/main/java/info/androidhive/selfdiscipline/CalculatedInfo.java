package info.androidhive.selfdiscipline;

public class CalculatedInfo {
    int _id;
    int greutate;
    int inaltime;
    int varsta;
    String gender;
    String act_level;
    String finalcalories;


    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getGreutate() {
        return greutate;
    }

    public void setGreutate(int greutate) {
        this.greutate = greutate;
    }

    public int getInaltime() {
        return inaltime;
    }

    public void setInaltime(int inaltime) {
        this.inaltime = inaltime;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAct_level() {
        return act_level;
    }

    public void setAct_level(String act_level) {
        this.act_level = act_level;
    }

    public String getFinalcalories() {
        return finalcalories;
    }

    public void setFinalcalories(String finalcalories) {
        this.finalcalories = finalcalories;
    }

    @Override
    public String toString() {
        return "CalculatedInfo{" +
                "_id=" + _id +
                ", greutate=" + greutate +
                ", inaltime=" + inaltime +
                ", varsta=" + varsta +
                ", gender='" + gender + '\'' +
                ", act_level='" + act_level + '\'' +
                ", finalcalories='" + finalcalories + '\'' +
                '}';
    }
}
